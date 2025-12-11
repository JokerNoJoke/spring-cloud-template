package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sct.system.client.model.TenantBasicDto;
import java.time.Instant;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OperationLogDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class OperationLogDto {

  private @Nullable Long id;

  private @Nullable Long tenantId;

  private @Nullable TenantBasicDto tenant;

  private @Nullable String ip;

  private @Nullable String location;

  private @Nullable String method;

  private @Nullable String uri;

  private @Nullable String os;

  private @Nullable String browser;

  private @Nullable String request;

  private @Nullable String response;

  private @Nullable Long time;

  private @Nullable Instant createdTime;

  private @Nullable Long createdBy;

  public OperationLogDto id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public OperationLogDto tenantId(@Nullable Long tenantId) {
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

  public OperationLogDto tenant(@Nullable TenantBasicDto tenant) {
    this.tenant = tenant;
    return this;
  }

  /**
   * Get tenant
   * @return tenant
   */
  
  @Schema(name = "tenant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tenant")
  public @Nullable TenantBasicDto getTenant() {
    return tenant;
  }

  public void setTenant(@Nullable TenantBasicDto tenant) {
    this.tenant = tenant;
  }

  public OperationLogDto ip(@Nullable String ip) {
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

  public OperationLogDto location(@Nullable String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  
  @Schema(name = "location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("location")
  public @Nullable String getLocation() {
    return location;
  }

  public void setLocation(@Nullable String location) {
    this.location = location;
  }

  public OperationLogDto method(@Nullable String method) {
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

  public OperationLogDto uri(@Nullable String uri) {
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

  public OperationLogDto os(@Nullable String os) {
    this.os = os;
    return this;
  }

  /**
   * Get os
   * @return os
   */
  
  @Schema(name = "os", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("os")
  public @Nullable String getOs() {
    return os;
  }

  public void setOs(@Nullable String os) {
    this.os = os;
  }

  public OperationLogDto browser(@Nullable String browser) {
    this.browser = browser;
    return this;
  }

  /**
   * Get browser
   * @return browser
   */
  
  @Schema(name = "browser", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("browser")
  public @Nullable String getBrowser() {
    return browser;
  }

  public void setBrowser(@Nullable String browser) {
    this.browser = browser;
  }

  public OperationLogDto request(@Nullable String request) {
    this.request = request;
    return this;
  }

  /**
   * Get request
   * @return request
   */
  
  @Schema(name = "request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("request")
  public @Nullable String getRequest() {
    return request;
  }

  public void setRequest(@Nullable String request) {
    this.request = request;
  }

  public OperationLogDto response(@Nullable String response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
   */
  
  @Schema(name = "response", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("response")
  public @Nullable String getResponse() {
    return response;
  }

  public void setResponse(@Nullable String response) {
    this.response = response;
  }

  public OperationLogDto time(@Nullable Long time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  
  @Schema(name = "time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public @Nullable Long getTime() {
    return time;
  }

  public void setTime(@Nullable Long time) {
    this.time = time;
  }

  public OperationLogDto createdTime(@Nullable Instant createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * Get createdTime
   * @return createdTime
   */
  
  @Schema(name = "createdTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdTime")
  public @Nullable Instant getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(@Nullable Instant createdTime) {
    this.createdTime = createdTime;
  }

  public OperationLogDto createdBy(@Nullable Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
   */
  
  @Schema(name = "createdBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdBy")
  public @Nullable Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(@Nullable Long createdBy) {
    this.createdBy = createdBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationLogDto operationLogDto = (OperationLogDto) o;
    return Objects.equals(this.id, operationLogDto.id) &&
        Objects.equals(this.tenantId, operationLogDto.tenantId) &&
        Objects.equals(this.tenant, operationLogDto.tenant) &&
        Objects.equals(this.ip, operationLogDto.ip) &&
        Objects.equals(this.location, operationLogDto.location) &&
        Objects.equals(this.method, operationLogDto.method) &&
        Objects.equals(this.uri, operationLogDto.uri) &&
        Objects.equals(this.os, operationLogDto.os) &&
        Objects.equals(this.browser, operationLogDto.browser) &&
        Objects.equals(this.request, operationLogDto.request) &&
        Objects.equals(this.response, operationLogDto.response) &&
        Objects.equals(this.time, operationLogDto.time) &&
        Objects.equals(this.createdTime, operationLogDto.createdTime) &&
        Objects.equals(this.createdBy, operationLogDto.createdBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, tenant, ip, location, method, uri, os, browser, request, response, time, createdTime, createdBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationLogDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    browser: ").append(toIndentedString(browser)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
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

