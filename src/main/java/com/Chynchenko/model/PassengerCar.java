package com.Chynchenko.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PassengerCar extends Car {
    private int passengerCount;

    public PassengerCar(String manufacturer, Engine engine, Colors color, Types type, int passengerCount){
            super(manufacturer,engine,color,type);
            this.passengerCount = passengerCount;
        }

    public PassengerCar(){

        }

        @Override
        public int restoreCount() {
            return this.passengerCount = 100;
        }

    }
