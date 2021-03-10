package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Uasya", "Kek", "hyz@mail.ru");
      User user2 = new User("SSS", "GGG", "asfkj@mailcom");

      Car car = new Car("DMV", 70);
      Car car2 = new Car("AUEDI", 228);

//      car.setUser(user1);
//      car2.setUser(user2);
      user1.setCar(car);
      user2.setCar(car2);

      userService.add(user1);
      userService.add(user2);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }

      context.close();
   }
}
