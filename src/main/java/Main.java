
import com.Chynchenko.model.Car;
import com.Chynchenko.model.PassengerCar;
import com.Chynchenko.model.Truck;
import com.Chynchenko.service.CarService;
import com.Chynchenko.service.CarArrayRepository;

public class Main {
    private static Car PassengerCar;
    private static Car Truck;

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        Car count = carService.create();
        System.out.println(count);

        System.out.println();
        for (Car car : carService.getAll()) {
            car.restoreCount();
        }

        carService.printManufacturerAndCount(null);
        carService.printColor(null);
        carService.printEngineInfo(null);
        carService.printInfo(null);

        boolean result = carService.carEquals(PassengerCar, Truck);
        System.out.println(result);

        carService.printAll();
    }

       /* int i, y;
        for (i = 0, y = 5; i <= 10; i++, y += 2) {
            System.out.println("Step" + " " + i + "," + "meaning" + " " + y);
        }
        for (i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 6) {
                break;
            }
            System.out.println("Step" + " " + i);
        }

        CarService carService = new CarService();
        Car car1 = carService.create();
        carService.check(car1);
        carService.print(car1);
        Car car2 = carService.create();
        carService.check(car2);
        carService.print(car2);
        Car car3 = carService.create();
        carService.check(car3);
        carService.print(car3);

        final Car car4 = carService.create();
        final Car car5 = carService.create();
        final Car car6 = carService.create();

        carService.create();
        carService.printAll();
        carService.create();
        carService.printAll();

        */

    }
