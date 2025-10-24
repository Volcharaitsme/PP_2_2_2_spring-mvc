package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> listCars(Integer n) {
        return carDao.listCars(n);
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
