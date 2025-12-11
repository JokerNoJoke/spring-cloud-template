package com.sct.demo.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * PageRequestDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T15:05:11.163892+08:00[Asia/Shanghai]", comments = "Generator version: 7.17.0")
public class PageRequestDto {

  
  private List<String> orders = new ArrayList<>();

  private @Nullable Integer pageNumber;

  private @Nullable Integer pageSize;

  public PageRequestDto orders(List<String> orders) {
    this.orders = orders;
    return this;
  }

  public PageRequestDto addOrdersItem(String ordersItem) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
   */
  
  @Schema(name = "orders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orders")
  public List<String> getOrders() {
    return orders;
  }

  public void setOrders(List<String> orders) {
    this.orders = orders;
  }

  public PageRequestDto pageNumber(@Nullable Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * Get pageNumber
   * @return pageNumber
   */
  
  @Schema(name = "pageNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageNumber")
  public @Nullable Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(@Nullable Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public PageRequestDto pageSize(@Nullable Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
   */
  
  @Schema(name = "pageSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageSize")
  public @Nullable Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(@Nullable Integer pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageRequestDto pageRequestDto = (PageRequestDto) o;
    return Objects.equals(this.orders, pageRequestDto.orders) &&
        Objects.equals(this.pageNumber, pageRequestDto.pageNumber) &&
        Objects.equals(this.pageSize, pageRequestDto.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orders, pageNumber, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageRequestDto {\n");
    sb.append("    orders: ").append(toIndentedString(orders)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

