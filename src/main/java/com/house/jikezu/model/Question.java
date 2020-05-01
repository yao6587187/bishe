package com.house.jikezu.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-05-01
 */
public class Question {
    private Integer id;

    /**
     * 问题编号
     */
    private String questionNum;

    /**
     * 问题内容
     */
    private String questionContent;

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

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum == null ? null : questionNum.trim();
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }
}