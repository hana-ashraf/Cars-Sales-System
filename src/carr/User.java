package carr;

import java.util.*;
import javax.swing.JTextArea;

public class User extends Person {
    
    //Constructor

    public User() {
    }
    
    public User(String name, String email, String password, String gender, int age) {
        super(name, email, password, gender, age);
    }
    
    public User(String email, String password) {
        super(email, password);
    }
    
    public boolean check_user(User s){
        boolean c;
        c = s.getEmail().equals(getEmail()) &&s.getPassword().equals(getPassword()); 
        return c;
    }
    
    public void ViewSavedCars(ArrayList<Car> cars,JTextArea saved_cars){
        saved_cars.setText(String.valueOf(cars));
    }
}