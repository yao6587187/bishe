package com.house.jikezu.vo;

import lombok.Data;

@Data
public class QuestionListReturnVO {

    private String questionNum;
    private String questionContent;
    private String userId;

    @Override
    public String toString() {
        return "QuestionListReturnVO{" +
                "questionNum='" + questionNum + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
