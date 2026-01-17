package com.sct.system.dto;

import java.time.Instant;
import java.util.Optional;

import com.sct.system.entity.LoginLog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLogDto {

    private Long id;
    private Long tenantId;
    private String username;
    private String ip;
    private String location;
    private String os;
    private String browser;
    private Integer status;
    private String message;

    @Schema(format = "instant")
    private Instant createdAt;

    public static LoginLogDto fromEntity(LoginLog entity) {
        LoginLogDto dto = new LoginLogDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setUsername(entity.getUsername());
        dto.setIp(entity.getIp());
        dto.setLocation(entity.getLocation());
        dto.setOs(entity.getOs());
        dto.setBrowser(entity.getBrowser());
        dto.setStatus(entity.getStatus());
        dto.setMessage(entity.getMessage());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public LoginLog toCreatedEntity() {
        LoginLog createdEntity = new LoginLog();
        createdEntity.setTenantId(this.tenantId);
        createdEntity.setUsername(this.username);
        createdEntity.setIp(this.ip);
        createdEntity.setLocation(this.location);
        createdEntity.setOs(this.os);
        createdEntity.setBrowser(this.browser);
        createdEntity.setStatus(this.status);
        createdEntity.setMessage(this.message);
        return createdEntity;
    }

    public LoginLog updateEntity(LoginLog entity) {
        if (entity == null) {
            return null;
        }
        entity.setUsername(Optional.ofNullable(this.username).orElse(entity.getUsername()));
        entity.setIp(Optional.ofNullable(this.ip).orElse(entity.getIp()));
        entity.setLocation(Optional.ofNullable(this.location).orElse(entity.getLocation()));
        entity.setOs(Optional.ofNullable(this.os).orElse(entity.getOs()));
        entity.setBrowser(Optional.ofNullable(this.browser).orElse(entity.getBrowser()));
        entity.setStatus(Optional.ofNullable(this.status).orElse(entity.getStatus()));
        entity.setMessage(Optional.ofNullable(this.message).orElse(entity.getMessage()));
        return entity;
    }

}
