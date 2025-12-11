package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.Instant;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TenantDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class TenantDto {

  private @Nullable Long id;

  private @Nullable String name;

  private @Nullable Boolean enabled;

  private @Nullable Instant createdTime;

  private @Nullable Long createdBy;

  private @Nullable Instant updatedTime;

  private @Nullable Long updatedBy;

  public TenantDto id(@Nullable Long id) {
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

  public TenantDto name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public TenantDto enabled(@Nullable Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
   */
  
  @Schema(name = "enabled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enabled")
  public @Nullable Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(@Nullable Boolean enabled) {
    this.enabled = enabled;
  }

  public TenantDto createdTime(@Nullable Instant createdTime) {
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

  public TenantDto createdBy(@Nullable Long createdBy) {
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

  public TenantDto updatedTime(@Nullable Instant updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * Get updatedTime
   * @return updatedTime
   */
  
  @Schema(name = "updatedTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedTime")
  public @Nullable Instant getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(@Nullable Instant updatedTime) {
    this.updatedTime = updatedTime;
  }

  public TenantDto updatedBy(@Nullable Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
   */
  
  @Schema(name = "updatedBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedBy")
  public @Nullable Long getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(@Nullable Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantDto tenantDto = (TenantDto) o;
    return Objects.equals(this.id, tenantDto.id) &&
        Objects.equals(this.name, tenantDto.name) &&
        Objects.equals(this.enabled, tenantDto.enabled) &&
        Objects.equals(this.createdTime, tenantDto.createdTime) &&
        Objects.equals(this.createdBy, tenantDto.createdBy) &&
        Objects.equals(this.updatedTime, tenantDto.updatedTime) &&
        Objects.equals(this.updatedBy, tenantDto.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, enabled, createdTime, createdBy, updatedTime, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
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

