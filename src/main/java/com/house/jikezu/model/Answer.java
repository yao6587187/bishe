package com.house.jikezu.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-05-01
 */
public class Answer {
    private Integer id;

    /**
     * 回答编号
     */
    private String answerNum;

    /**
     * 回答内容
     */
    private String answerContent;

    /**
     * 问题编号
     */
    private String questionNum;

    /**
     * 回答用户编号
     */
    private String userNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum == null ? null : answerNum.trim();
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum == null ? null : questionNum.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }
}