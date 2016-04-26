package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "usermaster")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
}
