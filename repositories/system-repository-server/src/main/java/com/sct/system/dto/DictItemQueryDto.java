package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QDictItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictItemQueryDto {

    private Long dictTypeId;
    private String label;
    private String value;
    private Boolean enabled;

    public Predicate toPredicate() {
        QDictItem qEntity = QDictItem.dictItem;
        BooleanBuilder builder = new BooleanBuilder();

        if (dictTypeId != null) {
            builder.and(qEntity.dictTypeId.eq(dictTypeId));
        }
        if (label != null && !label.isBlank()) {
            builder.and(qEntity.label.contains(label));
        }
        if (value != null && !value.isBlank()) {
            builder.and(qEntity.value.contains(value));
        }
        if (enabled != null) {
            builder.and(qEntity.enabled.eq(enabled));
        }

        return builder;
    }
}
