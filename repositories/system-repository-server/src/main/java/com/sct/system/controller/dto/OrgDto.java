package com.sct.system.controller.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entities.Org;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgDto {

    private Long id;
    private String name;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;
    private OrgBasicDto parent;

    public static OrgDto fromEntity(Org entity) {
        OrgDto dto = new OrgDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setParent(Optional.ofNullable(entity.getParent()).map(OrgBasicDto::fromEntity).orElse(null));
        return dto;
    }

    public Org toCreatedEntity() {
        Org createdEntity = new Org();
        createdEntity.setName(this.name);
        createdEntity.setParent(Optional.ofNullable(this.parent).map(OrgBasicDto::toReferencedEntity).orElse(null));
        return createdEntity;
    }

    public Org toUpdatedEntity(Org sourceEntity) {
        Org updatedEntity = new Org();
        updatedEntity.setId(sourceEntity.getId());
        updatedEntity.setName(Optional.ofNullable(this.name).orElse(sourceEntity.getName()));
        updatedEntity.setParent(Optional.ofNullable(this.parent).map(OrgBasicDto::toReferencedEntity).orElse(sourceEntity.getParent()));
        return updatedEntity;
    }
}