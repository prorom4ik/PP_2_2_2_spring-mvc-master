package web.service;

import web.controller.CarController;
import web.model.Car;

import java.util.List;

public class CarService {
    public static List<Car> getNCars(int number) {
        return CarController.getCars().stream().limit(number).toList();
    }
}
