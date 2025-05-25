package com.sct.demo.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DemoDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-20T00:20:47.826522800+08:00[Asia/Shanghai]", comments = "Generator version: 7.13.0")
public class DemoDto {

  private @Nullable Long id;

  private @Nullable Integer column1;

  private @Nullable String column2;

  private @Nullable Boolean column3;

  private @Nullable Instant column4;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate column5;

  private @Nullable LocalTime column6;

  public DemoDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DemoDto column1(Integer column1) {
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

  public DemoDto column2(String column2) {
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

  public DemoDto column3(Boolean column3) {
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

  public DemoDto column4(Instant column4) {
    this.column4 = column4;
    return this;
  }

  /**
   * Get column4
   * @return column4
   */
  
  @Schema(name = "column4", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column4")
  public Instant getColumn4() {
    return column4;
  }

  public void setColumn4(Instant column4) {
    this.column4 = column4;
  }

  public DemoDto column5(LocalDate column5) {
    this.column5 = column5;
    return this;
  }

  /**
   * Get column5
   * @return column5
   */
  
  @Schema(name = "column5", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column5")
  public LocalDate getColumn5() {
    return column5;
  }

  public void setColumn5(LocalDate column5) {
    this.column5 = column5;
  }

  public DemoDto column6(LocalTime column6) {
    this.column6 = column6;
    return this;
  }

  /**
   * Get column6
   * @return column6
   */
  
  @Schema(name = "column6", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("column6")
  public LocalTime getColumn6() {
    return column6;
  }

  public void setColumn6(LocalTime column6) {
    this.column6 = column6;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemoDto demoDto = (DemoDto) o;
    return Objects.equals(this.id, demoDto.id) &&
        Objects.equals(this.column1, demoDto.column1) &&
        Objects.equals(this.column2, demoDto.column2) &&
        Objects.equals(this.column3, demoDto.column3) &&
        Objects.equals(this.column4, demoDto.column4) &&
        Objects.equals(this.column5, demoDto.column5) &&
        Objects.equals(this.column6, demoDto.column6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, column1, column2, column3, column4, column5, column6);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemoDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    column1: ").append(toIndentedString(column1)).append("\n");
    sb.append("    column2: ").append(toIndentedString(column2)).append("\n");
    sb.append("    column3: ").append(toIndentedString(column3)).append("\n");
    sb.append("    column4: ").append(toIndentedString(column4)).append("\n");
    sb.append("    column5: ").append(toIndentedString(column5)).append("\n");
    sb.append("    column6: ").append(toIndentedString(column6)).append("\n");
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

