package com.house.jikezu.dao;


import com.house.jikezu.model.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(String infoNum);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(String infoNum);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    List<Info> listAllInfo(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    List<Info> listMyInfo(String userNum, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}