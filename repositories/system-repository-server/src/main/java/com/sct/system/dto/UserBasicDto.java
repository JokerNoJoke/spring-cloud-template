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

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    @Schema(format = "instant")
    private Instant createdTime;

    @Schema(format = "instant")
    private Instant updatedTime;

    public static UserBasicDto fromEntity(User entity) {
        UserBasicDto dto = new UserBasicDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setNickname(entity.getNickname());
        dto.setMobile(entity.getMobile());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public User toReferencedEntity() {
        User referencedEntity = new User();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }

}
