package com.bortnichuk.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private House house;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flat")
    private List<Resident> residentList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flat")
    private List<Account> accounts;

    @Column(name = "rent_payment")
    private float rentPayment;
}
