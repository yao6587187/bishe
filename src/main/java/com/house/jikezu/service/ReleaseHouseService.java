package com.house.jikezu.service;

import com.house.jikezu.model.House;
import com.house.jikezu.vo.PageData;

import java.util.List;

/**
 * 发布房源
 */
public interface ReleaseHouseService {

    String release(String houseNum,String landlordNum);

    PageData<List<House>> listReleaseHouses(String landlordNum, Integer currentPage, Integer pageSize);
}
