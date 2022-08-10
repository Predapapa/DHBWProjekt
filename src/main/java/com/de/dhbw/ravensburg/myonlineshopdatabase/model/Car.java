package com.de.dhbw.ravensburg.myonlineshopdatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private Integer km;
    private Integer year_of_production;
    private String fuel;
    private Float price;
    private String currency;
    private String img_src;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ownerId")
    private Owner owner;
}
