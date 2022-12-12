
import com.Chynchenko.model.Car;
import com.Chynchenko.service.CarService;
import com.Chynchenko.service.CarArrayRepository;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        carService.createPassengerCar();
        carService.createTruck();
        carService.printAll();

        for (Car car : carService.getAll()) {
            car.restoreCount();
        }
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
