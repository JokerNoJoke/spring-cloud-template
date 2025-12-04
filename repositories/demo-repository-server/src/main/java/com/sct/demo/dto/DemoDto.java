package com.sct.demo.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import com.sct.demo.entity.Demo;

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

    public Demo updateEntity(Demo entity) {
        if (entity == null) {
            return null;
        }
        entity.setColumn1(this.column1 == null ? entity.getColumn1() : this.column1);
        entity.setColumn2(this.column2 == null ? entity.getColumn2() : this.column2);
        entity.setColumn3(this.column3 == null ? entity.getColumn3() : this.column3);
        entity.setColumn4(this.column4 == null ? entity.getColumn4() : this.column4);
        entity.setColumn5(this.column5 == null ? entity.getColumn5() : this.column5);
        entity.setColumn6(this.column6 == null ? entity.getColumn6() : this.column6);
        return entity;
    }
}