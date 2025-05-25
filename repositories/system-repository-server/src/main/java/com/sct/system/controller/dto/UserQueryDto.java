package com.sct.system.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.system.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryDto {

    private String username;

    private String nickname;

    private String mobile;

    public Example<User> toExample() {
        User user = new User();
        if (this.username != null) {
            user.setUsername(this.username);
        }
        if (this.nickname != null) {
            user.setNickname(this.nickname);
        }
        if (this.mobile != null) {
            user.setMobile(this.mobile);
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(user, matcher);
    }

}
