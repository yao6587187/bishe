package com.house.jikezu.vo;

import lombok.Data;

@Data
public class InfoListReturnVO {

    private String infoNum;

    private String userId;

    private String infoTitle;

    @Override
    public String toString() {
        return "InfoListReturnVO{" +
                "infoNum='" + infoNum + '\'' +
                ", userId='" + userId + '\'' +
                ", infoTitle='" + infoTitle + '\'' +
                '}';
    }
}
