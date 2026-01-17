package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.SystemConfig;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemConfigBasicDto {

    private Long id;
    private Long tenantId;
    private String name;
    private String code;
    private String value;
    private Boolean builtIn;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static SystemConfigBasicDto fromEntity(SystemConfig entity) {
        SystemConfigBasicDto dto = new SystemConfigBasicDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setValue(entity.getValue());
        dto.setBuiltIn(entity.getBuiltIn());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public SystemConfig toReferencedEntity() {
        SystemConfig referencedEntity = new SystemConfig();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}