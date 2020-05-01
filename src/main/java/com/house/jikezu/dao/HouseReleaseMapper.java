package com.house.jikezu.dao;


import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseRelease;
import com.house.jikezu.model.HouseReservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseReleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseRelease record);

    int insertSelective(HouseRelease record);

    HouseRelease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRelease record);

    int updateByPrimaryKey(HouseRelease record);

    List<HouseRelease> listReleaseHouses(String landlordNum);

    HouseRelease getHouseReleaseByHouseNum(String houseReleaseNum);

    List<HouseRelease> listAllReleaseHousesExcMe(String landlordNum);

    void deleteByReleaseHouseNum(String houseNum);

    List<House> listReleaseHouseByLandlordNumPage(@Param("landlordNum") String landlordNum, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}