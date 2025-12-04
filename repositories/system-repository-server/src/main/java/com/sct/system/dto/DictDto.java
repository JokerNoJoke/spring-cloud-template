package com.sct.system.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.system.entity.Dict;

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
        dto.setValues(
                Optional.ofNullable(entity.getValues()).orElse(List.of()).stream().map(ValueDto::fromEntity).toList());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public Dict toCreatedEntity() {
        Dict createdEntity = new Dict();
        createdEntity.setLabel(this.label);
        createdEntity.setKey(this.key);
        createdEntity.setValues(
                Optional.ofNullable(this.values).orElse(List.of()).stream().map(ValueDto::toEntity).toList());
        return createdEntity;
    }

    public Dict updateEntity(Dict entity) {
        if (entity == null) {
            return null;
        }
        entity.setLabel(Optional.ofNullable(this.label).orElse(entity.getLabel()));
        entity.setKey(Optional.ofNullable(this.key).orElse(entity.getKey()));
        entity.setValues(
                Optional.ofNullable(this.values).orElse(List.of()).stream().map(ValueDto::toEntity).toList());
        return entity;
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