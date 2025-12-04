package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QOrg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgQueryDto {

    private String name;

    public Predicate toPredicate() {
        QOrg qEntity = QOrg.org;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }

        return builder;
    }
}