package carr;
import java.util.*;


public class main {
    public static void main(String[] args) {

      ArrayList<Car> cars = new ArrayList<Car>();
      ArrayList<User> users= new ArrayList<User>();
      Admin admin= new Admin("admin@yahoo.com","Java2block@");
      User u = new User("h","h@gmail.com","hadeerAA5","Female",5);
      users.add(u);
        Car c1 = new Car(2001,"BMW","honda",10,"Red");
        Car c2 = new Car(2002,"BMW","honda",10,"Red");
        Car c3 = new Car(2003,"BMW","honda",10,"Red");
        Car c4 = new Car(2004,"BMW","honda",10,"Red");
        
        
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        
     
       new Main_frame(users, admin, cars);
    }  
}