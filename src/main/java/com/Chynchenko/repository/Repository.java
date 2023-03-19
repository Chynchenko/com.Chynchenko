package com.Chynchenko.repository;

import com.Chynchenko.model.Car;
import java.util.Optional;

public interface Repository <T> {
    void save(final T car);

    T[] getAll();

    Optional<Car> getById(final String id);

    void delete(final String id);

}