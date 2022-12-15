package com.Chynchenko.action;
import com.Chynchenko.service.CarService;
import java.io.IOException;

public interface Action {

        CarService CAR_SERVICE = CarService.getInstance();
        void execute();
    }

