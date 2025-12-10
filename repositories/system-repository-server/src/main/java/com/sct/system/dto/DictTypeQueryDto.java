package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QDictType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictTypeQueryDto {

    private String name;
    private String code;
    private Boolean enabled;

    public Predicate toPredicate() {
        QDictType qEntity = QDictType.dictType;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }
        if (code != null && !code.isBlank()) {
            builder.and(qEntity.code.contains(code));
        }
        if (enabled != null) {
            builder.and(qEntity.enabled.eq(enabled));
        }

        return builder;
    }
}