package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QTenant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantQueryDto {

    private String name;
    private Boolean enabled;

    public Predicate toPredicate() {
        QTenant qEntity = QTenant.tenant;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }
        if (enabled != null) {
            builder.and(qEntity.enabled.eq(enabled));
        }

        return builder;
    }
}
