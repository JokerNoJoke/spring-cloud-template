package com.sct.demo.client.model;

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
 * DemoQueryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-20T00:20:47.826522800+08:00[Asia/Shanghai]", comments = "Generator version: 7.13.0")
public class DemoQueryDto {

  private @Nullable Integer column1;

  private @Nullable String column2;

  private @Nullable Boolean column3;

  public DemoQueryDto column1(Integer column1) {
    this.column1 = column1;
    return this;
  }

  /**
   * Get column1
   * @return column1
   */
  
  @Schema(name = "column1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column1")
  public Integer getColumn1() {
    return column1;
  }

  public void setColumn1(Integer column1) {
    this.column1 = column1;
  }

  public DemoQueryDto column2(String column2) {
    this.column2 = column2;
    return this;
  }

  /**
   * Get column2
   * @return column2
   */
  
  @Schema(name = "column2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column2")
  public String getColumn2() {
    return column2;
  }

  public void setColumn2(String column2) {
    this.column2 = column2;
  }

  public DemoQueryDto column3(Boolean column3) {
    this.column3 = column3;
    return this;
  }

  /**
   * Get column3
   * @return column3
   */
  
  @Schema(name = "column3", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column3")
  public Boolean getColumn3() {
    return column3;
  }

  public void setColumn3(Boolean column3) {
    this.column3 = column3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemoQueryDto demoQueryDto = (DemoQueryDto) o;
    return Objects.equals(this.column1, demoQueryDto.column1) &&
        Objects.equals(this.column2, demoQueryDto.column2) &&
        Objects.equals(this.column3, demoQueryDto.column3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(column1, column2, column3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemoQueryDto {\n");
    sb.append("    column1: ").append(toIndentedString(column1)).append("\n");
    sb.append("    column2: ").append(toIndentedString(column2)).append("\n");
    sb.append("    column3: ").append(toIndentedString(column3)).append("\n");
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

