package com.house.jikezu.vo;

import java.util.Date;

public class ReservationVO {

    private String houseNum;
    private String tenantNum;
    private String landlordNum;
    private Date reservationDate;

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public void setTenantNum(String tenantNum) {
        this.tenantNum = tenantNum;
    }

    public void setLandlordNum(String landlordNum) {
        this.landlordNum = landlordNum;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getTenantNum() {
        return tenantNum;
    }

    public String getLandlordNum() {
        return landlordNum;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

}
