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
 * DictItemQueryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class DictItemQueryDto {

  private @Nullable Long dictTypeId;

  private @Nullable String label;

  private @Nullable String value;

  private @Nullable Boolean enabled;

  public DictItemQueryDto dictTypeId(@Nullable Long dictTypeId) {
    this.dictTypeId = dictTypeId;
    return this;
  }

  /**
   * Get dictTypeId
   * @return dictTypeId
   */
  
  @Schema(name = "dictTypeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dictTypeId")
  public @Nullable Long getDictTypeId() {
    return dictTypeId;
  }

  public void setDictTypeId(@Nullable Long dictTypeId) {
    this.dictTypeId = dictTypeId;
  }

  public DictItemQueryDto label(@Nullable String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
   */
  
  @Schema(name = "label", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("label")
  public @Nullable String getLabel() {
    return label;
  }

  public void setLabel(@Nullable String label) {
    this.label = label;
  }

  public DictItemQueryDto value(@Nullable String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  
  @Schema(name = "value", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public @Nullable String getValue() {
    return value;
  }

  public void setValue(@Nullable String value) {
    this.value = value;
  }

  public DictItemQueryDto enabled(@Nullable Boolean enabled) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictItemQueryDto dictItemQueryDto = (DictItemQueryDto) o;
    return Objects.equals(this.dictTypeId, dictItemQueryDto.dictTypeId) &&
        Objects.equals(this.label, dictItemQueryDto.label) &&
        Objects.equals(this.value, dictItemQueryDto.value) &&
        Objects.equals(this.enabled, dictItemQueryDto.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dictTypeId, label, value, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictItemQueryDto {\n");
    sb.append("    dictTypeId: ").append(toIndentedString(dictTypeId)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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

