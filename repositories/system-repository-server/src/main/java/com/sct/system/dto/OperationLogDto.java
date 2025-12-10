package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.OperationLog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationLogDto {

    private Long id;
    private Long tenantId;
    private TenantBasicDto tenant;
    private String ip;
    private String location;
    private String method;
    private String uri;
    private String os;
    private String browser;
    private String request;
    private String response;
    private Long time;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;

    public static OperationLogDto fromEntity(OperationLog entity) {
        OperationLogDto dto = new OperationLogDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setTenant(TenantBasicDto.fromEntity(entity.getTenant()));
        dto.setIp(entity.getIp());
        dto.setLocation(entity.getLocation());
        dto.setMethod(entity.getMethod());
        dto.setUri(entity.getUri());
        dto.setOs(entity.getOs());
        dto.setBrowser(entity.getBrowser());
        dto.setRequest(entity.getRequest());
        dto.setResponse(entity.getResponse());
        dto.setTime(entity.getTime());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        return dto;
    }

    public OperationLog toCreatedEntity() {
        OperationLog createdEntity = new OperationLog();
        createdEntity.setTenantId(this.tenantId);
        createdEntity.setIp(this.ip);
        createdEntity.setLocation(this.location);
        createdEntity.setMethod(this.method);
        createdEntity.setUri(this.uri);
        createdEntity.setOs(this.os);
        createdEntity.setBrowser(this.browser);
        createdEntity.setRequest(this.request);
        createdEntity.setResponse(this.response);
        createdEntity.setTime(this.time);
        return createdEntity;
    }

    public OperationLog updateEntity(OperationLog entity) {
        if (entity == null) {
            return null;
        }

        entity.setIp(Optional.ofNullable(this.ip).orElse(entity.getIp()));
        entity.setLocation(Optional.ofNullable(this.location).orElse(entity.getLocation()));
        entity.setMethod(Optional.ofNullable(this.method).orElse(entity.getMethod()));
        entity.setUri(Optional.ofNullable(this.uri).orElse(entity.getUri()));
        entity.setOs(Optional.ofNullable(this.os).orElse(entity.getOs()));
        entity.setBrowser(Optional.ofNullable(this.browser).orElse(entity.getBrowser()));
        entity.setRequest(Optional.ofNullable(this.request).orElse(entity.getRequest()));
        entity.setResponse(Optional.ofNullable(this.response).orElse(entity.getResponse()));
        entity.setTime(Optional.ofNullable(this.time).orElse(entity.getTime()));
        return entity;
    }

}
