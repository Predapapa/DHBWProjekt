package com.de.dhbw.ravensburg.myonlineshopdatabase.repository;

import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByOwner(Owner owner);
}
