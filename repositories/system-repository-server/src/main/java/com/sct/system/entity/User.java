package com.sct.system.entity;

import java.time.Instant;
import java.util.List;

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
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`user`", indexes = {
        @Index(columnList = "tenant_id, username", unique = true),
        @Index(columnList = "mobile")
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", updatable = false)
    @TenantId
    private Long tenantId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Tenant tenant;

    @Column(name = "dept_id", updatable = false)
    private Long deptId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Dept dept;

    @Column(nullable = false)
    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String avatar;

    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_user_id")), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_role_id")))
    private List<Role> roles;

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
