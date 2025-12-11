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
 * SystemConfigQueryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class SystemConfigQueryDto {

  private @Nullable String name;

  private @Nullable String code;

  private @Nullable Boolean builtIn;

  public SystemConfigQueryDto name(@Nullable String name) {
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

  public SystemConfigQueryDto code(@Nullable String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  
  @Schema(name = "code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public @Nullable String getCode() {
    return code;
  }

  public void setCode(@Nullable String code) {
    this.code = code;
  }

  public SystemConfigQueryDto builtIn(@Nullable Boolean builtIn) {
    this.builtIn = builtIn;
    return this;
  }

  /**
   * Get builtIn
   * @return builtIn
   */
  
  @Schema(name = "builtIn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("builtIn")
  public @Nullable Boolean getBuiltIn() {
    return builtIn;
  }

  public void setBuiltIn(@Nullable Boolean builtIn) {
    this.builtIn = builtIn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemConfigQueryDto systemConfigQueryDto = (SystemConfigQueryDto) o;
    return Objects.equals(this.name, systemConfigQueryDto.name) &&
        Objects.equals(this.code, systemConfigQueryDto.code) &&
        Objects.equals(this.builtIn, systemConfigQueryDto.builtIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code, builtIn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemConfigQueryDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    builtIn: ").append(toIndentedString(builtIn)).append("\n");
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

