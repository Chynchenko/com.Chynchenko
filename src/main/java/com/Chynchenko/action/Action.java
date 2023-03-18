package com.Chynchenko.action;

import com.Chynchenko.repository.CarRepository;
import com.Chynchenko.service.CarService;

public interface Action {

        CarRepository CAR_SERVICE = CarService.getInstance();
        void execute();
    }

