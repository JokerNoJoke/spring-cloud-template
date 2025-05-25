package com.sct.demo.controller.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import com.sct.demo.entities.Demo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoDto {

    private Long id;
    private Integer column1;
    private String column2;
    private Boolean column3;
    @Schema(format = "instant")
    private Instant column4;
    private LocalDate column5;
    @Schema(format = "local-time")
    private LocalTime column6;

    public static DemoDto fromEntity(Demo entity) {
        DemoDto dto = new DemoDto();
        dto.setId(entity.getId());
        dto.setColumn1(entity.getColumn1());
        dto.setColumn2(entity.getColumn2());
        dto.setColumn3(entity.getColumn3());
        dto.setColumn4(entity.getColumn4());
        dto.setColumn5(entity.getColumn5());
        dto.setColumn6(entity.getColumn6());
        return dto;
    }

    public Demo toCreatedEntity() {
        Demo createdEntity = new Demo();
        createdEntity.setColumn1(this.column1);
        createdEntity.setColumn2(this.column2);
        createdEntity.setColumn3(this.column3);
        createdEntity.setColumn4(this.column4);
        createdEntity.setColumn5(this.column5);
        createdEntity.setColumn6(this.column6);
        return createdEntity;
    }

    public Demo toUpdatedEntity(Demo sourceEntity) {
        Demo updatedEntity = new Demo();
        updatedEntity.setId(sourceEntity.getId());
        updatedEntity.setColumn1(this.column1 == null ? sourceEntity.getColumn1() : this.column1);
        updatedEntity.setColumn2(this.column2 == null ? sourceEntity.getColumn2() : this.column2);
        updatedEntity.setColumn3(this.column3 == null ? sourceEntity.getColumn3() : this.column3);
        updatedEntity.setColumn4(this.column4 == null ? sourceEntity.getColumn4() : this.column4);
        updatedEntity.setColumn5(this.column5 == null ? sourceEntity.getColumn5() : this.column5);
        updatedEntity.setColumn6(this.column6 == null ? sourceEntity.getColumn6() : this.column6);
        return updatedEntity;
    }
}