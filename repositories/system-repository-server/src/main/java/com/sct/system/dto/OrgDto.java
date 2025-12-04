package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.Org;

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

    public Org updateEntity(Org entity) {
        if (entity == null) {
            return null;
        }
        entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        entity.setParent(
                Optional.ofNullable(this.parent).map(OrgBasicDto::toReferencedEntity).orElse(entity.getParent()));
        return entity;
    }
}