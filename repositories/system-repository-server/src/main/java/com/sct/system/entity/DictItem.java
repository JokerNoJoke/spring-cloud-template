package com.sct.system.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(columnList = "dict_type_id, value", unique = true)
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class DictItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dict_type_id", updatable = false)
    private Long dictTypeId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private DictType dictType;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String value;

    private Integer sortOrder;

    private Boolean enabled;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(updatable = false)
    @CreatedBy
    private Long createdBy;

    @UpdateTimestamp
    private Instant updatedAt;

    @LastModifiedBy
    private Long updatedBy;

}
