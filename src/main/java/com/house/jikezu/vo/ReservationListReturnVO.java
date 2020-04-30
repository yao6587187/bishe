package com.house.jikezu.vo;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationListReturnVO {

    //预约编号
    private String houseReservationNum;
    //房源地址
    private String houseAddress;
    //预约人名称
    private String reservationUserName;
    //预约人手机
    private String reservationUserMobile;
    //看房时间
    private Date reservationDate;
}

