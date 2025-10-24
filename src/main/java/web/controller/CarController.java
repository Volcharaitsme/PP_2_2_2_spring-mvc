package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showAllCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/{count}")
    public String showCars(@PathVariable("count") int count, Model model) {
        // Валидация отрицательного значения count
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative: " + count);
        }
        
        List<Car> cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
    
    // Дополнительный метод для редиректа с корневого пути
    @GetMapping("/")
    public String redirectToCars() {
        return "redirect:/cars";
    }
}
