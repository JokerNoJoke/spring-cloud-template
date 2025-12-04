package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.Param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamDto {

    private Long id;
    private String label;
    private String key;
    private String value;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static ParamDto fromEntity(Param entity) {
        ParamDto dto = new ParamDto();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Param toCreatedEntity() {
        Param createdEntity = new Param();
        createdEntity.setLabel(this.label);
        createdEntity.setKey(this.key);
        createdEntity.setValue(this.value);
        return createdEntity;
    }

    public Param updateEntity(Param entity) {
        if (entity == null) {
            return null;
        }
        entity.setKey(Optional.ofNullable(this.key).orElse(entity.getKey()));
        entity.setLabel(Optional.ofNullable(this.label).orElse(entity.getLabel()));
        entity.setValue(Optional.ofNullable(this.value).orElse(entity.getValue()));
        return entity;
    }
}