package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sct.system.client.model.DeptBasicDto;
import com.sct.system.client.model.RoleBasicDto;
import com.sct.system.client.model.TenantBasicDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-10T10:12:59.932325+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class UserDto {

  private @Nullable Long id;

  private @Nullable Long tenantId;

  private @Nullable TenantBasicDto tenant;

  private @Nullable Long deptId;

  private @Nullable DeptBasicDto dept;

  private @Nullable String username;

  private @Nullable String password;

  private @Nullable String nickname;

  private @Nullable String mobile;

  private @Nullable String avatar;

  private @Nullable Boolean enabled;

  
  private List<RoleBasicDto> roles = new ArrayList<>();

  private @Nullable Instant createdTime;

  private @Nullable Long createdBy;

  private @Nullable Instant updatedTime;

  private @Nullable Long updatedBy;

  public UserDto id(@Nullable Long id) {
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

  public UserDto tenantId(@Nullable Long tenantId) {
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

  public UserDto tenant(@Nullable TenantBasicDto tenant) {
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

  public UserDto deptId(@Nullable Long deptId) {
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

  public UserDto dept(@Nullable DeptBasicDto dept) {
    this.dept = dept;
    return this;
  }

  /**
   * Get dept
   * @return dept
   */
  
  @Schema(name = "dept", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dept")
  public @Nullable DeptBasicDto getDept() {
    return dept;
  }

  public void setDept(@Nullable DeptBasicDto dept) {
    this.dept = dept;
  }

  public UserDto username(@Nullable String username) {
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

  public UserDto password(@Nullable String password) {
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

  public UserDto nickname(@Nullable String nickname) {
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

  public UserDto mobile(@Nullable String mobile) {
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

  public UserDto avatar(@Nullable String avatar) {
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

  public UserDto enabled(@Nullable Boolean enabled) {
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

  public UserDto roles(List<RoleBasicDto> roles) {
    this.roles = roles;
    return this;
  }

  public UserDto addRolesItem(RoleBasicDto rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
   */
  
  @Schema(name = "roles", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("roles")
  public List<RoleBasicDto> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleBasicDto> roles) {
    this.roles = roles;
  }

  public UserDto createdTime(@Nullable Instant createdTime) {
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

  public UserDto createdBy(@Nullable Long createdBy) {
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

  public UserDto updatedTime(@Nullable Instant updatedTime) {
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

  public UserDto updatedBy(@Nullable Long updatedBy) {
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
    UserDto userDto = (UserDto) o;
    return Objects.equals(this.id, userDto.id) &&
        Objects.equals(this.tenantId, userDto.tenantId) &&
        Objects.equals(this.tenant, userDto.tenant) &&
        Objects.equals(this.deptId, userDto.deptId) &&
        Objects.equals(this.dept, userDto.dept) &&
        Objects.equals(this.username, userDto.username) &&
        Objects.equals(this.password, userDto.password) &&
        Objects.equals(this.nickname, userDto.nickname) &&
        Objects.equals(this.mobile, userDto.mobile) &&
        Objects.equals(this.avatar, userDto.avatar) &&
        Objects.equals(this.enabled, userDto.enabled) &&
        Objects.equals(this.roles, userDto.roles) &&
        Objects.equals(this.createdTime, userDto.createdTime) &&
        Objects.equals(this.createdBy, userDto.createdBy) &&
        Objects.equals(this.updatedTime, userDto.updatedTime) &&
        Objects.equals(this.updatedBy, userDto.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, tenant, deptId, dept, username, password, nickname, mobile, avatar, enabled, roles, createdTime, createdBy, updatedTime, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
    sb.append("    deptId: ").append(toIndentedString(deptId)).append("\n");
    sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

