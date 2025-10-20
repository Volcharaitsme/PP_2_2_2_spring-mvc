package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;
    private int CARS_COUNT;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "Toyota", "Silver"));
        cars.add(new Car(++CARS_COUNT, "Volkswagen", "White"));
        cars.add(new Car(++CARS_COUNT, "Ford", "Blue"));
        cars.add(new Car(++CARS_COUNT, "Kia", "White"));
        cars.add(new Car(++CARS_COUNT, "Renault", "Red"));
    }

    @Override
    public List<Car> listCars(Integer n) {
        return null == n ? cars
                : cars.subList(0, n < cars.size() ? n : cars.size());
    }
}