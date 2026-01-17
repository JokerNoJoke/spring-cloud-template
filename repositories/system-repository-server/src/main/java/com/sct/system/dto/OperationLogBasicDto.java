package com.sct.system.dto;

import java.time.Instant;

import com.sct.system.entity.OperationLog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationLogBasicDto {

    private Long id;
    private Long tenantId;
    private String ip;
    private String location;
    private String method;
    private String uri;
    private String os;
    private String browser;
    private String request;
    private String response;
    private Long time;

    @Schema(format = "instant")
    private Instant createdAt;
    private Long createdBy;

    public static OperationLogBasicDto fromEntity(OperationLog entity) {
        OperationLogBasicDto dto = new OperationLogBasicDto();
        dto.setId(entity.getId());
        dto.setTenantId(entity.getTenantId());
        dto.setIp(entity.getIp());
        dto.setLocation(entity.getLocation());
        dto.setMethod(entity.getMethod());
        dto.setUri(entity.getUri());
        dto.setOs(entity.getOs());
        dto.setBrowser(entity.getBrowser());
        dto.setRequest(entity.getRequest());
        dto.setResponse(entity.getResponse());
        dto.setTime(entity.getTime());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        return dto;
    }

    public OperationLog toReferencedEntity() {
        OperationLog referencedEntity = new OperationLog();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }

}
