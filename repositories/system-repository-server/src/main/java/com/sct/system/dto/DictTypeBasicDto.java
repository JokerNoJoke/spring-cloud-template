package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.DictType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictTypeBasicDto {

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

    public static DictTypeBasicDto fromEntity(DictType entity) {
        DictTypeBasicDto dto = new DictTypeBasicDto();
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

    public DictType toReferencedEntity() {
        DictType referencedEntity = new DictType();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}