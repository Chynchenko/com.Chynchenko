package model;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import java.time.LocalDate;
import java.util.*;
import java.sql.Date;

@Getter
@Setter
@ToString
public class Order {
    private List<Car> carOrder;
    private Date created;
    private String orderId;

    @SneakyThrows
    public Order() {
        orderId= UUID.randomUUID().toString();
        created=Date.valueOf(LocalDate.now());
        carOrder=new ArrayList<>();
    }
    public void addCarToOrder(final Order order, final Car car) {
        order.getCarOrder().add(car);
    }
    public void addAllCars(List<Car> cars) {
        carOrder.addAll(cars);

    }
}