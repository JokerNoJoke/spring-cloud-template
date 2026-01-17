package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.Menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {

    private Long id;
    private Long parentId;
    private MenuBasicDto parent;
    private Integer type;
    private String name;
    private String icon;
    private String path;
    private String permission;
    private Integer sortOrder;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static MenuDto fromEntity(Menu entity) {
        MenuDto dto = new MenuDto();
        dto.setId(entity.getId());
        dto.setParentId(entity.getParentId());
        dto.setParent(MenuBasicDto.fromEntity(entity.getParent()));
        dto.setType(entity.getType());
        dto.setName(entity.getName());
        dto.setIcon(entity.getIcon());
        dto.setPath(entity.getPath());
        dto.setPermission(entity.getPermission());
        dto.setSortOrder(entity.getSortOrder());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Menu toCreatedEntity() {
        Menu createdEntity = new Menu();
        createdEntity.setParentId(this.parentId);
        createdEntity.setType(this.type);
        createdEntity.setName(this.name);
        createdEntity.setIcon(this.icon);
        createdEntity.setPath(this.path);
        createdEntity.setPermission(this.permission);
        createdEntity.setSortOrder(this.sortOrder);
        createdEntity.setEnabled(this.enabled);
        return createdEntity;
    }

    public Menu updateEntity(Menu entity) {
        if (entity == null) {
            return null;
        }

        entity.setType(Optional.ofNullable(this.type).orElse(entity.getType()));
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setIcon(Optional.ofNullable(this.icon).orElse(entity.getIcon()));
        entity.setPath(Optional.ofNullable(this.path).orElse(entity.getPath()));
        entity.setPermission(Optional.ofNullable(this.permission).orElse(entity.getPermission()));
        entity.setSortOrder(Optional.ofNullable(this.sortOrder).orElse(entity.getSortOrder()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        return entity;
    }

}
