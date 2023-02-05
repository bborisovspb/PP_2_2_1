package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void add(User user);
    User getUserByCar (String model, int series);
    List<Car> listCars(String model);
}
