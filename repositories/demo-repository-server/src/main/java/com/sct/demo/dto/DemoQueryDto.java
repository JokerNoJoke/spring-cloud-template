package com.sct.demo.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.demo.entity.QDemo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoQueryDto {

    private Integer column1;
    private String column2;
    private Boolean column3;

    public Predicate toPredicate() {
        QDemo qEntity = QDemo.demo;
        BooleanBuilder builder = new BooleanBuilder();

        if (column1 != null) {
            builder.and(qEntity.column1.eq(column1));
        }
        if (column2 != null && !column2.isBlank()) {
            builder.and(qEntity.column2.contains(column2));
        }
        if (column3 != null) {
            builder.and(qEntity.column3.eq(column3));
        }

        return builder;
    }
}