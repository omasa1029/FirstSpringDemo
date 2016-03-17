package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "usermaster")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String name;
}
