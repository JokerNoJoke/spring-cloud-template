package com.sct.system.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.system.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private Long tenantId;
    private TenantBasicDto tenant;
    private Long deptId;
    private DeptBasicDto dept;
    private String username;
    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    private String password;
    private String nickname;
    private String mobile;
    private String avatar;
    private Boolean enabled;
    private List<RoleBasicDto> roles;

    @Schema(format = "instant")
    private Instant createdTime;
    private Long createdBy;
    @Schema(format = "instant")
    private Instant updatedTime;
    private Long updatedBy;

    public static UserDto fromEntity(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setTenant(TenantBasicDto.fromEntity(entity.getTenant()));
        dto.setDeptId(entity.getDeptId());
        dto.setDept(DeptBasicDto.fromEntity(entity.getDept()));
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setNickname(entity.getNickname());
        dto.setMobile(entity.getMobile());
        dto.setAvatar(entity.getAvatar());
        dto.setEnabled(entity.getEnabled());
        dto.setRoles(Optional.ofNullable(entity.getRoles()).orElse(List.of()).stream().map(RoleBasicDto::fromEntity)
                .toList());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public User toCreatedEntity() {
        User createdEntity = new User();
        createdEntity.setTenantId(this.tenantId);
        createdEntity.setDeptId(this.deptId);
        createdEntity.setUsername(this.username);
        createdEntity.setPassword(this.password);
        createdEntity.setNickname(this.nickname);
        createdEntity.setMobile(this.mobile);
        createdEntity.setAvatar(this.avatar);
        createdEntity.setEnabled(this.enabled);
        createdEntity.setRoles(Optional.ofNullable(this.roles).orElse(List.of()).stream()
                .map(RoleBasicDto::toReferencedEntity).toList());
        return createdEntity;
    }

    public User updateEntity(User entity) {
        if (entity == null) {
            return null;
        }

        entity.setUsername(Optional.ofNullable(this.username).orElse(entity.getUsername()));
        entity.setPassword(Optional.ofNullable(this.password).orElse(entity.getPassword()));
        entity.setNickname(Optional.ofNullable(this.nickname).orElse(entity.getNickname()));
        entity.setMobile(Optional.ofNullable(this.mobile).orElse(entity.getMobile()));
        entity.setAvatar(Optional.ofNullable(this.avatar).orElse(entity.getAvatar()));
        entity.setEnabled(Optional.ofNullable(this.enabled).orElse(entity.getEnabled()));
        entity.setRoles(Optional.ofNullable(this.roles).orElse(List.of()).stream().map(RoleBasicDto::toReferencedEntity)
                .toList());
        return entity;
    }

}
