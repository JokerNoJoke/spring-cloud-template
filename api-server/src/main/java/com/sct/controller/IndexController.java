package com.sct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.demo.client.api.DemoControllerApi;
import com.sct.demo.client.model.DemoDto;
import com.sct.demo.client.model.DemoQueryDto;
import com.sct.system.client.api.UserControllerApi;
import com.sct.system.client.model.UserDto;
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
    public ResponseEntity<List<DemoDto>> demo() {
        return demoControllerApiClient.findAllDemoBy(new DemoQueryDto());
    }

    @GetMapping("user")
    public ResponseEntity<List<UserDto>> findAllUser() {
        return userControllerApiClient.findAllUserBy(new UserQueryDto());
    }

}
