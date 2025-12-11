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
 * UserQueryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class UserQueryDto {

  private @Nullable Long tenantId;

  private @Nullable Long deptId;

  private @Nullable String username;

  private @Nullable String nickname;

  private @Nullable String mobile;

  public UserQueryDto tenantId(@Nullable Long tenantId) {
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

  public UserQueryDto deptId(@Nullable Long deptId) {
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

  public UserQueryDto username(@Nullable String username) {
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

  public UserQueryDto nickname(@Nullable String nickname) {
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

  public UserQueryDto mobile(@Nullable String mobile) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserQueryDto userQueryDto = (UserQueryDto) o;
    return Objects.equals(this.tenantId, userQueryDto.tenantId) &&
        Objects.equals(this.deptId, userQueryDto.deptId) &&
        Objects.equals(this.username, userQueryDto.username) &&
        Objects.equals(this.nickname, userQueryDto.nickname) &&
        Objects.equals(this.mobile, userQueryDto.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, deptId, username, nickname, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserQueryDto {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    deptId: ").append(toIndentedString(deptId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
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

