package com.Chynchenko.action;

public class ShowAllActions implements Action {
        @Override
        public void execute() {
            CAR_SERVICE.printAll();
        }
    }

