package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OperationLogQueryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class OperationLogQueryDto {

  private @Nullable Long tenantId;

  private @Nullable String ip;

  private @Nullable String method;

  private @Nullable String uri;

  public OperationLogQueryDto tenantId(@Nullable Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
   */
  
  @Schema(name = "tenantId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tenantId")
  public @Nullable Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(@Nullable Long tenantId) {
    this.tenantId = tenantId;
  }

  public OperationLogQueryDto ip(@Nullable String ip) {
    this.ip = ip;
    return this;
  }

  /**
   * Get ip
   * @return ip
   */
  
  @Schema(name = "ip", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ip")
  public @Nullable String getIp() {
    return ip;
  }

  public void setIp(@Nullable String ip) {
    this.ip = ip;
  }

  public OperationLogQueryDto method(@Nullable String method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   * @return method
   */
  
  @Schema(name = "method", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("method")
  public @Nullable String getMethod() {
    return method;
  }

  public void setMethod(@Nullable String method) {
    this.method = method;
  }

  public OperationLogQueryDto uri(@Nullable String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Get uri
   * @return uri
   */
  
  @Schema(name = "uri", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uri")
  public @Nullable String getUri() {
    return uri;
  }

  public void setUri(@Nullable String uri) {
    this.uri = uri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationLogQueryDto operationLogQueryDto = (OperationLogQueryDto) o;
    return Objects.equals(this.tenantId, operationLogQueryDto.tenantId) &&
        Objects.equals(this.ip, operationLogQueryDto.ip) &&
        Objects.equals(this.method, operationLogQueryDto.method) &&
        Objects.equals(this.uri, operationLogQueryDto.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, ip, method, uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationLogQueryDto {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

