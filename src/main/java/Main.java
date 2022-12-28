
import com.Chynchenko.model.Car;
import com.Chynchenko.repository.CarArrayRepository;
import com.Chynchenko.service.CarService;
import com.Chynchenko.util.RandomGenerator;
import com.Chynchenko.container.CarList;


public class Main {
    private static Car PassengerCar;
    private static Car Truck;

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());

        Car car1 = carService.createCar(RandomGenerator.getRandomType());

        Car car2 = carService.createCar(RandomGenerator.getRandomType());
        Car car3 = carService.createCar(RandomGenerator.getRandomType());
        Car car4 = carService.createCar(RandomGenerator.getRandomType());

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
    }
}