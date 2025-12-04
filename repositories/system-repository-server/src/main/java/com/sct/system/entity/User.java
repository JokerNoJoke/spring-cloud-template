package com.sct.system.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`user`", indexes = {
                @Index(name = "idx_user_username", columnList = "username"),
                @Index(name = "idx_user_mobile", columnList = "mobile")
})
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String password;

        private String nickname;

        private String mobile;

        @Column(updatable = false)
        @CreationTimestamp
        private Instant createdTime;

        @UpdateTimestamp
        private Instant updatedTime;

        @ManyToOne
        @JoinColumn(name = "org_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_org_id"))
        private Org org;

        @ManyToMany
        @JoinTable(name = "user_role", joinColumns = {
                        @JoinColumn(name = "user_id", referencedColumnName = "id")
        }, inverseJoinColumns = {
                        @JoinColumn(name = "role_id", referencedColumnName = "id")
        }, foreignKey = @ForeignKey(name = "fk_user_role_user_id"), inverseForeignKey = @ForeignKey(name = "fk_user_role_role_id"))
        private List<Role> roles;

}
