package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String Cars(
            @RequestParam(value = "count", required = false, defaultValue = "5") int count,
            ModelMap modelMap) {
        List<Car> cars = carService.getCars(count);
        modelMap.addAttribute("cars", cars);
        modelMap.addAttribute("countCars", cars.size());
        modelMap.addAttribute("requestedCount", count);
        return "cars";
    }
}