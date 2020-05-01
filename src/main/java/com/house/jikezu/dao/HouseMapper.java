package com.house.jikezu.dao;


import com.house.jikezu.model.House;
import com.house.jikezu.vo.HouseListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String houseNum);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(String houseNum);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> listHouses(@Param("ownUserNum") String ownUserNum,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

    List<House> selectHousesByPage(HouseListVo houseListVo);
}