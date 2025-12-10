package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.LoginLog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLogBasicDto {

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
    private Instant createdTime;

    public static LoginLogBasicDto fromEntity(LoginLog entity) {
        LoginLogBasicDto dto = new LoginLogBasicDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setUsername(entity.getUsername());
        dto.setIp(entity.getIp());
        dto.setLocation(entity.getLocation());
        dto.setOs(entity.getOs());
        dto.setBrowser(entity.getBrowser());
        dto.setStatus(entity.getStatus());
        dto.setMessage(entity.getMessage());
        dto.setCreatedTime(entity.getCreatedTime());
        return dto;
    }

    public LoginLog toReferencedEntity() {
        LoginLog referencedEntity = new LoginLog();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }

}
