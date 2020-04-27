package com.bortnichuk.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private float utilitySum;
    @Column
    private float electricitySum;
    @Column
    private float coldWaterSum;
    @Column
    private float hotWaterSum;

    @Column
    private int month;

    @ManyToOne
    private Flat flat;
}
