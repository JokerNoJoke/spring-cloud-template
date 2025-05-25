package com.sct.system.controller.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.system.entities.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    @Schema(format = "instant")
    private Instant createdTime;

    @Schema(format = "instant")
    private Instant updatedTime;

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
        dto.setRoles(Optional.ofNullable(entity.getRoles()).orElse(List.of()).stream().map(RoleBasicDto::fromEntity).toList());
        return dto;
    }

    public User toCreatedEntity() {
        User createdEntity = new User();
        createdEntity.setUsername(this.username);
        createdEntity.setPassword(this.password);
        createdEntity.setNickname(this.nickname);
        createdEntity.setMobile(this.mobile);
        createdEntity.setRoles(Optional.ofNullable(roles).orElse(List.of()).stream().map(RoleBasicDto::toReferencedEntity).toList());
        return createdEntity;
    }

    public User toUpdatedEntity(User sourceEntity) {
        User updatedEntity = new User();
        updatedEntity.setId(sourceEntity.getId());
        updatedEntity.setUsername(Optional.ofNullable(this.username).orElse(sourceEntity.getUsername()));
        updatedEntity.setPassword(Optional.ofNullable(this.password).orElse(sourceEntity.getPassword()));
        updatedEntity.setNickname(Optional.ofNullable(this.nickname).orElse(sourceEntity.getNickname()));
        updatedEntity.setMobile(Optional.ofNullable(this.mobile).orElse(sourceEntity.getMobile()));
        updatedEntity.setRoles(Optional.ofNullable(this.roles).orElse(List.of()).stream().map(RoleBasicDto::toReferencedEntity).toList());
        return updatedEntity;
    }

}
