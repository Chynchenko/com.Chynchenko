import com.Chynchenko.model.CarType;
import com.Chynchenko.repository.CarMapRepository;
import com.Chynchenko.service.CarService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        CarService carService = new CarService(new CarMapRepository());

        Map<String, Object> jsonMap = carService.mapFromFile("Car.json");
        Map<String, Object> xmlMap = carService.mapFromFile("Car.xml");

        System.out.println(carService.mapToObject.apply(jsonMap).toString());
        System.out.println(carService.mapToObject.apply(xmlMap).toString());

        carService.createCar(CarType.CAR,3);
        System.out.println(Arrays.toString(carService.getAll()));
    }
}