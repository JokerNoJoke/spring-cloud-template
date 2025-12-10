package com.sct.system.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sct.system.entity.QOperationLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationLogQueryDto {

    private Long tenantId;
    private String ip;
    private String method;
    private String uri;

    public Predicate toPredicate() {
        QOperationLog qEntity = QOperationLog.operationLog;
        BooleanBuilder builder = new BooleanBuilder();

        if (tenantId != null) {
            builder.and(qEntity.tenantId.eq(tenantId));
        }
        if (ip != null && !ip.isBlank()) {
            builder.and(qEntity.ip.contains(ip));
        }
        if (method != null && !method.isBlank()) {
            builder.and(qEntity.method.eq(method));
        }
        if (uri != null && !uri.isBlank()) {
            builder.and(qEntity.uri.contains(uri));
        }

        return builder;
    }
}
