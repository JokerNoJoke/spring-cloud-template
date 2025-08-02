package com.sct.system.controller.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.system.entities.Dict;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictDto {

    private Long id;
    private String label;
    private String key;
    private List<ValueDto> values;
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static DictDto fromEntity(Dict entity) {
        DictDto dto = new DictDto();
        dto.setId(entity.getId());
        dto.setLabel(entity.getLabel());
        dto.setKey(entity.getKey());
        dto.setValues(Optional.ofNullable(entity.getValues()).orElse(List.of()).stream().map(ValueDto::fromEntity).toList());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Dict toCreatedEntity() {
        Dict createdEntity = new Dict();
        createdEntity.setLabel(this.label);
        createdEntity.setKey(this.key);
        createdEntity.setValues(Optional.ofNullable(this.values).orElse(List.of()).stream().map(ValueDto::toEntity).toList());
        return createdEntity;
    }

    public Dict toUpdatedEntity(Dict sourceEntity) {
        Dict updatedEntity = new Dict();
        updatedEntity.setId(sourceEntity.getId());
        updatedEntity.setLabel(Optional.ofNullable(this.label).orElse(sourceEntity.getLabel()));
        updatedEntity.setKey(Optional.ofNullable(this.key).orElse(sourceEntity.getKey()));
        updatedEntity.setValues(Optional.ofNullable(this.values).orElse(List.of()).stream().map(ValueDto::toEntity).toList());
        return updatedEntity;
    }

    @Getter
    @Setter
    public static class ValueDto {
        private String key;
        private String value;

        public static ValueDto fromEntity(Dict.Value entity) {
            ValueDto dto = new ValueDto();
            dto.setKey(entity.getKey());
            dto.setValue(entity.getValue());
            return dto;
        }

        public Dict.Value toEntity() {
            Dict.Value entity = new Dict.Value();
            entity.setKey(this.key);
            entity.setValue(this.value);
            return entity;
        }
    }
}