import com.Chynchenko.container.CarList;
import com.Chynchenko.model.Car;
import com.Chynchenko.repository.CarArrayRepository;
import com.Chynchenko.service.CarService;
import com.Chynchenko.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    private static Car PassengerCar;
    private static Car Truck;
    private static Object service;

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        Car car1 = carService.createCar(RandomGenerator.getRandomType());

        Car car2 = carService.createCar(RandomGenerator.getRandomType());
        Car car3 = carService.createCar(RandomGenerator.getRandomType());
        Car car4 = carService.createCar(RandomGenerator.getRandomType());
        Car car5 = carService.createCar(RandomGenerator.getRandomType());
        Car car6 = carService.createCar(RandomGenerator.getRandomType());

        CarList<Car> list = new CarList<>();
        list.addLast(car3);
        list.addLast(car2);
        list.addLast(car1);
        list.addLast(carService.createCar(Car.Types.CAR));

        System.out.println(list.getSize());
        list.addFirst(carService.createCar(Car.Types.CAR));
        list.addLast(null);
        list.delete(5);
        list.insert(car4,0);

        System.out.println(list.findByValue(car1));

        System.out.println(list.getSize());

        System.out.println();
        for (Car car : list) {
            System.out.println("---");
            System.out.println(car);
            System.out.println(list.totalCount());
        }

        CarList<Car> carList = new CarList<>();
        car1.setManufacturer();
        car2.setManufacturer();
        car3.setManufacturer();
        car4.setManufacturer();
        car5.setManufacturer();
        car6.setManufacturer();

        car1.getEngine().setPower(100);
        car2.getEngine().setPower(300);
        car3.getEngine().setPower(200);
        car4.getEngine().setPower(100);
        car5.getEngine().setPower(300);
        car6.getEngine().setPower(100);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);

        Map<Car, Integer> carCountByManufacturer = service.getCarCountsByManufacturer(carList);
        System.out.println("AUDI: 6 + 7 = " + carCountByManufacturer.getManufacturer());
        for (Object s : Arrays.asList("HONDA: 2 + 1 = " + carCountByManufacturer.getManufacturer(), "BMW: 5 = " + carCountByManufacturer.getManufacturer(), "FORD: 4 = " + carCountByManufacturer.getManufacturer())) {
            System.out.println(s);
        }

        Map<Integer, List<Car>> carCountsByEnginePower = service.compareCar(carList);

        System.out.println("Engine power 100:");
        carCountsByEnginePower.get(100)
                .forEach(System.out::println);

        System.out.println("Engine power 200:");
        carCountsByEnginePower.get(200)
                .forEach(System.out::println);

        System.out.println("Engine power 300:");
        carCountsByEnginePower.get(300)
                .forEach(System.out::println);

    }

}
}