package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.SystemConfig;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemConfigDto {

    private Long id;
    private Long tenantId;
    private TenantBasicDto tenant;
    private String name;
    private String code;
    private String value;
    private Boolean builtIn;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static SystemConfigDto fromEntity(SystemConfig entity) {
        if (entity == null) {
            return null;
        }
        SystemConfigDto dto = new SystemConfigDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setTenant(TenantBasicDto.fromEntity(entity.getTenant()));
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setValue(entity.getValue());
        dto.setBuiltIn(entity.getBuiltIn());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public SystemConfig toCreatedEntity() {
        SystemConfig createdEntity = new SystemConfig();
        createdEntity.setTenantId(this.tenantId);
        createdEntity.setName(this.name);
        createdEntity.setCode(this.code);
        createdEntity.setValue(this.value);
        createdEntity.setBuiltIn(this.builtIn);
        return createdEntity;
    }

    public SystemConfig updateEntity(SystemConfig entity) {
        if (entity == null) {
            return null;
        }
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setCode(Optional.ofNullable(this.code).orElse(entity.getCode()));
        entity.setValue(Optional.ofNullable(this.value).orElse(entity.getValue()));
        entity.setBuiltIn(Optional.ofNullable(this.builtIn).orElse(entity.getBuiltIn()));
        return entity;
    }
}