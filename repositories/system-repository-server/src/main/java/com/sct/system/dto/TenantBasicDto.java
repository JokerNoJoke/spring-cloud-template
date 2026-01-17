package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.Tenant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantBasicDto {

    private Long id;
    private String name;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static TenantBasicDto fromEntity(Tenant entity) {
        TenantBasicDto dto = new TenantBasicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Tenant toReferencedEntity() {
        Tenant referencedEntity = new Tenant();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}
