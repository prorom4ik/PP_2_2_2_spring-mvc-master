package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static List<Car> cars = new ArrayList<Car>() {{
        add(new Car("S",5,"China"));
        add(new Car("A",4,"Russia"));
        add(new Car("C",2,"Japan"));
        add(new Car("Y",1,"USA"));
        add(new Car("Z",6,"Ukraine"));
    }};

    public static List<Car> getNCars(int number) {
        return cars.stream().limit(number).toList();
    }
}
