import com.Chynchenko.repository.CarRepository;
import com.Chynchenko.service.CarService;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        CarService carService = new CarService(new CarRepository());

        Map<String, Object> jsonMap = carService.mapFromFile("Car.json");
        Map<String, Object> xmlMap = carService.mapFromFile("Car.xml");


        System.out.println(carService.mapToObject.apply(jsonMap).toString());
        System.out.println(carService.mapToObject.apply(xmlMap).toString());
    }
}