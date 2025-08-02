package com.sct.system.controller.dto;

import java.time.Instant;

import com.sct.system.entities.Org;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgBasicDto {

    private Long id;
    private String name;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static OrgBasicDto fromEntity(Org entity) {
        OrgBasicDto dto = new OrgBasicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Org toReferencedEntity() {
        Org referencedEntity = new Org();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}