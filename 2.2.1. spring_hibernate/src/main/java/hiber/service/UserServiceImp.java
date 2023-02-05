package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUserByCar(String model, int series) {
      try {
         System.out.println("Владелец автомобиля с маркой " + model + " и моделью " + series + ": ");
         return userDao.getUserByCar(model, series);
      } catch (NoResultException e) {
         System.out.println("---- Отсутствует ----");
      } return null;
   }
   @Transactional
   @Override
   public List<Car> listCars(String model) {
      return userDao.listCars(model);
   }
}
