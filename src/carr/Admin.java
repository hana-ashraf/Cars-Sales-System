package carr;
import java.util.*;

public class Admin extends Person {

    //Constructor 
    public Admin(String email, String password) {
        super(email, password);
    }
    
    public boolean check_admin(Admin s){
        boolean c;
        c = s.getEmail().equals(getEmail()) &&s.getPassword().equals(getPassword()); 
        return c;
    }

    public void delete(ArrayList<Car> Cars,int carid){   
        Cars.remove(carid);

    }
    public void update( ArrayList<Car> Cars,int carid,float newcost) {      
        Cars.get(carid).setCost(newcost);
    }
}