package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QParam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamQueryDto {

    private String label;
    private String key;

    public Predicate toPredicate() {
        QParam qEntity = QParam.param;
        BooleanBuilder builder = new BooleanBuilder();

        if (label != null && !label.isBlank()) {
            builder.and(qEntity.label.contains(label));
        }
        if (key != null && !key.isBlank()) {
            builder.and(qEntity.key.contains(key));
        }

        return builder;
    }
}