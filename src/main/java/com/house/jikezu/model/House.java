package com.house.jikezu.model;

import com.house.jikezu.enums.HouseStatusEnum;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-04-29
 */
public class House {
    private Integer id;

    /**
     * 房源编号
     */
    private String houseNum;

    private String houseTitle;

    /**
     * 房子状态
     */
    private String status;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    private String descAddress;

    private Integer building;

    private Integer unit;

    /**
     * 租金
     */
    private Double rent;

    private String rentType;

    private String unitType;

    private String area;

    private Integer floor;

    private Integer allFloor;

    /**
     * 配套设施
     */
    private String supportingFacilities;

    private String houseDesc;

    private String contactPerson;

    private String phoneNum;

    private String photosAddress;

    /**
     * x坐标
     */
    private Double xPosition;

    /**
     * y坐标
     */
    private Double yPosition;

    private String ownUserNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum == null ? null : houseNum.trim();
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle == null ? null : houseTitle.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? HouseStatusEnum.NotRENT.getHouseStatus() : status.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getDescAddress() {
        return descAddress;
    }

    public void setDescAddress(String descAddress) {
        this.descAddress = descAddress == null ? null : descAddress.trim();
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getAllFloor() {
        return allFloor;
    }

    public void setAllFloor(Integer allFloor) {
        this.allFloor = allFloor;
    }

    public String getSupportingFacilities() {
        return supportingFacilities;
    }

    public void setSupportingFacilities(String supportingFacilities) {
        this.supportingFacilities = supportingFacilities == null ? null : supportingFacilities.trim();
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc == null ? null : houseDesc.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getPhotosAddress() {
        return photosAddress;
    }

    public void setPhotosAddress(String photosAddress) {
        this.photosAddress = photosAddress == null ? null : photosAddress.trim();
    }

    public Double getxPosition() {
        return xPosition;
    }

    public void setxPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public Double getyPosition() {
        return yPosition;
    }

    public void setyPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public String getOwnUserNum() {
        return ownUserNum;
    }

    public void setOwnUserNum(String ownUserNum) {
        this.ownUserNum = ownUserNum == null ? null : ownUserNum.trim();
    }
}