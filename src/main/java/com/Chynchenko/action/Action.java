package com.Chynchenko.action;

import com.Chynchenko.service.CarService;

public interface Action {

        CarService CAR_SERVICE = CarService.getInstance();
        void execute();
    }

