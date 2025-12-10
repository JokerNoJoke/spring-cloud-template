package com.sct.demo.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SoftDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@SoftDelete(columnName = "is_deleted")
@DynamicInsert
@DynamicUpdate
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer column1;

    private String column2;

    private Boolean column3;

    private Instant column4;

    private LocalDate column5;

    private LocalTime column6;

}
