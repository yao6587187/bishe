package com.house.jikezu.dao;


import com.house.jikezu.model.HouseRelease;

import java.util.List;

public interface HouseReleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseRelease record);

    int insertSelective(HouseRelease record);

    HouseRelease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRelease record);

    int updateByPrimaryKey(HouseRelease record);

    List<HouseRelease> listReleaseHouses(String landlordNum);

    List<HouseRelease> listAllReleaseHousesExcMe(String landlordNum);
}