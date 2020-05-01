package com.house.jikezu.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-05-01
 */
public class Info {
    private Integer id;

    /**
     * 资讯编号
     */
    private String infoNum;

    /**
     * 资讯标题
     */
    private String infoTitle;

    /**
     * 资讯内容
     */
    private String infoContent;

    /**
     * 发表用户编号
     */
    private String userNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfoNum() {
        return infoNum;
    }

    public void setInfoNum(String infoNum) {
        this.infoNum = infoNum == null ? null : infoNum.trim();
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }
}