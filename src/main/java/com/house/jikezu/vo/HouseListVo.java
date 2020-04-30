package com.house.jikezu.vo;

import lombok.Data;

@Data
public class HouseListVo {

    private String ownUserNum;
    private String province;
    private String city;
    private String region;
    //详细地址
    private String descAddress;
    private Double maxArea;
    private Double minArea;
    private Double maxRent;
    private Double minRent;
    private String rentType;
    //用户x座标
    private Double xPosition;
    //用户y座标
    private Double yPosition;

    private Integer currentPage;

    private Integer pageSize;
}
