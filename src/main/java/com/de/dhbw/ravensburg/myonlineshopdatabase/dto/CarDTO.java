package com.de.dhbw.ravensburg.myonlineshopdatabase.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {
    private long id;
    private String brand;
    private String model;
    private Integer km;
    private Integer year_of_production;
    private String fuel;
    private Float price;
    private String currency;
    private Integer number_of_owners;
    private String img_src;
    private OwnerDTO owner;

    public CarDTO(String brand, String model, Integer km, Integer year_of_production, String fuel, Float price, String currency, Integer number_of_owners, String img_src, OwnerDTO ownerDTO) {
        this.brand = brand;
        this.model = model;
        this.km = km;
        this.year_of_production = year_of_production;
        this.fuel = fuel;
        this.price = price;
        this.currency = currency;
        this.number_of_owners = number_of_owners;
        this.owner = ownerDTO;
        this.img_src = img_src;
    }
}
