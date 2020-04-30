package com.house.jikezu.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-04-29
 */
public class HouseContract {
    private Integer id;

    /**
     * 合同编号
     */
    private String houseContractNum;

    /**
     * 房源编号
     */
    private String houseNum;

    /**
     * 租房时长，月为单位
     */
    private Integer durationMonth;

    /**
     * 房东编号
     */
    private String houseLandlordNum;

    /**
     * 房客编号
     */
    private String houseTenantNum;

    /**
     * 合同生效时间
     */
    private Date contraceEffectiveDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseContractNum() {
        return houseContractNum;
    }

    public void setHouseContractNum(String houseContractNum) {
        this.houseContractNum = houseContractNum == null ? null : houseContractNum.trim();
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum == null ? null : houseNum.trim();
    }

    public Integer getDurationMonth() {
        return durationMonth;
    }

    public void setDurationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
    }

    public String getHouseLandlordNum() {
        return houseLandlordNum;
    }

    public void setHouseLandlordNum(String houseLandlordNum) {
        this.houseLandlordNum = houseLandlordNum == null ? null : houseLandlordNum.trim();
    }

    public String getHouseTenantNum() {
        return houseTenantNum;
    }

    public void setHouseTenantNum(String houseTenantNum) {
        this.houseTenantNum = houseTenantNum == null ? null : houseTenantNum.trim();
    }

    public Date getContraceEffectiveDate() {
        return contraceEffectiveDate;
    }

    public void setContraceEffectiveDate(Date contraceEffectiveDate) {
        this.contraceEffectiveDate = contraceEffectiveDate;
    }
}