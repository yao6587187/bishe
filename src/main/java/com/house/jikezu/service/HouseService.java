package com.house.jikezu.service;

import com.house.jikezu.model.House;
import com.house.jikezu.vo.HouseListReturnVO;
import com.house.jikezu.vo.HouseListVo;

import java.util.List;

public interface HouseService {

    /**
     * 添加房源
     *
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

    /**
     * 租房列表
     */
    List<HouseListReturnVO> selectHousesByPage(HouseListVo houseListVo, Integer currentPage, Integer pageSize);

}
