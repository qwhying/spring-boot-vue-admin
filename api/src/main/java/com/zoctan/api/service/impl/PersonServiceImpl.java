package com.zoctan.api.service.impl;

import com.zoctan.api.core.exception.ServiceException;
import com.zoctan.api.core.service.AbstractService;
import com.zoctan.api.dto.PersonDto;
import com.zoctan.api.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zoctan.api.entity.Person;
import com.zoctan.api.mapper.PersonMapper;
/**
    * Created by Qwhying on 2019/11/25
*/
@Service
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public int deleteByPrimaryKey(String phoneNo) {
        return personMapper.deleteByPrimaryKey(phoneNo);
    }

    @Override
    public int insert(PersonDto record) {
        Person p=this.getBy("phoneNo", record.getPhoneNo());
        if (p != null) {
            throw new ServiceException("电话号码已注册");
        } else {
            p= this.getBy("stuId", record.getStuId());
            if (p != null) {
                throw new ServiceException("学号已注册");
            } else {
                // log.info("before password : {}", account.getPassword().trim());
               // accountDto.setPassword(this.passwordEncoder.encode(accountDto.getPassword().trim()));
                // log.info("after password : {}", account.getPassword());
                final Person person = new Person();
                BeanUtils.copyProperties(record, person);
                return this.personMapper.insert(person);
                //this.saveRole(account.getId(), accountDto.getRoleId());
            }
        }
    }

    @Override
    public int insertSelective(Person record) {
        return personMapper.insertSelective(record);
    }

    @Override
    public Person selectByPrimaryKey(String phoneNo) {
        return personMapper.selectByPrimaryKey(phoneNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

}
