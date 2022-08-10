package com.de.dhbw.ravensburg.myonlineshopdatabase.dto;

import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDTO {
    private long id;
    private String name;
    private String address;

    public OwnerDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
