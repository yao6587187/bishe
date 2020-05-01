package com.house.jikezu.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-05-02
 */
public class HouseContractRequest {
    private Integer id;

    private String contractRequestNum;

    /**
     * 合同编号
     */
    private String houseContractNum;

    /**
     * 请求类型
     */
    private String requestType;

    private String tenantNum;

    private String landlordNum;

    private Integer xuyuetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractRequestNum() {
        return contractRequestNum;
    }

    public void setContractRequestNum(String contractRequestNum) {
        this.contractRequestNum = contractRequestNum == null ? null : contractRequestNum.trim();
    }

    public String getHouseContractNum() {
        return houseContractNum;
    }

    public void setHouseContractNum(String houseContractNum) {
        this.houseContractNum = houseContractNum == null ? null : houseContractNum.trim();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    public String getTenantNum() {
        return tenantNum;
    }

    public void setTenantNum(String tenantNum) {
        this.tenantNum = tenantNum == null ? null : tenantNum.trim();
    }

    public String getLandlordNum() {
        return landlordNum;
    }

    public void setLandlordNum(String landlordNum) {
        this.landlordNum = landlordNum == null ? null : landlordNum.trim();
    }

    public Integer getXuyuetime() {
        return xuyuetime;
    }

    public void setXuyuetime(Integer xuyuetime) {
        this.xuyuetime = xuyuetime;
    }
}