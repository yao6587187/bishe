package com.house.jikezu.dao;


import com.house.jikezu.model.House;
import com.house.jikezu.vo.HouseListVo;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String houseNum);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(String houseNum);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> listHouses(String ownUserNum);

    List<House> selectHousesByPage(HouseListVo houseListVo);
}