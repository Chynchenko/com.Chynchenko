package com.Chynchenko.repository;
import com.Chynchenko.model.Car;

import java.util.Objects;
import java.util.Optional;

public class CarArrayRepository implements Repository<Car> {
    public static Car[] cars = new Car[10];
    private static CarArrayRepository instance;
    private String id;
    private Car.Colors color;

    public CarArrayRepository() {
    }

    public static CarArrayRepository getInstance() {
        instance = Optional.ofNullable(instance).orElseGet(() -> new CarArrayRepository());
        return instance;
    }

    public void save( Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }

    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    public Car getById(final String id) {
        for (Car car : cars) {
            if (Objects.equals(car.getId(), id)) {
                return car;
            }
        }
        return null;
    }

    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (Objects.equals(cars[index].getId(), id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index,
                    cars.length - (index + 1));
        }
    }

    public void insert(int index, final Car car) {
        if (cars[cars.length - 1] != null) {
            increaseArray();
        }
        final int newLength = foundLength();
        if (index > newLength) {
            putCar(car);
        }
        else {
            System.arraycopy(cars, index, cars, index+1,
                    cars.length - (index + 1));
            cars[index]=car;
        }

    }
    public void updateColor(final String id, Car.Colors color) {
        this.id = id;
        this.color = color;
        final Car car = getById(id);
        if (car != null) {
            car.setColor(Car.Colors);
        }
    }

    private int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    private int putCar(final Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }
}

