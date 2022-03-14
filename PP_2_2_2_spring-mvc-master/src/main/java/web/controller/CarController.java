package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/get")
    public String carList(@RequestParam(required = false, name = "count", defaultValue = "5") int count,
                          ModelMap model) {
        model.addAttribute("cars", CarService.getNCars(count));
        return "cars";
    }
}
