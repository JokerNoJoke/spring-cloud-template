package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.Dict;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictBasicDto {

    private Long id;
    private String label;
    private String key;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static DictBasicDto fromEntity(Dict entity) {
        DictBasicDto dto = new DictBasicDto();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        dto.setKey(entity.getKey());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Dict toReferencedEntity() {
        Dict referencedEntity = new Dict();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}