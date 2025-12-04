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

    private String username;

    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    private String password;

    private String nickname;

    private String mobile;

    @Schema(format = "instant")
    private Instant createdTime;

    @Schema(format = "instant")
    private Instant updatedTime;

    private OrgBasicDto org;

    private List<RoleBasicDto> roles;

    public static UserDto fromEntity(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setNickname(entity.getNickname());
        dto.setMobile(entity.getMobile());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.setOrg(OrgBasicDto.fromEntity(entity.getOrg()));
        dto.setRoles(Optional.ofNullable(entity.getRoles()).orElse(List.of()).stream().map(RoleBasicDto::fromEntity)
                .toList());
        return dto;
    }

    public User toCreatedEntity() {
        User createdEntity = new User();
        createdEntity.setUsername(this.username);
        createdEntity.setPassword(this.password);
        createdEntity.setNickname(this.nickname);
        createdEntity.setMobile(this.mobile);
        createdEntity.setOrg(Optional.ofNullable(this.org).map(OrgBasicDto::toReferencedEntity).orElse(null));
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
        entity.setOrg(Optional.ofNullable(this.org).map(OrgBasicDto::toReferencedEntity).orElse(entity.getOrg()));
        entity.setRoles(Optional.ofNullable(this.roles).orElse(List.of()).stream().map(RoleBasicDto::toReferencedEntity)
                .toList());
        return entity;
    }

}
