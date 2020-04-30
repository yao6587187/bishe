package com.house.jikezu.enums;

public enum HouseStatusEnum {

    NotRENT("NOTRENT","未出租"),
    RENTED("RENTED","已出租");

    private String houseStatus;

    private String name;

    HouseStatusEnum(String houseStatus,String name){
        this.houseStatus = houseStatus;
        this.name = name;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public String getName() {
        return name;
    }
}
