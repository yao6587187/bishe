package com.house.jikezu.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseReleaseMapper;
import com.house.jikezu.enums.HouseStatusEnum;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseRelease;
import com.house.jikezu.service.HouseService;
import com.house.jikezu.util.MapUtils;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.HouseListReturnVO;
import com.house.jikezu.vo.HouseListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseMapper houseMapper;
    @Resource
    private HouseReleaseMapper houseReleaseMapper;

    @Override
    public String addHouse(House house) {
        house.setHouseNum(OrderUtil.getOrderNoByUUID("H"));
        house.setStatus(HouseStatusEnum.NotRENT.getHouseStatus());
        houseMapper.insert(house);
        return house.getHouseNum();
    }

    @Override
    public List<House> listHouses(String userNum) {
        return houseMapper.listHouses(userNum);
    }

    @Override
    public House getHouse(String houseNum) {
        return houseMapper.selectByPrimaryKey(houseNum);
    }

    @Override
    public List<HouseListReturnVO> selectHousesByPage(HouseListVo houseListVo, Integer currentPage, Integer pageSize) {
        List<House> houses = houseMapper.selectHousesByPage(houseListVo);
        List<HouseListReturnVO> houseListReturnVOs = new ArrayList<>();
        for (House h : houses) {
            HouseListReturnVO houseListReturnVO = new HouseListReturnVO();
            houseListReturnVO.setHouseNum(h.getHouseNum());
            houseListReturnVO.setHouseTitle(h.getHouseTitle());
            houseListReturnVO.setFloor(h.getFloor());
            houseListReturnVO.setAllFloor(h.getAllFloor());
            houseListReturnVO.setArea(h.getArea());
            houseListReturnVO.setUnitType(h.getUnitType());
            houseListReturnVO.setAddress(h.getProvince() + h.getCity() + h.getRegion() + h.getDescAddress() + h.getBuilding() + h.getUnit());
            houseListReturnVO.setRent(h.getRent());
            houseListReturnVO.setLength(MapUtils.GetDistance(houseListVo.getXPosition(), houseListVo.getYPosition(),
                    h.getxPosition(), h.getyPosition()));
            houseListReturnVOs.add(houseListReturnVO);
        }
        List<HouseListReturnVO> returnVOS =
                houseListReturnVOs.stream().sorted(Comparator.comparing(HouseListReturnVO::getLength)).collect(Collectors.toList());
        List<HouseListReturnVO> VOS = new ArrayList<>();
        currentPage = (currentPage - 1) * pageSize;
        if (currentPage + 1 > returnVOS.size()) {
            return null;
        }
        if (currentPage + pageSize + 1 > returnVOS.size()) {
            for (int i = currentPage; i < returnVOS.size(); i++) {
                VOS.add(returnVOS.get(i));
            }
        } else {
            for (int i = currentPage; i < currentPage + pageSize; i++) {
                VOS.add(returnVOS.get(i));
            }
        }
        return VOS;
    }
}
