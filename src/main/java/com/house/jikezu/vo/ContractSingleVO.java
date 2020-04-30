package com.house.jikezu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContractSingleVO {

    String houseReservationNum;
    Integer month;
    Date effectDate;
    String landlordNum;
    String tenantNum;
}
