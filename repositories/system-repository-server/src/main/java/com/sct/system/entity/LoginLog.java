package com.sct.system.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TenantId;

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
@Table(indexes = {
        @Index(columnList = "tenant_id"),
        @Index(columnList = "username")
})
@DynamicInsert
@DynamicUpdate
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", updatable = false)
    @TenantId
    private Long tenantId;

    private String username;

    private String ip;

    private String location;

    private String os;

    private String browser;

    private Integer status;

    private String message;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

}
