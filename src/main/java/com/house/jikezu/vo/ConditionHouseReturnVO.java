package com.house.jikezu.vo;

import lombok.Data;

import java.util.List;

@Data
public class ConditionHouseReturnVO {

    List<HouseListReturnVO> resultHouses;

    //是否已加载全部
    Boolean finished = false;
}
