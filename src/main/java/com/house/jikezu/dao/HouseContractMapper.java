package com.house.jikezu.dao;


import com.house.jikezu.model.HouseContract;

import java.util.List;

public interface HouseContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseContract record);

    int insertSelective(HouseContract record);

    HouseContract selectByPrimaryKey(String houseContractNum);

    int updateByPrimaryKeySelective(HouseContract record);

    int updateByPrimaryKey(HouseContract record);

    List<HouseContract> listHouseContract(String userNum);
}