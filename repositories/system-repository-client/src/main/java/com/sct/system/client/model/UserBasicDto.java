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
 * UserBasicDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class UserBasicDto {

  private @Nullable Long id;

  private @Nullable Long tenantId;

  private @Nullable Long deptId;

  private @Nullable String username;

  private @Nullable String password;

  private @Nullable String nickname;

  private @Nullable String mobile;

  private @Nullable String avatar;

  private @Nullable Boolean enabled;

  private @Nullable Instant createdTime;

  private @Nullable Long createdBy;

  private @Nullable Instant updatedTime;

  private @Nullable Long updatedBy;

  public UserBasicDto id(@Nullable Long id) {
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

  public UserBasicDto tenantId(@Nullable Long tenantId) {
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

  public UserBasicDto deptId(@Nullable Long deptId) {
    this.deptId = deptId;
    return this;
  }

  /**
   * Get deptId
   * @return deptId
   */
  
  @Schema(name = "deptId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deptId")
  public @Nullable Long getDeptId() {
    return deptId;
  }

  public void setDeptId(@Nullable Long deptId) {
    this.deptId = deptId;
  }

  public UserBasicDto username(@Nullable String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  
  @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public @Nullable String getUsername() {
    return username;
  }

  public void setUsername(@Nullable String username) {
    this.username = username;
  }

  public UserBasicDto password(@Nullable String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */
  
  @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public @Nullable String getPassword() {
    return password;
  }

  public void setPassword(@Nullable String password) {
    this.password = password;
  }

  public UserBasicDto nickname(@Nullable String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * Get nickname
   * @return nickname
   */
  
  @Schema(name = "nickname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nickname")
  public @Nullable String getNickname() {
    return nickname;
  }

  public void setNickname(@Nullable String nickname) {
    this.nickname = nickname;
  }

  public UserBasicDto mobile(@Nullable String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
   */
  
  @Schema(name = "mobile", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mobile")
  public @Nullable String getMobile() {
    return mobile;
  }

  public void setMobile(@Nullable String mobile) {
    this.mobile = mobile;
  }

  public UserBasicDto avatar(@Nullable String avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * Get avatar
   * @return avatar
   */
  
  @Schema(name = "avatar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar")
  public @Nullable String getAvatar() {
    return avatar;
  }

  public void setAvatar(@Nullable String avatar) {
    this.avatar = avatar;
  }

  public UserBasicDto enabled(@Nullable Boolean enabled) {
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

  public UserBasicDto createdTime(@Nullable Instant createdTime) {
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

  public UserBasicDto createdBy(@Nullable Long createdBy) {
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

  public UserBasicDto updatedTime(@Nullable Instant updatedTime) {
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

  public UserBasicDto updatedBy(@Nullable Long updatedBy) {
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
    UserBasicDto userBasicDto = (UserBasicDto) o;
    return Objects.equals(this.id, userBasicDto.id) &&
        Objects.equals(this.tenantId, userBasicDto.tenantId) &&
        Objects.equals(this.deptId, userBasicDto.deptId) &&
        Objects.equals(this.username, userBasicDto.username) &&
        Objects.equals(this.password, userBasicDto.password) &&
        Objects.equals(this.nickname, userBasicDto.nickname) &&
        Objects.equals(this.mobile, userBasicDto.mobile) &&
        Objects.equals(this.avatar, userBasicDto.avatar) &&
        Objects.equals(this.enabled, userBasicDto.enabled) &&
        Objects.equals(this.createdTime, userBasicDto.createdTime) &&
        Objects.equals(this.createdBy, userBasicDto.createdBy) &&
        Objects.equals(this.updatedTime, userBasicDto.updatedTime) &&
        Objects.equals(this.updatedBy, userBasicDto.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, deptId, username, password, nickname, mobile, avatar, enabled, createdTime, createdBy, updatedTime, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBasicDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    deptId: ").append(toIndentedString(deptId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
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

