package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.Menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuBasicDto {

    private Long id;
    private Long parentId;
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

    public static MenuBasicDto fromEntity(Menu entity) {
        MenuBasicDto dto = new MenuBasicDto();
        dto.setId(entity.getId());
        dto.setParentId(entity.getParentId());
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

    public Menu toReferencedEntity() {
        Menu referencedEntity = new Menu();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }

}
