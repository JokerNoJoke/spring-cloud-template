### 实体类模板
```java
package com.sct.{module}.entities;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`{entity_name_lower}`", indexes = {
    @Index(name = "idx_{entity_name_lower}_{field1}", columnList = "{field1}"),
    @Index(name = "idx_{entity_name_lower}_{field2}", columnList = "{field2}")
})
@SoftDelete(columnName = "is_deleted")
public class {EntityName} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String {field1};
    private String {field2};
    // ... 其他字段

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

    @UpdateTimestamp
    private Instant updatedTime;

    // 关联关系（如适用）
    @ManyToMany
    @JoinTable(name = "{entity_name_lower}_{related_entity_lower}", joinColumns = {
        @JoinColumn(name = "{entity_name_lower}_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "{related_entity_lower}_id", referencedColumnName = "id")
    }, foreignKey = @ForeignKey(name = "fk_{entity_name_lower}_{related_entity_lower}_{entity_name_lower}_id"), inverseForeignKey = @ForeignKey(name = "fk_{entity_name_lower}_{related_entity_lower}_{related_entity_lower}_id"))
    private List<{RelatedEntity}> {relatedEntityPlural};
}
```

### 基础DTO模板（用于关联关系）
```java
package com.sct.{module}.controller.dto;

import java.time.Instant;

import com.sct.{module}.entities.{EntityName};

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class {EntityName}BasicDto {

    private Long id;
    private String {field1};
    private String {field2};
    // ... 其他字段
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;

    public static {EntityName}BasicDto fromEntity({EntityName} entity) {
        {EntityName}BasicDto dto = new {EntityName}BasicDto();
        dto.setId(entity.getId());
        dto.set{Field1}(entity.get{Field1}());
        dto.set{Field2}(entity.get{Field2}());
        // ... 其他字段映射
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public {EntityName} toReferencedEntity() {
        {EntityName} referencedEntity = new {EntityName}();
        referencedEntity.setId(this.id);
        return referencedEntity;
    }
}
```

### DTO模板
```java
package com.sct.{module}.controller.dto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.sct.{module}.entities.{EntityName};

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class {EntityName}Dto {

    private Long id;
    private String {field1};
    private String {field2};
    // ... 其他字段
    @Schema(format = "instant")
    private Instant createdTime;
    @Schema(format = "instant")
    private Instant updatedTime;
    // 关联关系（如适用）
    private List<{RelatedEntity}BasicDto> {relatedEntityPlural};

    public static {EntityName}Dto fromEntity({EntityName} entity) {
        {EntityName}Dto dto = new {EntityName}Dto();
        dto.setId(entity.getId());
        dto.set{Field1}(entity.get{Field1}());
        dto.set{Field2}(entity.get{Field2}());
        // ... 其他字段映射
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        dto.set{RelatedEntity}(Optional.ofNullable(entity.get{RelatedEntity}()).orElse(List.of()).stream().map({RelatedEntity}BasicDto::fromEntity).toList());
        return dto;
    }

    public {EntityName} toCreatedEntity() {
        {EntityName} createdEntity = new {EntityName}();
        createdEntity.set{Field1}(this.{field1});
        createdEntity.set{Field2}(this.{field2});
        // ... 其他字段映射
        createdEntity.set{RelatedEntity}(Optional.ofNullable(this.{relatedEntityPlural}).orElse(List.of()).stream().map({RelatedEntity}BasicDto::toReferencedEntity).toList());
        return createdEntity;
    }

    public {EntityName} toUpdatedEntity({EntityName} sourceEntity) {
        {EntityName} updatedEntity = new {EntityName}();
        updatedEntity.setId(sourceEntity.getId());
        updatedEntity.set{Field1}(Optional.ofNullable(this.{field1}).orElse(sourceEntity.get{Field1}()));
        updatedEntity.set{Field2}(Optional.ofNullable(this.{field2}).orElse(sourceEntity.get{Field2}()));
        // ... 其他字段映射
        updatedEntity.set{RelatedEntity}(Optional.ofNullable(this.{relatedEntityPlural}).orElse(List.of()).stream().map({RelatedEntity}BasicDto::toReferencedEntity).toList());
        return updatedEntity;
    }
}
```

### 查询DTO模板
```java
package com.sct.{module}.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.{module}.entities.{EntityName};

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class {EntityName}QueryDto {

    private String {field1};
    private String {field2};
    // ... 其他查询字段

    public Example<{EntityName}> toExample() {
        {EntityName} entity = new {EntityName}();
        if (this.{field1} != null) {
            entity.set{Field1}(this.{field1});
        }
        if (this.{field2} != null) {
            entity.set{Field2}(this.{field2});
        }
        // ... 其他字段设置

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher("{field1}", ExampleMatcher.GenericPropertyMatchers.contains())
            .withMatcher("{field2}", ExampleMatcher.GenericPropertyMatchers.contains());
            // ... 其他字段匹配器
        return Example.of(entity, matcher);
    }
}
```

### 控制器模板
```java
package com.sct.{module}.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.{module}.controller.dto.{EntityName}Dto;
import com.sct.{module}.controller.dto.{EntityName}QueryDto;
import com.sct.{module}.entities.{EntityName};
import com.sct.{module}.repositories.{EntityName}Repository;

@RestController
@RequestMapping("{entity_name_lower}")
public class {EntityName}Controller {

    @Autowired
    private {EntityName}Repository repository;

    @PostMapping
    public ResponseEntity<Void> create{EntityName}(@RequestBody {EntityName}Dto dto) {
        {EntityName} createdEntity = dto.toCreatedEntity();
        {EntityName} savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<{EntityName}Dto>> findAll{EntityName}By({EntityName}QueryDto dto) {
        List<{EntityName}> list = repository.findAll(dto.toExample());
        List<{EntityName}Dto> dtos = list.stream().map({EntityName}Dto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<{EntityName}BasicDto>> findAll{EntityName}BasicBy({EntityName}QueryDto dto) {
        List<{EntityName}> list = repository.findAll(dto.toExample());
        List<{EntityName}BasicDto> dtos = list.stream().map({EntityName}BasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAll{EntityName}By({EntityName}QueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
    }

    @GetMapping("{id}")
    public ResponseEntity<{EntityName}Dto> find{EntityName}ById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map({EntityName}Dto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update{EntityName}ById(@PathVariable("id") Long id, @RequestBody {EntityName}Dto dto) {
        return repository.findById(id)
                .map(dto::toUpdatedEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete{EntityName}ById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
```

### 仓库接口模板
```java
package com.sct.{module}.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.{module}.entities.{EntityName};

public interface {EntityName}Repository extends JpaRepository<{EntityName}, Long> {
    // 自定义查询方法
}
```

### 使用说明
1. 将 `{module}` 替换为实际模块名称
2. 将 `{EntityName}` 替换为实体类名（如User、Role等）
3. 将 `{entity_name_lower}` 替换为小写的实体类名
4. 将 `{field1}`, `{field2}` 等替换为实际字段名
5. 将 `{RelatedEntity}` 替换为关联的实体类名（如Role等）
6. 将 `{related_entity_lower}` 替换为小写的关联实体类名
7. 将 `{relatedEntityPlural}` 替换为关联实体的复数形式（如roles等）
8. 根据需要调整关联关系和查询条件
9. 模板中使用了Lombok、Spring Data JPA等依赖，确保项目中已添加相关依赖