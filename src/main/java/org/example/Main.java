package org.example;

import model.Car;
import model.CarType;
import model.Order;
import repository.CarJdbcRepository;
import repository.OrderJdbcRepository;
import service.CarService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
            CarService carService = new CarService(new CarJdbcRepository());
            Car car1 = carService.createCar(CarType.TRUCK);
            Car car2 = carService.createCar(CarType.TRUCK);
            Car car3 = carService.createCar(CarType.TRUCK);
            Car car4 = carService.createCar(CarType.CAR);

            Order order = new Order();
            order.addCarToOrder(order,car1);
            order.addCarToOrder(order,car2);
            order.addCarToOrder(order,car3);
            order.addCarToOrder(order,car4);

            OrderJdbcRepository orderList = OrderJdbcRepository.getInstance();
            orderList.save(order);

            System.out.println(Arrays.toString(carService.getAll()));
            String id = carService.getAll()[0].getId();
            System.out.println(carService.find(id) +" FOUND CAR");
            carService.delete(id);
            System.out.println(carService.find(id) + " AFTER DELETE");
            System.out.println(Arrays.toString(orderList.getAll()));
        }
    }