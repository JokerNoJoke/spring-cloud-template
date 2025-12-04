package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryDto {

    private String username;
    private String nickname;
    private String mobile;

    public Predicate toPredicate() {
        QUser qEntity = QUser.user;
        BooleanBuilder builder = new BooleanBuilder();

        if (username != null && !username.isBlank()) {
            builder.and(qEntity.username.contains(username));
        }
        if (nickname != null && !nickname.isBlank()) {
            builder.and(qEntity.nickname.contains(nickname));
        }
        if (mobile != null && !mobile.isBlank()) {
            builder.and(qEntity.mobile.contains(mobile));
        }

        return builder;
    }
}
