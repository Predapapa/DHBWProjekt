package com.de.dhbw.ravensburg.myonlineshopdatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> cars;

}
