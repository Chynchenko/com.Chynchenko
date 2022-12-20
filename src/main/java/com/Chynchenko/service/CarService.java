package com.Chynchenko.service;

import com.Chynchenko.model.Car;
import com.Chynchenko.model.Engine;
import com.Chynchenko.model.PassengerCar;
import com.Chynchenko.model.Truck;
import com.Chynchenko.util.RandomGenerator;

import java.util.Random;
import java.util.Optional;
import java.util.Arrays;

public class CarService {
    private CarArrayRepository carArrayRepository;
    public final RandomGenerator randomGenerator = new RandomGenerator();

    private final Random random = new Random();

    private static CarService instance;

    private String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};

    public CarService() {
        this.carArrayRepository = carArrayRepository;
    }

    public CarService(CarArrayRepository repository) {
    }

    public static CarService getInstance() {
        instance = Optional
                .ofNullable(instance)
                .orElseGet(() -> new CarService(CarArrayRepository.getInstance()));
        return instance;
    }

    public static CarService getInstance(final CarArrayRepository repository) {
        instance = Optional
                .ofNullable(instance)
                .orElseGet(() -> new CarService(Optional
                        .ofNullable(repository)
                        .orElseGet(() -> CarArrayRepository.getInstance())));
        return instance;
    }

    public void printManufacturerAndCount(Car car) {
        Optional.ofNullable(car)
                .ifPresent(c -> System.out.printf("Manufacturer: %s, count = %d%n", c.getManufacturer(), c.getCount()));
    }

    public void printColor(Car car) {
        Optional.ofNullable(car)
                .map(Car::getColor)
                .ifPresentOrElse(System.out::println, this::getRandomColor);
    }

    public void checkCount(Car car) {
        Car forCheck = Optional.ofNullable(car)
                .filter(car1 -> car1.getCount() > 10)
                .orElseThrow(UserInputException::new);
        printManufacturerAndCount(forCheck);
    }

    public void checkCount(Car[] cars) {
        Arrays.stream(cars).forEach(this::checkCount);
    }

    public void printEngineInfo(Car car) {
        Optional.ofNullable(car)
                .or(() -> {
                    System.out.println("No car, new random car will be created");
                    return Optional.of(create());
                })
                .map(c -> c.getEngine().getPower())
                .ifPresent(power -> System.out.println("Car's engine power = " + power));
    }

    public void printInfo(Car car) {
        Optional.ofNullable(car)
                .map(Car::getId)
                .ifPresentOrElse(this::print, () -> print(create().getId()));
    }


    public Car create() {
        String manufacturer = manufacturers[random.nextInt(manufacturers.length)];
        Engine engine = new Engine(typesOfEngines[random.nextInt(typesOfEngines.length)]);
        Car car = new Car(manufacturer, engine, getRandomColor(), getRandomType()) {
            @Override
            public int restoreCount() {
                return 0;
            }
        };
        carArrayRepository.save(car);
        return car;
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

    public Car createPassengerCar() {
        Car passengerCar = new PassengerCar();
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }

    public Car createTruck() {
        Car truck = new Truck();
        carArrayRepository.save(truck);
        return truck;
    }

    public Car createCar(Car.Types type) {
        if (type.equals(Car.Types.CAR)) {
            createPassengerCar();
            return createPassengerCar();
        } else if (type.equals(Car.Types.TRUCK)) {
            createTruck();
            return createTruck();
        }
        return null;
    }

    public int createCars() {
        int count = RandomGenerator.generate();
        for (int i = 0; i < count; i++) {
            String manufacturer = RandomGenerator.generateRandomManufacture();
            Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
            Car car = new Car(manufacturer, engine, getRandomColor(), getRandomType()) {

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

    public boolean carEquals(Car firstCar, Car secondCar) {
        if (firstCar.getType().equals(secondCar.getType()) && firstCar.hashCode() == secondCar.hashCode()) {
            return firstCar.equals(secondCar);
        } else {
            return false;
        }
    }

    public void insert(int index, final Car car) {

        carArrayRepository.insert(index, car);
    }

    private Car.Colors getRandomColor() {
        final Car.Colors[] values = Car.Colors.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    private Car.Types getRandomType() {
        final Car.Types[] values = Car.Types.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    private String getRandomString() {
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

    public int compareCar(final Car firstCar, final Car secondCar) {
        return firstCar.getId().compareTo(secondCar.getId());
    }

    public void createCar(int i, Car.Types car) {
    }

    public class UserInputException extends RuntimeException {

        public UserInputException() {
            super();
        }
    }

}




