package com.sct.system.entity;

import java.io.Serializable;
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
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "param", indexes = {
        @Index(name = "idx_param_code", columnList = "code"),
        @Index(name = "idx_param_name", columnList = "name")
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class Param implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String key;

    private String value;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

    @UpdateTimestamp
    private Instant updatedTime;

}
