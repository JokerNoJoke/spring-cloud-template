package com.sct.system.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.system.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;
    private String name;
    private String code;
    private Boolean enabled;
    private List<MenuBasicDto> menus;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static RoleDto fromEntity(Role entity) {

        if (entity == null) {
            return null;
        }
        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setEnabled(entity.getEnabled());
        dto.setMenus(Optional.ofNullable(entity.getMenus()).orElse(List.of()).stream().map(MenuBasicDto::fromEntity)
                .toList());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Role toCreatedEntity() {
        Role createdEntity = new Role();
        createdEntity.setName(this.name);
        createdEntity.setCode(this.code);
        createdEntity.setEnabled(this.enabled);
        createdEntity.setMenus(Optional.ofNullable(this.menus).orElse(List.of()).stream()
                .map(MenuBasicDto::toReferencedEntity).toList());
        return createdEntity;
    }

    public Role updateEntity(Role entity) {
        if (entity == null) {
            return null;
        }
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setCode(Optional.ofNullable(this.code).orElse(entity.getCode()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        entity.setMenus(Optional.ofNullable(this.menus).orElse(List.of()).stream()
                .map(MenuBasicDto::toReferencedEntity).toList());
        return entity;
    }
}