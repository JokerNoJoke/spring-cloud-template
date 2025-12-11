package com.sct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.demo.client.api.DemoControllerApi;
import com.sct.demo.client.model.DemoQueryDto;
import com.sct.demo.client.model.PageResponseDtoDemoDto;
import com.sct.system.client.api.UserControllerApi;
import com.sct.system.client.model.PageResponseDtoUserDto;
import com.sct.system.client.model.UserQueryDto;

@RestController
public class IndexController {

    @Autowired
    private DemoControllerApi demoControllerApiClient;

    @Autowired
    private UserControllerApi userControllerApiClient;

    @GetMapping
    public String index() {
        return "Hello World!";
    }

    @GetMapping("demo")
    public ResponseEntity<PageResponseDtoDemoDto> demo() {
        return demoControllerApiClient.findAllDemoBy(new DemoQueryDto(),
                new com.sct.demo.client.model.PageRequestDto());
    }

    @GetMapping("user")
    public ResponseEntity<PageResponseDtoUserDto> findAllUser() {
        return userControllerApiClient.findAllUserBy(new UserQueryDto(),
                new com.sct.system.client.model.PageRequestDto());
    }

}
