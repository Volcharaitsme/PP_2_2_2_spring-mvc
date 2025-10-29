package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    public CarServiceImpl() {
        this.cars = new ArrayList<>(List.of(new Car("X5", 12345, 2020),
                new Car("S-Class W140", 140001, 1996),
                new Car("Bora", 34567, 2008), new Car("Camry", 45678, 2021),
                new Car("Accord", 56789, 2022)));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return new ArrayList<>(); // возвращаем пустой список для отрицательных значений
        }
        int displayedCars = Math.min(count, cars.size());
        return cars.subList(0, displayedCars);
    }
}