package com.house.jikezu.service;

import com.house.jikezu.model.House;

import java.util.List;

/**
 * 发布房源
 */
public interface ReleaseHouseService {

    String release(String houseNum,String landlordNum);

    List<House> listReleaseHouses(String landlordNum);
}
