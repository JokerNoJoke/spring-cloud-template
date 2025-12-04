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
    private String code;
    private String name;
    private String description;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static RoleBasicDto fromEntity(Role entity) {
        RoleBasicDto dto = new RoleBasicDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Role toReferencedEntity() {
        Role referencedEntity = new Role();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}