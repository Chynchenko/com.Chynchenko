package com.Chynchenko.model;

import java.util.Random;

public class Engine {
    private int power;
    private EngineTypes type;
    public enum EngineTypes {
        GAS,
        DIESEL,
        ELECTRIC
    }

    Random random = new Random();

    public Engine(int i, String string) {
        power = random.nextInt(1000);
        type = getRandomType();
    }

    private EngineTypes getRandomType() {
        EngineTypes[] types = EngineTypes.values();
        int index = random.nextInt(types.length);
        return types[index];
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public EngineTypes getType() {
        return type;
    }

    public void setType(EngineTypes type) {
        this.type = type;
    }

}
