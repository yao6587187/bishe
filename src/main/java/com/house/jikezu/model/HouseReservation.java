package com.house.jikezu.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-04-29
 */
public class HouseReservation {
    private Integer id;

    private String houseReservationNum;

    /**
     * 租客编号
     */
    private String reservationTenantNum;

    /**
     * 房东编号
     */
    private String reservationLandlordNum;

    private String reservationHouseNum;

    /**
     * 预约时间
     */
    private Date reservationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseReservationNum() {
        return houseReservationNum;
    }

    public void setHouseReservationNum(String houseReservationNum) {
        this.houseReservationNum = houseReservationNum == null ? null : houseReservationNum.trim();
    }

    public String getReservationTenantNum() {
        return reservationTenantNum;
    }

    public void setReservationTenantNum(String reservationTenantNum) {
        this.reservationTenantNum = reservationTenantNum == null ? null : reservationTenantNum.trim();
    }

    public String getReservationLandlordNum() {
        return reservationLandlordNum;
    }

    public void setReservationLandlordNum(String reservationLandlordNum) {
        this.reservationLandlordNum = reservationLandlordNum == null ? null : reservationLandlordNum.trim();
    }

    public String getReservationHouseNum() {
        return reservationHouseNum;
    }

    public void setReservationHouseNum(String reservationHouseNum) {
        this.reservationHouseNum = reservationHouseNum == null ? null : reservationHouseNum.trim();
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}