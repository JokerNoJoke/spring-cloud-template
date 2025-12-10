package com.sct.system.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TenantId;
import org.springframework.data.annotation.CreatedBy;

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
        @Index(columnList = "tenant_id"),
        @Index(columnList = "uri")
})
@DynamicInsert
@DynamicUpdate
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", updatable = false)
    @TenantId
    private Long tenantId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Tenant tenant;

    private String ip;

    private String location;

    private String method;

    private String uri;

    private String os;

    private String browser;

    @Column(columnDefinition = "TEXT")
    private String request;

    @Column(columnDefinition = "TEXT")
    private String response;

    private Long time;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdTime;

    @CreatedBy
    private Long createdBy;

}
