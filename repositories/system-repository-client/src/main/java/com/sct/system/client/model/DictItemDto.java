package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sct.system.client.model.DictTypeBasicDto;
import java.time.Instant;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DictItemDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-10T10:12:59.932325+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class DictItemDto {

  private @Nullable Long id;

  private @Nullable Long dictTypeId;

  private @Nullable DictTypeBasicDto dictType;

  private @Nullable String label;

  private @Nullable String value;

  private @Nullable Integer sortOrder;

  private @Nullable Boolean enabled;

  private @Nullable Instant createdTime;

  private @Nullable Long createdBy;

  private @Nullable Instant updatedTime;

  private @Nullable Long updatedBy;

  public DictItemDto id(@Nullable Long id) {
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

  public DictItemDto dictTypeId(@Nullable Long dictTypeId) {
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

  public DictItemDto dictType(@Nullable DictTypeBasicDto dictType) {
    this.dictType = dictType;
    return this;
  }

  /**
   * Get dictType
   * @return dictType
   */
  
  @Schema(name = "dictType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dictType")
  public @Nullable DictTypeBasicDto getDictType() {
    return dictType;
  }

  public void setDictType(@Nullable DictTypeBasicDto dictType) {
    this.dictType = dictType;
  }

  public DictItemDto label(@Nullable String label) {
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

  public DictItemDto value(@Nullable String value) {
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

  public DictItemDto sortOrder(@Nullable Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Get sortOrder
   * @return sortOrder
   */
  
  @Schema(name = "sortOrder", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sortOrder")
  public @Nullable Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(@Nullable Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  public DictItemDto enabled(@Nullable Boolean enabled) {
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

  public DictItemDto createdTime(@Nullable Instant createdTime) {
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

  public DictItemDto createdBy(@Nullable Long createdBy) {
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

  public DictItemDto updatedTime(@Nullable Instant updatedTime) {
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

  public DictItemDto updatedBy(@Nullable Long updatedBy) {
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
    DictItemDto dictItemDto = (DictItemDto) o;
    return Objects.equals(this.id, dictItemDto.id) &&
        Objects.equals(this.dictTypeId, dictItemDto.dictTypeId) &&
        Objects.equals(this.dictType, dictItemDto.dictType) &&
        Objects.equals(this.label, dictItemDto.label) &&
        Objects.equals(this.value, dictItemDto.value) &&
        Objects.equals(this.sortOrder, dictItemDto.sortOrder) &&
        Objects.equals(this.enabled, dictItemDto.enabled) &&
        Objects.equals(this.createdTime, dictItemDto.createdTime) &&
        Objects.equals(this.createdBy, dictItemDto.createdBy) &&
        Objects.equals(this.updatedTime, dictItemDto.updatedTime) &&
        Objects.equals(this.updatedBy, dictItemDto.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dictTypeId, dictType, label, value, sortOrder, enabled, createdTime, createdBy, updatedTime, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictItemDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dictTypeId: ").append(toIndentedString(dictTypeId)).append("\n");
    sb.append("    dictType: ").append(toIndentedString(dictType)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
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

