package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleBasicDto {

    private Long id;
    private String name;
    private String code;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static RoleBasicDto fromEntity(Role entity) {
        RoleBasicDto dto = new RoleBasicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Role toReferencedEntity() {
        Role referencedEntity = new Role();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}