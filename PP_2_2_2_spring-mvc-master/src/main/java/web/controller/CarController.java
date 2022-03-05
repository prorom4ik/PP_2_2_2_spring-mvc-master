package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private static List<Car> cars = new ArrayList<Car>() {{
        add(new Car("S",5,"China"));
        add(new Car("A",4,"Russia"));
        add(new Car("C",2,"Japan"));
        add(new Car("Y",1,"USA"));
        add(new Car("Z",6,"Ukraine"));
    }};

    @GetMapping("/get")
    public String carList(@RequestParam(required = false, name = "count", defaultValue = "5") int count,
                          ModelMap model) {
        model.addAttribute("cars", CarService.getNCars(count));
        return "cars";
    }

    public static List<Car> getCars() {
        return cars;
    }
}
