package com.house.jikezu.dao;


import com.house.jikezu.model.HouseContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseContractMapper {
    int deleteByPrimaryKey(String houseContractNum);

    int insert(HouseContract record);

    int insertSelective(HouseContract record);

    HouseContract selectByPrimaryKey(String houseContractNum);

    int updateByPrimaryKeySelective(HouseContract record);

    int updateByPrimaryKey(HouseContract record);

    List<HouseContract> listHouseContract(@Param("userNum")String userNum, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}