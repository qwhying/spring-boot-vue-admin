package com.zoctan.api.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
    * Created by Qwhying on 2019/11/25
*/
@Data
public class PersonDto {
    @NotEmpty(message = "电话号码不能为空")
    private String phoneNo;

    /**
    * 身份证号
    */
    private Integer id;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
    * 学号
    */
    @NotEmpty(message = "学号不能为空")
    private String stuId;

    /**
    * 身份
    */
    private String identity;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String organization;

    private String college;
}