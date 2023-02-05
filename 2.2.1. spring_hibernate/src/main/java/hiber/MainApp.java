package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Toyota", 300)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Mercedes", 900)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Mercedes", 900)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Ivan", "Petrov", "user1@mail.ru");
      Car car1 = new Car("Toyota", 300);
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("Max", "Lindemann", "user2@mail.ru");
      Car car2 = new Car("Mercedes", 900);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Jason", "Madison", "user3@mail.ru");
      Car car3 = new Car("Renault", 200);
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("Jason", "Statham", "user4@mail.ru");
      Car car4 = new Car("Renault", 700);
      user4.setCar(car4);
      userService.add(user4);




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Renault", 200));
      System.out.println(userService.listCars("Renault"));
      context.close();


   }
}
