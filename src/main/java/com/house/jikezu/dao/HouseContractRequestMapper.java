package com.house.jikezu.dao;


import com.house.jikezu.model.HouseContractRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseContractRequestMapper {
    int deleteByPrimaryKey(String houseContractNum);

    int insert(HouseContractRequest record);

    int insertSelective(HouseContractRequest record);

    HouseContractRequest selectByPrimaryKey(String houseContractNum);

    int updateByPrimaryKeySelective(HouseContractRequest record);

    int updateByPrimaryKey(HouseContractRequest record);

    List<HouseContractRequest> getHouseContractRequestByLandlordNumPage(@Param("userNum") String userNum, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}