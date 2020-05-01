package com.house.jikezu.dao;


import com.house.jikezu.model.HouseReservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseReservationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseReservation record);

    int insertSelective(HouseReservation record);

    HouseReservation selectByPrimaryKey(String houseReservationNum);

    int updateByPrimaryKeySelective(HouseReservation record);

    int updateByPrimaryKey(HouseReservation record);

    List<HouseReservation> listReservations(@Param("tenant") String tenant,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

    int deleteByHouseReservationNum(String houseReservationNum);

    void deleteByReservationHouseNum(String houseNum);

}