package com.house.jikezu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContractVO {

    private String contractNum;

    private String landlordName;

    private String tenantName;

    private Date effectTime;

    private Integer monthNum;

    private String houseAddress;

    private String houseNum;

    private String houseTenantNum;

    private String houseLandlordNum;

}
