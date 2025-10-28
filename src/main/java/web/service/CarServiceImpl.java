package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
        int displayedCars = Math.min(count, cars.size());
        return cars.subList(0, displayedCars);
    }
    @Override
    public List<Car> getCars(int count) {
        // Валидация отрицательного значения
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative: " + count);
        }
        
        // Если запрошено больше машин, чем есть в списке, возвращаем все
        if (count >= carList.size()) {
            return new ArrayList<>(carList);
        }
        
        // Возвращаем указанное количество машин
        return carList.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
