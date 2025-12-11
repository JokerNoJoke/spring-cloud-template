package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sct.system.client.model.DeptDto;
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
 * PageResponseDtoDeptDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:51:39.505559+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class PageResponseDtoDeptDto {

  
  private List<DeptDto> content = new ArrayList<>();

  private @Nullable Long totalElements;

  private @Nullable Integer totalPages;

  public PageResponseDtoDeptDto content(List<DeptDto> content) {
    this.content = content;
    return this;
  }

  public PageResponseDtoDeptDto addContentItem(DeptDto contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
   */
  
  @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public List<DeptDto> getContent() {
    return content;
  }

  public void setContent(List<DeptDto> content) {
    this.content = content;
  }

  public PageResponseDtoDeptDto totalElements(@Nullable Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
   */
  
  @Schema(name = "totalElements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalElements")
  public @Nullable Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(@Nullable Long totalElements) {
    this.totalElements = totalElements;
  }

  public PageResponseDtoDeptDto totalPages(@Nullable Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
   */
  
  @Schema(name = "totalPages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public @Nullable Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(@Nullable Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageResponseDtoDeptDto pageResponseDtoDeptDto = (PageResponseDtoDeptDto) o;
    return Objects.equals(this.content, pageResponseDtoDeptDto.content) &&
        Objects.equals(this.totalElements, pageResponseDtoDeptDto.totalElements) &&
        Objects.equals(this.totalPages, pageResponseDtoDeptDto.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageResponseDtoDeptDto {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

