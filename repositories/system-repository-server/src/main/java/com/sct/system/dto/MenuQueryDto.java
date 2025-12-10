package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QMenu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuQueryDto {

    private Long parentId;
    private String name;
    private String permission;
    private Boolean enabled;

    public Predicate toPredicate() {
        QMenu qEntity = QMenu.menu;
        BooleanBuilder builder = new BooleanBuilder();

        if (parentId != null) {
            builder.and(qEntity.parentId.eq(parentId));
        }
        if (name != null && !name.isBlank()) {
            builder.and(qEntity.name.contains(name));
        }
        if (permission != null && !permission.isBlank()) {
            builder.and(qEntity.permission.contains(permission));
        }
        if (enabled != null) {
            builder.and(qEntity.enabled.eq(enabled));
        }

        return builder;
    }
}
