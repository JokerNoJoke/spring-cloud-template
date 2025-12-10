package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QSystemConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemConfigQueryDto {

    private String name;
    private String code;
    private Boolean builtIn;

    public Predicate toPredicate() {
        QSystemConfig qEntity = QSystemConfig.systemConfig;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }
        if (code != null && !code.isBlank()) {
            builder.and(qEntity.code.contains(code));
        }
        if (builtIn != null) {
            builder.and(qEntity.builtIn.eq(builtIn));
        }
        return builder;
    }
}