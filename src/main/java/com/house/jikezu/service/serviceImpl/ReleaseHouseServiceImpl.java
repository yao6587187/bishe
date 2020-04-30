package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseReleaseMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseRelease;
import com.house.jikezu.service.ReleaseHouseService;
import com.house.jikezu.util.OrderUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseHouseServiceImpl implements ReleaseHouseService {

    @Resource
    private HouseReleaseMapper houseReleaseMapper;

    @Resource
    private HouseMapper houseMapper;

    @Override
    public String release(String houseNum, String landlordNum) {
        HouseRelease release = new HouseRelease();
        release.setHouseReleaseNum(OrderUtil.getOrderNoByUUID("R"));
        release.setReleaseHouseNum(houseNum);
        release.setReleaseUserNum(landlordNum);
        houseReleaseMapper.insert(release);
        return release.getHouseReleaseNum();
    }

    @Override
    public List<House> listReleaseHouses(String landlordNum) {
        List<HouseRelease> houseReleases = houseReleaseMapper.listReleaseHouses(landlordNum);
        List<House> houses = new ArrayList<>();
        for (HouseRelease houseRelease : houseReleases
        ) {
            houses.add(houseMapper.selectByPrimaryKey(houseRelease.getReleaseHouseNum()));
        }
        return houses;
    }
}
