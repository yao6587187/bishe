package com.house.jikezu.vo;


import lombok.Data;

import java.util.Date;

@Data
public class ContractInfoVO {
    private String landlordName;
    private String landlordIdNum;
    private String telnantName;
    private String telnantIdNum;
    private String province;
    private String city;
    private String regin;
    private Integer buildings;
    private Integer unit;
    private String area;
    private Date beginDate;
    private Date endDate;
    private String landlordPhoneNum;
    private String telnantPhontNum;
}
