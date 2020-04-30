package com.house.jikezu.service;

import com.house.jikezu.model.House;

import java.util.List;

public interface HouseService {

    /**
     * 添加房源
     * @param house
     * @return
     */
    String addHouse(House house);

    /**
     * 我的房源
     */
    List<House> listHouses(String userNum);

    /**
     * 查询房源详情
     */
    House getHouse(String houseNum);


}
