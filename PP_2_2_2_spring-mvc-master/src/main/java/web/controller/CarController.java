package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String carList(@RequestParam(required = false, name = "count", defaultValue = "5") int count,
                          ModelMap model) {
        if (count < 1) {
            model.addAttribute("cars", null);
        } else {
            model.addAttribute("cars", carService.getNCars(count));
        }
        return "cars";
    }
}
