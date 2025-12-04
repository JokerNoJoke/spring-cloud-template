package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleQueryDto {

    private String code;
    private String name;

    public Predicate toPredicate() {
        QRole qEntity = QRole.role;
        BooleanBuilder builder = new BooleanBuilder();

        if (code != null && !code.isBlank()) {
            builder.and(qEntity.code.contains(code));
        }
        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }

        return builder;
    }
}