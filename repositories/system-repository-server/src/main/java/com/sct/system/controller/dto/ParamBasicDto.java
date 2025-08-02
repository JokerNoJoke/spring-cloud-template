package com.sct.system.controller.dto;

import java.time.Instant;

import com.sct.system.entities.Param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamBasicDto {

    private Long id;
    private String label;
    private String key;
    private String value;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static ParamBasicDto fromEntity(Param entity) {
        ParamBasicDto dto = new ParamBasicDto();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Param toReferencedEntity() {
        Param referencedEntity = new Param();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}