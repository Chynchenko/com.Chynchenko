package com.Chynchenko.util;

import  com.Chynchenko.model.Car;
import com.Chynchenko.service.CarService;
import com.Chynchenko.repository.CarArrayRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmUtil {

    private static final CarService CAR_SERVICE  = CarService.getInstance();
    private static final CarArrayRepository CAR_ARRAY_REPOSITORY = CarArrayRepository.getInstance();


    public static Car[] bubbleSort1(Car[] cars) {
        for (Car car : cars) {
            CAR_ARRAY_REPOSITORY.save(car);
        }
        String[] ids = Arrays.stream(cars)
                .map(x -> x.getId())
                .toArray(String[]::new);
        int compare;
        for (int i = 0; i < ids.length - 1; i++) {
            for (int j = 0; j < ids.length - i - 1; j++) {
                compare = ids[j].compareTo(ids[j + 1]);
                if (compare > 0) {
                    String forSwap = ids[j + 1];
                    ids[j + 1] = ids[j];
                    ids[j] = forSwap;
                }
            }
        }
        return Arrays.stream(ids)
                .map(x -> CAR_SERVICE.find(x))
                .toArray(Car[]::new);
    }


    public static Car[] bubbleSort2(Car[] cars) {
        Map<String, Car> map = new HashMap<>();
        Car[] sortedCars = new Car[cars.length];
        for (Car car : cars) {
            map.put(String.valueOf(car.getId()), car);
        }
        String[] ids = map.keySet().toArray(new String[0]);
        int compare;
        for (int i = 0; i < ids.length - 1; i++) {
            for (int j = 0; j < ids.length - i - 1; j++) {
                compare = ids[j].compareTo(ids[j + 1]);
                if (compare > 0) {
                    String forSwap = ids[j + 1];
                    ids[j + 1] = ids[j];
                    ids[j] = forSwap;
                }
            }
        }
        for (int i = 0; i < sortedCars.length; i++) {
            sortedCars[i] = map.get(ids[i]);
        }
        return sortedCars;
    }

    public static int binarySearch(Car[] cars, Car car, int firstElement, int lastElement) {
        int mid = firstElement + (lastElement - firstElement)/2;
        int compare = cars[mid].getId().compareTo(car.getId());
        if (compare == 0) {
            return mid;
        } else if (compare < 0) {
            return binarySearch(cars, car, firstElement, mid - 1);
        } else {
            return binarySearch(cars, car, mid + 1, lastElement);
        }
    }
}
