package com.Chynchenko.model;

import java.util.Random;
import java.util.UUID;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
    public abstract class Car implements CountRestore {
    public static Colors Colors;
    private String manufacturer;
    private Engine engine;
    private Colors color;
    private Types type;
    private int count;
    private int price;
    public String id;

    public enum Colors
    {
        RED,
        BLACK,
        BLUE,
        WHITE,
        YELLOW,
        GREEN;
    }

    public enum Types
    {
        CAR,
        TRUCK;
    }

    static Random random = new Random();

    public Car() {
    }

    public Car(String manufacturer, Engine engine, Colors color, Types type) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(2000, 90000);
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",id, color);
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Colors getColor() {
        return color;
    }
    public void setColor(Colors color) {
        this.color = color;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getId() {
        return null;
    }
    public String setId(String id) {
        this.id = id;
        return id;
    }
}


