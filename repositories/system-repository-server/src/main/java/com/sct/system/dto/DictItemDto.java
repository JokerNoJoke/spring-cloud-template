package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.DictItem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictItemDto {

    private Long id;
    private Long dictTypeId;
    private DictTypeBasicDto dictType;
    private String label;
    private String value;
    private Integer sortOrder;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static DictItemDto fromEntity(DictItem entity) {
        if (entity == null) {
            return null;
        }
        DictItemDto dto = new DictItemDto();
        dto.setId(entity.getId());
        dto.setDictTypeId(entity.getDictTypeId());
        dto.setDictType(DictTypeBasicDto.fromEntity(entity.getDictType()));
        dto.setLabel(entity.getLabel());
        dto.setValue(entity.getValue());
        dto.setSortOrder(entity.getSortOrder());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public DictItem toCreatedEntity() {
        DictItem createdEntity = new DictItem();
        createdEntity.setDictTypeId(this.dictTypeId);
        createdEntity.setLabel(this.label);
        createdEntity.setValue(this.value);
        createdEntity.setSortOrder(this.sortOrder);
        createdEntity.setEnabled(this.enabled);
        return createdEntity;
    }

    public DictItem updateEntity(DictItem entity) {
        if (entity == null) {
            return null;
        }

        entity.setLabel(Optional.ofNullable(this.label).orElse(entity.getLabel()));
        entity.setValue(Optional.ofNullable(this.value).orElse(entity.getValue()));
        entity.setSortOrder(Optional.ofNullable(this.sortOrder).orElse(entity.getSortOrder()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        return entity;
    }
}
