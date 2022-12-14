package com.Chynchenko.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Truck extends Car {
    private int loadCapacity;

    public Truck(String manufacturer, Engine engine, Colors color, Types type, int loadCapacity){
        super(manufacturer, engine,color, type);
        this.loadCapacity = loadCapacity;
    }

    public Truck(){ }

    @Override
    public int restoreCount(){
        return this.loadCapacity = 50;
    }

    @Override
    public String toString() {
        return String.format("manufacturer = %s; Engine = %s; Color = %s; LoadCapacity = %d; ID = %s; typeOfCar = %s)",
                getManufacturer(), getEngine(), getColor(), getLoadCapacity(), getId(), getType());
    }
}
