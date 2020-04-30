package com.house.jikezu.dao;


import com.house.jikezu.model.House;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(String houseNum);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> listHouses(String ownUserNum);
}