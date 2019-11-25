package com.zoctan.api.service;

import com.zoctan.api.core.service.Service;
import com.zoctan.api.dto.PersonDto;
import com.zoctan.api.entity.Person;

/**
 * Created by Qwhying on 2019/11/25
 */
public interface PersonService extends Service<Person> {
    public int deleteByPrimaryKey(String phoneNo);

    public int insert(PersonDto record);

    public int insertSelective(Person record);

    public Person selectByPrimaryKey(String phoneNo);

    public int updateByPrimaryKeySelective(Person record);

    public int updateByPrimaryKey(Person record);


}
