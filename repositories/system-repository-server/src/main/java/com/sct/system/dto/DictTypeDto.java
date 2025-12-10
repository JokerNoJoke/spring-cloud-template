package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.DictType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictTypeDto {

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

    public static DictTypeDto fromEntity(DictType entity) {
        if (entity == null) {
            return null;
        }
        DictTypeDto dto = new DictTypeDto();
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

    public DictType toCreatedEntity() {
        DictType createdEntity = new DictType();
        createdEntity.setName(this.name);
        createdEntity.setCode(this.code);
        createdEntity.setEnabled(this.enabled);
        return createdEntity;
    }

    public DictType updateEntity(DictType entity) {
        if (entity == null) {
            return null;
        }
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setCode(Optional.ofNullable(this.code).orElse(entity.getCode()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        return entity;
    }
}