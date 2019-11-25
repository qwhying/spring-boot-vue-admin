package com.zoctan.api.mapper;

import com.zoctan.api.entity.Person;

/**
    * Created by Qwhying on 2019/11/25
*/
public interface PersonMapper {
    int deleteByPrimaryKey(String phoneNo);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String phoneNo);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}