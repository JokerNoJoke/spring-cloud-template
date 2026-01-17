package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicDto {

    private Long id;
    private Long tenantId;
    private Long deptId;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String avatar;
    private Boolean enabled;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedAt;
    private Long updatedBy;

    public static UserBasicDto fromEntity(User entity) {
        UserBasicDto dto = new UserBasicDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setDeptId(entity.getDeptId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setNickname(entity.getNickname());
        dto.setMobile(entity.getMobile());
        dto.setAvatar(entity.getAvatar());
        dto.setEnabled(entity.getEnabled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public User toReferencedEntity() {
        User referencedEntity = new User();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }

}
