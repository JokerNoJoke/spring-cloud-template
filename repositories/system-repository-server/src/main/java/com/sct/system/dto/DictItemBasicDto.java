package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.DictItem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictItemBasicDto {

    private Long id;
    private Long dictTypeId;
    private String label;
    private String value;
    private Integer sortOrder;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static DictItemBasicDto fromEntity(DictItem entity) {
        DictItemBasicDto dto = new DictItemBasicDto();
        dto.setId(entity.getId());
        dto.setDictTypeId(entity.getDictTypeId());
        dto.setLabel(entity.getLabel());
        dto.setValue(entity.getValue());
        dto.setSortOrder(entity.getSortOrder());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public DictItem toReferencedEntity() {
        DictItem referencedEntity = new DictItem();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}
