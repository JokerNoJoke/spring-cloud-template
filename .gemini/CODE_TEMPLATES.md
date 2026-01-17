# Code Generation Templates

Use these templates when generating new domain objects. Replace placeholders like `${EntityName}`, `${Module}`, and `${PathName}` accordingly.

## Variables
- `${EntityName}`: PascalCase name of the entity (e.g., `JobAssignment`)
- `${Module}`: lowercase package name (e.g., `job`)
- `${PathName}`: kebab-case resource name for URL (e.g., `job-assignment`)
- `${Comment}`: Description of the entity
- `${EntityNameLower}`: camelCase name of the entity variable (e.g., `jobAssignment`)

---

## 1. Entity
**Path:** `src/main/java/com/sct/${Module}/entity/${EntityName}.java`

```java
package com.sct.${Module}.entity;

import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(comment = "${Comment}")
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class ${EntityName} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Add specific fields here
    // @Column(comment = "Name")
    // private String name;

    // Example: Relationship
    // @ManyToOne
    // private Organization organization;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
```

---

## 2. Repository
**Path:** `src/main/java/com/sct/${Module}/repository/${EntityName}Repository.java`

```java
package com.sct.${Module}.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.sct.${Module}.entity.${EntityName};

public interface ${EntityName}Repository extends CrudRepository<${EntityName}, Long>, QuerydslPredicateExecutor<${EntityName}> {

}
```

---

## 3. Basic DTO
**Path:** `src/main/java/com/sct/${Module}/dto/${EntityName}BasicDto.java`

```java
package com.sct.${Module}.dto;

import java.time.Instant;
import com.sct.${Module}.entity.${EntityName};
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${EntityName}BasicDto {

    private Long id;
    // TODO: Add basic fields (name, code, etc.). Do NOT include associated object properties.
    // Example:
    // private String name;
    @Schema(type = "string")
    private Instant createdAt;
    @Schema(type = "string")
    private Instant updatedAt;

    public static ${EntityName}BasicDto fromEntity(${EntityName} entity) {
        if (entity == null) {
            return null;
        }
        ${EntityName}BasicDto dto = new ${EntityName}BasicDto();
        dto.setId(entity.getId());
        // TODO: Map fields
        // dto.setName(entity.getName());
        
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public ${EntityName} toReferencedEntity() {
        if (this.id == null) {
            return null;
        }
        ${EntityName} entity = new ${EntityName}();
        entity.setId(this.id);
        return entity;
    }

}
```

---

## 4. Full DTO
**Path:** `src/main/java/com/sct/${Module}/dto/${EntityName}Dto.java`

```java
package com.sct.${Module}.dto;

import java.time.Instant;
import java.util.Optional;
import com.sct.${Module}.entity.${EntityName};
// TODO: Import referenced BasicDtos if needed
// import com.sct.organization.dto.OrganizationBasicDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${EntityName}Dto {

    private Long id;
    
    // TODO: Add fields
    // private String name;
    
    // Example: Relationship Field
    // private OrganizationBasicDto organization;

    @Schema(type = "string")
    private Instant createdAt;
    @Schema(type = "string")
    private Instant updatedAt;

    public static ${EntityName}Dto fromEntity(${EntityName} entity) {
        if (entity == null) {
            return null;
        }
        ${EntityName}Dto dto = new ${EntityName}Dto();
        dto.setId(entity.getId());
        
        // TODO: Map fields
        // dto.setName(entity.getName());
        
        // Example: Map Relationship
        // dto.setOrganization(OrganizationBasicDto.fromEntity(entity.getOrganization()));

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public ${EntityName} toCreatedEntity() {
        ${EntityName} entity = new ${EntityName}();
        
        // TODO: Map fields for creation
        // entity.setName(this.name);
        
        // NOTE: Do NOT map fields marked with insertable = false.
        
        // Example: Map Relationship for Creation
        // entity.setOrganization(this.organization != null ? this.organization.toReferencedEntity() : null);

        return entity;
    }

    public ${EntityName} updateEntity(${EntityName} entity) {
        if (entity == null) {
            return null;
        }
        
        // TODO: Map fields for update using Optional
        // entity.setName(Optional.ofNullable(this.name).orElse(entity.getName()));
        
        // NOTE: Do NOT map fields marked with updatable = false.
        
        // Example: Map Relationship for Update
        // entity.setOrganization(Optional.ofNullable(this.organization)
        //        .map(OrganizationBasicDto::toReferencedEntity)
        //        .orElse(entity.getOrganization()));
        
        return entity;
    }

}
```

---

## 5. Query DTO
**Path:** `src/main/java/com/sct/${Module}/dto/${EntityName}QueryDto.java`

```java
package com.sct.${Module}.dto;

import com.sct.${Module}.entity.Q${EntityName};
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${EntityName}QueryDto {

    // TODO: Add query fields
    // private String name;
    // private Long organizationId;

    public Predicate toPredicate() {
        Q${EntityName} qEntity = Q${EntityName}.${EntityNameLower}; 
        BooleanBuilder builder = new BooleanBuilder();

        // TODO: Build predicate
        // if (name != null && !name.isBlank()) {
        //     builder.and(qEntity.name.contains(name));
        // }
        // if (organizationId != null) {
        //     builder.and(qEntity.organization.id.eq(organizationId));
        // }

        return builder;
    }

}
```

---

## 6. Controller
**Path:** `src/main/java/com/sct/${Module}/controller/${EntityName}Controller.java`

```java
package com.sct.${Module}.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.sct.${Module}.common.PageRequestDto;
import com.sct.${Module}.common.PageResponseDto;
import com.sct.${Module}.dto.${EntityName}BasicDto;
import com.sct.${Module}.dto.${EntityName}Dto;
import com.sct.${Module}.dto.${EntityName}QueryDto;
import com.sct.${Module}.entity.${EntityName};
import com.sct.${Module}.repository.${EntityName}Repository;

@RestController
@RequestMapping("/api/v1/${Module}/${PathName}")
public class ${EntityName}Controller {

    @Autowired
    private ${EntityName}Repository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> create${EntityName}(@RequestBody ${EntityName}Dto dto) {
        ${EntityName} createdEntity = dto.toCreatedEntity();
        ${EntityName} savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<${EntityName}Dto>> findAll${EntityName}By(
            @ModelAttribute ${EntityName}QueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<${EntityName}Dto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<${EntityName}> page = repository.findAll(predicate, pageable);
            List<${EntityName}Dto> dtos = page.getContent().stream()
                    .map(${EntityName}Dto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<${EntityName}> list = (List<${EntityName}>) repository.findAll(predicate, sort);
            List<${EntityName}Dto> dtos = list.stream()
                    .map(${EntityName}Dto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<${EntityName}BasicDto>> findAll${EntityName}BasicBy(
            @ModelAttribute ${EntityName}QueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<${EntityName}BasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<${EntityName}> page = repository.findAll(predicate, pageable);
            List<${EntityName}BasicDto> dtos = page.getContent().stream()
                    .map(${EntityName}BasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<${EntityName}> list = (List<${EntityName}>) repository.findAll(predicate, sort);
            List<${EntityName}BasicDto> dtos = list.stream()
                    .map(${EntityName}BasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> count${EntityName}By(@ModelAttribute ${EntityName}QueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<${EntityName}Dto> get${EntityName}ById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(${EntityName}Dto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> update${EntityName}ById(
            @PathVariable("id") Long id,
            @RequestBody ${EntityName}Dto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete${EntityName}ById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
```