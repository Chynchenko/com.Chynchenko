import com.Chynchenko.container.CarTree;
import com.Chynchenko.model.Car;
import com.Chynchenko.model.Color;
import com.Chynchenko.model.Engine;
import com.Chynchenko.model.Type;
import com.Chynchenko.repository.CarRepository;
import com.Chynchenko.service.CarService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CarTree<Car> carTree = new CarTree<Car>();
        CarService carService = new CarService(new CarRepository());
        carService.createCar(Type.CAR, 3);
        Car[] allCars = carService.getAll();
        allCars[0] = carService.createCustomCar(Type.CAR, "TEST", new Engine(100, "TYPE"), Color.GREEN, "20");
        allCars[1] = carService.createCustomCar(Type.CAR, "TEST2", new Engine(100, "TYPE"), Color.GREEN, "20");
        allCars[2] = carService.createCustomCar(Type.CAR, "TEST3", new Engine(100, "TYPE"), Color.GREEN, "20");
        System.out.println(Arrays.toString(allCars));
        allCars[0].setCount(12);
        carTree.insert(allCars[0]);
        carTree.insert(allCars[1]);
        carTree.preorder();
        carTree.postorder();
        System.out.println(carTree.summaryCount());
    }
}