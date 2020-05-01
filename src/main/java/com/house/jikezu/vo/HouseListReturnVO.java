package com.house.jikezu.vo;

import lombok.Data;

@Data
public class HouseListReturnVO {
    /**
     * 房源编号
     */
    private String houseNum;

    private String houseTitle;
    private Integer floor;

    private Integer allFloor;
    private Double area;
    private String unitType;
    private String address;
    private Double rent;
    private Double length;

    private String landlordNum;
}
