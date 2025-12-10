package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.Dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptBasicDto {

    private Long id;
    private Long tenantId;
    private Long parentId;
    private String name;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static DeptBasicDto fromEntity(Dept entity) {
        DeptBasicDto dto = new DeptBasicDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setParentId(entity.getParentId());
        dto.setName(entity.getName());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public Dept toReferencedEntity() {
        Dept referencedEntity = new Dept();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}