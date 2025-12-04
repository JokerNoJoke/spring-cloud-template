package com.sct.system.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

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
@Table(name = "dict", indexes = {
        @Index(name = "idx_dict_code", columnList = "code"),
        @Index(name = "idx_dict_name", columnList = "name")
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class Dict implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String key;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<Value> values;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

    @UpdateTimestamp
    private Instant updatedTime;

    @Getter
    @Setter
    public static class Value {
        private String key;
        private String value;
    }

}
