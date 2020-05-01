package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseReleaseMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseRelease;
import com.house.jikezu.service.ReleaseHouseService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReleaseHouseServiceImpl implements ReleaseHouseService {

    @Resource
    private HouseReleaseMapper houseReleaseMapper;

    @Resource
    private HouseMapper houseMapper;

    @Override
    public String release(String houseNum, String landlordNum) {
        HouseRelease release = houseReleaseMapper.getHouseReleaseByHouseNum(houseNum);
        if (release != null){
            return "existed";
        }
        release = new HouseRelease();
        release.setHouseReleaseNum(OrderUtil.getOrderNoByUUID("R"));
        release.setReleaseHouseNum(houseNum);
        release.setReleaseUserNum(landlordNum);
        houseReleaseMapper.insert(release);
        return release.getHouseReleaseNum();
    }

    @Override
    public PageData<List<House>> listReleaseHouses(String landlordNum, Integer currentPage, Integer pageSize) {
        PageData<List<House>> pageData = new PageData<>();
        List<House> houses = houseReleaseMapper.listReleaseHouseByLandlordNumPage(landlordNum,
                (currentPage-1)*pageSize,pageSize);
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        pageData.setDatas(houses);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0){
            pageData.setFinished(false);
        }
        return pageData;
    }
}
