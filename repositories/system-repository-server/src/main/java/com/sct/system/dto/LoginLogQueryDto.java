package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QLoginLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLogQueryDto {

    private String username;
    private String ip;
    private Integer status;

    public Predicate toPredicate() {
        QLoginLog qEntity = QLoginLog.loginLog;
        BooleanBuilder builder = new BooleanBuilder();

        if (username != null && !username.isBlank()) {
            builder.and(qEntity.username.contains(username));
        }
        if (ip != null && !ip.isBlank()) {
            builder.and(qEntity.ip.contains(ip));
        }
        if (status != null) {
            builder.and(qEntity.status.eq(status));
        }

        return builder;
    }
}
