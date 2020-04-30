package com.house.jikezu.dao;


import com.house.jikezu.model.HouseUser;

public interface HouseUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseUser record);

    int insertSelective(HouseUser record);

    HouseUser selectByPrimaryKey(String userNum);

    int updateByPrimaryKeySelective(HouseUser record);

    int updateByPrimaryKey(HouseUser record);
}