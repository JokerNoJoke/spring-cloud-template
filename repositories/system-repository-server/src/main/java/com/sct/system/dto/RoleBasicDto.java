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
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static RoleBasicDto fromEntity(Role entity) {
        RoleBasicDto dto = new RoleBasicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Role toReferencedEntity() {
        Role referencedEntity = new Role();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}