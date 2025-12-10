package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.Dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDto {

    private Long id;
    private Long tenantId;
    private Long parentId;
    private DeptBasicDto parent;
    private String name;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static DeptDto fromEntity(Dept entity) {
        if (entity == null) {
            return null;
        }
        DeptDto dto = new DeptDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setParentId(entity.getParentId());
        dto.setParent(Optional.ofNullable(entity.getParent()).map(DeptBasicDto::fromEntity).orElse(null));
        dto.setName(entity.getName());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Dept toCreatedEntity() {
        Dept createdEntity = new Dept();
        createdEntity.setTenantId(this.tenantId);
        createdEntity.setParentId(this.parentId);
        createdEntity.setName(this.name);
        createdEntity.setEnabled(this.enabled);
        return createdEntity;
    }

    public Dept updateEntity(Dept entity) {
        if (entity == null) {
            return null;
        }

        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        return entity;
    }
}