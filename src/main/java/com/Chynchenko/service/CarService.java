package com.Chynchenko.service;

import com.Chynchenko.model.Car;
import com.Chynchenko.model.Engine;
import com.Chynchenko.util.RandomGenerator;


import java.util.Random;

public class CarService {

    private CarArrayRepository carArrayRepository;
    public final RandomGenerator randomGenerator = new RandomGenerator();

    private final Random random = new Random();

    private String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};

    public CarService() {
        this.carArrayRepository = carArrayRepository;
    }

    public CarService(CarArrayRepository repository) {
    }

    public int create(final RandomGenerator randomGenerator) {
        if (randomGenerator == null) {
            return -1;
        }

        int count = randomGenerator.generate();
        if (count <= 0 || count > 10) {
            return -1;
        }

        return count;
    }

    public void insert(int index, final Car car) {

        carArrayRepository.insert(index, car);
    }

    private Car.Colors getRandomColor() {
        final Car.Colors[] values = Car.Colors.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public Car create() {
        String manufacturer = manufacturers[random.nextInt(manufacturers.length)];
        Engine engine = new Engine(typesOfEngines[random.nextInt(typesOfEngines.length)]);
        Car car = new Car(manufacturer, engine, getRandomColor()) {
            @Override
            public int restoreCount() {
                return 0;
            }
        };
        carArrayRepository.save(car);
        return car;
    }

    public int createCars() {
        int count = RandomGenerator.generate();
        for (int i = 0; i < count; i++) {
            String manufacturer = RandomGenerator.generateRandomManufacture();
            Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
            Car car = new Car(manufacturer, engine, getRandomColor()) {
                @Override
                public int restoreCount() {
                    return 0;
                }
            };
            System.out.println("It's " + (i + 1) + " car: " + car);
        }
        int number = count == 0 ? -1 : count;
        return number;
    }

    private String createString() {
        StringBuilder sb = new StringBuilder();
        int stringLength = random.nextInt(1, 10);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < stringLength; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public void print(Car car) {

        System.out.println("{manufacturer: " + car.getManufacturer() +
                ", engine: " + car.getEngine() +
                ", color: " + car.getColor() +
                ", count: " + car.getCount() +
                ", price: " + car.getPrice() +
                ", id: " + car.getId() + "}");

    }

    public static void check(Car car) {
        if (car.getCount() > 0 && car.getEngine().getPower() > 200) {
            System.out.println("Car is ready to sell");
        } else if (car.getCount() < 1 && car.getEngine().getPower() <= 200) {
            System.out.println("Car amount is less than 1 and low power");
        } else if (car.getEngine().getPower() <= 200) {
            System.out.println("LOW POWER");
        } else if (car.getCount() < 1) {
            System.out.println("AMOUNT IS LESS THAN 1");
        }

    }

    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(carArrayRepository.toString());
    }


    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Car.Colors color = car.getColor();
        Car.Colors randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
    }
}
