package com.house.jikezu.service;

import com.house.jikezu.vo.ReservationListReturnVO;
import com.house.jikezu.vo.ReservationVO;

import java.util.List;

public interface ReservationHouseService {

    /**
     * 预约操作
     * @param houseNum
     * @param tenantNum
     * @param landlordNum
     * @return
     */
    String reservation(ReservationVO reservationVO);

    /**
     * 我的预约查询
     *
     * @param tenantNum
     * @return
     */
    List<ReservationListReturnVO> listReservationHouses(String landlordNum);

    /**
     * 删除预约
     *
     * @param houseReservationNum 预约编号
     * @return
     */
    Integer deleteByHouseReservationNum(String houseReservationNum);

}
