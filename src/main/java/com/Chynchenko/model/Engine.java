package com.Chynchenko.model;
import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@Setter
@Getter
public class Engine {
    private int power;
    private EngineTypes type;

    public Engine(String getRandomEngine) {
    }

    public enum EngineTypes {
        GAS,
        DIESEL,
        ELECTRIC
    }

    Random random = new Random();

    public Engine(int power, EngineTypes type) {
        this.power = random.nextInt(1000);
        this.type = getRandomEngine();
    }

    public EngineTypes getRandomEngine() {
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
