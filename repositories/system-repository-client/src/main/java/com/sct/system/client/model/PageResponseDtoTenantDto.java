package com.sct.system.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sct.system.client.model.TenantDto;
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
 * PageResponseDtoTenantDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-10T10:12:59.932325+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class PageResponseDtoTenantDto {

  
  private List<TenantDto> content = new ArrayList<>();

  private @Nullable Long totalElements;

  private @Nullable Integer totalPages;

  public PageResponseDtoTenantDto content(List<TenantDto> content) {
    this.content = content;
    return this;
  }

  public PageResponseDtoTenantDto addContentItem(TenantDto contentItem) {
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
  public List<TenantDto> getContent() {
    return content;
  }

  public void setContent(List<TenantDto> content) {
    this.content = content;
  }

  public PageResponseDtoTenantDto totalElements(@Nullable Long totalElements) {
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

  public PageResponseDtoTenantDto totalPages(@Nullable Integer totalPages) {
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
    PageResponseDtoTenantDto pageResponseDtoTenantDto = (PageResponseDtoTenantDto) o;
    return Objects.equals(this.content, pageResponseDtoTenantDto.content) &&
        Objects.equals(this.totalElements, pageResponseDtoTenantDto.totalElements) &&
        Objects.equals(this.totalPages, pageResponseDtoTenantDto.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageResponseDtoTenantDto {\n");
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

