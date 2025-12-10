package com.sct.system.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.TenantId;
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
        @Index(columnList = "tenant_id, code", unique = true)
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class SystemConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", updatable = false)
    @TenantId
    private Long tenantId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Tenant tenant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String value;

    /**
     * Is built-in parameter (cannot be deleted)
     */
    private Boolean builtIn;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

    @Column(updatable = false)
    @CreatedBy
    private Long createdBy;

    @UpdateTimestamp
    private Instant updatedTime;

    @LastModifiedBy
    private Long updatedBy;

}
