package com.house.jikezu.vo;


import lombok.Data;

@Data
public class PageData<T> {

    T datas;

    Integer currentPage=1;

    Integer pageSize=10;

    Boolean finished=true;
}
