package com.Chynchenko.util;

import com.Chynchenko.model.Car;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int generate() {

        return random.nextInt(10);
    }

    private static String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private static String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};

    public static Car.Types getRandomType() {
        return Car.Types.values() [random.nextInt(Car.Types.values().length)];
    }

    public int generateRandomNumber() {
        return random.nextInt(0, 11);
    }

    public static String generateRandomManufacture() {
        return manufacturers[random.nextInt(manufacturers.length)];
    }

    public static String generateRandomTypeOfEngine() {
        return typesOfEngines[random.nextInt(typesOfEngines.length)];
    }

}
