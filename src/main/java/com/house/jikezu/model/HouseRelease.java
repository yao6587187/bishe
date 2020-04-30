package com.house.jikezu.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-04-29
 */
public class HouseRelease {
    private Integer id;

    private String houseReleaseNum;

    private String releaseUserNum;

    private String releaseHouseNum;

    private String houseReleasecol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseReleaseNum() {
        return houseReleaseNum;
    }

    public void setHouseReleaseNum(String houseReleaseNum) {
        this.houseReleaseNum = houseReleaseNum == null ? null : houseReleaseNum.trim();
    }

    public String getReleaseUserNum() {
        return releaseUserNum;
    }

    public void setReleaseUserNum(String releaseUserNum) {
        this.releaseUserNum = releaseUserNum == null ? null : releaseUserNum.trim();
    }

    public String getReleaseHouseNum() {
        return releaseHouseNum;
    }

    public void setReleaseHouseNum(String releaseHouseNum) {
        this.releaseHouseNum = releaseHouseNum == null ? null : releaseHouseNum.trim();
    }

    public String getHouseReleasecol() {
        return houseReleasecol;
    }

    public void setHouseReleasecol(String houseReleasecol) {
        this.houseReleasecol = houseReleasecol == null ? null : houseReleasecol.trim();
    }
}