/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carr;

/**
 *
 * @author Dell
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

public class Signup_frame {
    private String gend="";
    private JFrame frame = new JFrame("Car Sales System");
    private ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\Downloads\\logo2.jpg");
    
    private JLabel lbl_name = new JLabel("Name");
    private JLabel lbl_email = new JLabel("E-mail");
    private JLabel lbl_pass = new JLabel("Password");
    private JLabel lbl_gender = new JLabel("Gender");
    private JLabel lbl_age = new JLabel("Age");
    
    private JTextField txt_name = new JTextField();
    private JTextField txt_email = new JTextField();
    private JTextField txt_age = new JTextField();
    private JPasswordField txt_pass = new JPasswordField();
    private ButtonGroup gender = new ButtonGroup();
    private JRadioButton txt_male = new JRadioButton("Male");
    private JRadioButton txt_female = new JRadioButton("Female");
    
    private JButton next = new JButton("Next");
    private JButton back = new JButton("back");
    //Attribute
    
    private boolean check_admin;
    private boolean check_user;
    private boolean valid=false;
    private User default_user= new User();
    private Admin default_admin;
    
      //input
    private void get_information(){
        default_user.setName(txt_name.getText());
        default_user.setEmail(txt_email.getText());
        default_user.setPassword(txt_pass.getText()); 
        default_user.setAge(Integer.parseInt(txt_age.getText()));
        default_user.setGender(gend);
        if(txt_male.isSelected())
            default_user.setGender("Male");
        else if(txt_female.isSelected())
            default_user.setGender("Female");
        
        default_admin=new Admin(default_user.getEmail(),default_user.getPassword());
    }
    private void validation(){
        String regex = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String upperCaseChars = "(.[A-Z].)";
        String lowerCaseChars = "(.[a-z].)";
        String numbers = "(.[0-9].)";
        
        //String specialChars = "(.[@,#,$,%].$)";
        //,*,(,),_,-,+,=,/,\\,|,:,;,>,<,?,!,~,`,{,},[,],\",',.,؟,؛,×,÷,،
        if(txt_name.getText().isEmpty()){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Name is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }  
        else if(txt_email.getText().isEmpty()){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Email is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(txt_pass.getText().isEmpty()){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Password is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(txt_age.getText().isEmpty()){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Age is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if("".equals(gend)){
            valid=false;
            JOptionPane.showMessageDialog(frame, "You must choose a gender", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(!(txt_email.getText().matches(regex))){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Uncorrect \n Must be like Username@gmail.com", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(txt_pass.getText().length()<8||txt_pass.getText().length()>20||!(txt_pass.getText().matches(upperCaseChars ))
                ||!(txt_pass.getText().matches(lowerCaseChars))||!(txt_pass.getText().matches(numbers ))){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Uncorrect \n Must consist of an uppercase , lowercase letter , number and at least 8 characters",
            "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(txt_age.getText().length()>3 ||txt_age.getText().length()<1||!(txt_age.getText().matches(numbers ))){
            valid=false;
            JOptionPane.showMessageDialog(frame, "Uncorrect \n Must enter your age","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else 
            valid=true;
      }
           
    public void sign_frame(ArrayList<User> userlist,Admin admin,ArrayList<Car> cars){
        frame.setSize(700, 400);
        frame.setLayout(null);
        frame.setIconImage(icon.getImage());
        gender.add(txt_male);
        gender.add(txt_female);
        JPanel panelImg;
        panelImg = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image img = new ImageIcon("C:\\Users\\Dell\\Downloads\\car1.jpg").getImage();
                g.drawImage(img, 0, 0, null);
            }
        };
        panelImg.setBounds(0,0 , 700,400);
        
        lbl_name.setBounds(200,15, 200, 100);
        lbl_email.setBounds(200,55, 200, 100);
        lbl_pass.setBounds(200,95, 200, 100);
        lbl_age.setBounds(200,135, 200, 100);
        lbl_gender.setBounds(200,180, 200, 100);
        lbl_name.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_email.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_pass.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_age.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_gender.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_name.setForeground(Color.WHITE);
        lbl_email.setForeground(Color.WHITE);
        lbl_pass.setForeground(Color.WHITE);
        lbl_age.setForeground(Color.WHITE);
        lbl_gender.setForeground(Color.WHITE);
        
        txt_name.setBounds(320, 50, 200, 30);
        txt_email.setBounds(320, 90, 200, 30);
        txt_pass.setBounds(320, 130, 200, 30);
        txt_age.setBounds(320,170,  200, 30);
        txt_male.setBounds(320, 215, 100, 30);
        txt_female.setBounds(320, 247, 150, 30);
        txt_name.setFont(new Font("Verdana", Font.BOLD, 15));
        txt_email.setFont(new Font("Verdana", Font.BOLD, 15));
        txt_pass.setFont(new Font("Verdana", Font.BOLD, 15));
        txt_age.setFont(new Font("Verdana", Font.BOLD, 15));
        txt_male.setFont(new Font("Verdana", Font.BOLD, 20));
        txt_female.setFont(new Font("Verdana", Font.BOLD, 20));
        txt_name.setBackground(Color.GRAY);
        txt_name.setForeground(Color.WHITE);
        txt_email.setBackground(Color.GRAY);
        txt_email.setForeground(Color.WHITE);
        txt_pass.setBackground(Color.GRAY);
        txt_pass.setForeground(Color.WHITE);
        txt_age.setBackground(Color.GRAY);
        txt_age.setForeground(Color.WHITE);
        txt_male.setBackground(Color.BLACK);
        txt_male.setForeground(Color.WHITE);
        txt_female.setBackground(Color.BLACK);
        txt_female.setForeground(Color.WHITE);
        
        next.setBounds(550, 310, 100, 30);
        next.setFont(new Font("Verdana", Font.PLAIN, 20)); 
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        back.setBounds(440, 310, 100, 30);
        back.setFont(new Font("Verdana", Font.PLAIN, 20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        
        frame.add(lbl_name);
        frame.add(lbl_email);
        frame.add(lbl_pass);
        frame.add(lbl_age);
        frame.add(lbl_gender);
        frame.add(txt_name);
        frame.add(txt_email);
        frame.add(txt_pass);
        frame.add(txt_age);
        frame.add(txt_male);
        frame.add(txt_female);
        frame.add(next);
        frame.add(back);     
        
        frame.add(panelImg);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        txt_male.addActionListener((ActionEvent e) -> {
            gend = "Male";
        });
        txt_female.addActionListener((ActionEvent e) -> {
            gend = "Female";
        });
        next.addActionListener((ActionEvent event) -> {
            valid=false;
            validation();
            if(valid==true){
            get_information();
        
            for(int i=0;i<userlist.size();i++){
            check_user=!(default_user.check_user(userlist.get(i)));
            if(check_user==false)
            break;
            }
            check_admin=!(default_admin.check_admin(admin));
            if(check_admin==false||check_user==false)
            {    
            JOptionPane.showMessageDialog(frame, "This account already exists", "Warning", JOptionPane.WARNING_MESSAGE);
            get_information();
            }           
                
            
            if (check_admin==true&&check_user==true){
                frame.setVisible(false);
                userlist.add(default_user);
                new User_frame(cars, default_user).setVisible(true);
            }
               
            }
        });
        back.addActionListener((ActionEvent event) -> {
            frame.setVisible(false);
            new Main_frame(userlist, admin, cars);
        });
        
    }
   
}