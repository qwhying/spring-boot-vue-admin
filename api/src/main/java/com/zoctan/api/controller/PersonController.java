package com.zoctan.api.controller;

import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.dto.PersonDto;
import com.zoctan.api.service.PersonService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Qwhying on 2019/11/25
 */
@RestController
@RequestMapping("/person")
@Validated
public class PersonController {
    @Resource
    private PersonService personService;

    @PostMapping
    public Result register(
            @RequestBody @Valid final PersonDto person, final BindingResult bindingResult) {
        // {"name":"123456", "password":"123456", "email": "123456@qq.com"}
        if (bindingResult.hasErrors()) {
            //noinspection ConstantConditions
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            this.personService.insert(person);
            return this.getToken(account.getName());
        }
    }

}
