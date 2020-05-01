package com.house.jikezu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HouseContractRequestVO {

    String contractRequestNum;
    String houseContractNum;
    String requestType;
    String requestPersonName;
    Date contractExpireDate;
    String houseAddress;

}
