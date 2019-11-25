package com.zoctan.api.entity;

import lombok.Data;

/**
    * Created by Qwhying on 2019/11/25
*/
@Data
public class Person {
    private String phoneNo;

    /**
    * 身份证号
    */
    private Integer id;

    private String name;

    /**
    * 学号
    */
    private String stuId;

    /**
    * 身份
    */
    private String identity;

    private String password;

    private String organization;

    private String college;
}