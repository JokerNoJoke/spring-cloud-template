package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;
    private String code;
    private String name;
    private String description;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static RoleDto fromEntity(Role entity) {
        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Role toCreatedEntity() {
        Role createdEntity = new Role();
        createdEntity.setCode(this.code);
        createdEntity.setName(this.name);
        createdEntity.setDescription(this.description);
        return createdEntity;
    }

    public Role updateEntity(Role entity) {
        if (entity == null) {
            return null;
        }
        entity.setCode(Optional.ofNullable(this.code).orElse(entity.getCode()));
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setDescription(Optional.ofNullable(this.description).orElse(entity.getDescription()));
        return entity;
    }
}