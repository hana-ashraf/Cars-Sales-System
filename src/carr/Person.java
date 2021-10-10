package carr;

import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Person {
    
    //Attributes 
    private String name,email,password, gender;  
    private int age=0; 
    
    //Constructor
  
      public Person() {
    }

    public Person(String name, String email, String password, String gender, int age) {
        this(email,password);
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }
      
    
    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
     public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //Methods
    
    public void delete(ArrayList <Car> cars,int index){
        
        cars.remove(index);

    }
    
    
    public void ViewSavedCars(ArrayList<Car> cars,JTextArea result){
        result.setText("");
        for (int i = 0 ;i<cars.size();i++)
        {
            i++;
            result.append("Car ID : "+ i +"\n");
            i--;
            result.append("  Model  : "+cars.get(i).getModel_name()+"\n");
            result.append("  Price  : "+cars.get(i).getCost()+"\n");
            result.append("  Color  : "+cars.get(i).getColour()+"\n");
            result.append("  Type   : "+cars.get(i).getManufacturer_type()+"\n");
            result.append("  Made in: "+cars.get(i).getYear_of_manufacturer()+"\n");
            result.append("-------------------------------------------------------"+ "\n");
            
        }
    }

     public void SearchByCost (ArrayList <Car> cars , double cost, JTextArea result){
        boolean found = false;
        result.setText("");
        for (int i = 0; i < cars.size();i++)
        {
            if (cars.get(i).getCost() == cost)
            {
                
             i++;
             result.append("Car ID: "+i+"\n");
             i--;
             result.append(String.valueOf(cars.get(i))+"\n");
             found = true;
            }
            
        }  
        if (found == false ){
            result.setText("No match found");
        }
        
     }
         
    public void Search(ArrayList <Car> cars,String model,JTextArea result ){
        result.setText("");
        boolean found = false;
        
        for (int i = 0; i < cars.size();i++)
        {
            if (cars.get(i).getModel_name().compareTo(model) == 0 )
            {
               i++;
             result.append("Car ID: "+i+"\n");
             i--;
             result.append(String.valueOf(cars.get(i))+"\n");
             found = true;
             
            } 
        }
        if (found == false ){
           result.setText("No match found");
           
        }
       
    }
    
    
     public void Search (ArrayList <Car> cars , int year_of_manufacturer, JTextArea result){
        result.setText("");
       
        boolean found = false;
        for (int i = 0; i < cars.size();i++)
        {
            
            if (cars.get(i).getYear_of_manufacturer() == year_of_manufacturer )
            {
             i++;
             result.append("Car ID: "+i+"\n");
             i--;
             result.append(String.valueOf(cars.get(i))+"\n");
             found = true;
             
             
            }
            
        }
        
        if (found == false ){
           result.setText("No match found");
           
        }
       
    }
}