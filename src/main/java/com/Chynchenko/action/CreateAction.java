package com.Chynchenko.action;

import com.Chynchenko.model.Car;
import com.Chynchenko.util.UserInput;
import lombok.SneakyThrows;

public class CreateAction implements Action {
    private static final int DEFAULT_COUNT = 10;

    @SneakyThrows
    @Override
    public void execute() {
        String[] menu = {"Input your value", "Default value"};
        final int userChoice = UserInput.menu(menu);

        int count;
        if (userChoice == 0) {
            count = UserInput.getInt("Enter your count: ");
            CAR_SERVICE.createCar(count, Car.Types.CAR);
        } else {
            CAR_SERVICE.createCar(DEFAULT_COUNT, Car.Types.CAR);
            count = DEFAULT_COUNT;
        }

        System.out.printf("You have just created %d cars%n", count);
    }
}