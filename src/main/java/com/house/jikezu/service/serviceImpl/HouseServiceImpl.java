package com.house.jikezu.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.service.HouseService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.HouseListReturnVO;
import com.house.jikezu.vo.HouseListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseMapper houseMapper;

    @Override
    public String addHouse(House house) {
        house.setHouseNum(OrderUtil.getOrderNoByUUID("H"));
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
//        PageHelper.startPage(currentPage, pageSize);
        List<House> houses = houseMapper.selectHousesByPage(houseListVo);
        List<HouseListReturnVO> houseListReturnVOs = new ArrayList<>();
        HouseListReturnVO houseListReturnVO;
        for (House h : houses) {
            houseListReturnVO = new HouseListReturnVO();
            houseListReturnVO.setHouseNum(h.getHouseNum());
            houseListReturnVO.setHouseTitle(h.getHouseTitle());
            houseListReturnVO.setFloor(h.getFloor());
            houseListReturnVO.setAllFloor(h.getAllFloor());
            houseListReturnVO.setArea(h.getArea());
            houseListReturnVO.setUnitType(h.getUnitType());
            houseListReturnVO.setAddress(h.getProvince() + h.getCity() + h.getRegion() + h.getDescAddress() + h.getBuilding() + h.getUnit());
            houseListReturnVO.setRent(h.getRent());

        }
        return null;
    }
}
