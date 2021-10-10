package carr;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main_frame extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel image;
    private JButton button1;
    private JButton button2;
    private JTextField textField;
    private JPasswordField passwordField;
    private ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\Downloads\\logo2.jpg");
    private boolean check_admin;
    private boolean check_user;

    private User default_user = new User();
    private Admin default_admin;


    public Main_frame(ArrayList<User> userlist, Admin admin,ArrayList<Car> cars) {
        this.setTitle("Car Sales System");
        this.setResizable(false);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
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

        button1 = new JButton("login");
        button2 = new JButton("sign up");
        label1 = new JLabel("car sales system");
        label2 = new JLabel("Email");
        label3 = new JLabel("Password");
        textField = new JTextField(20);
        passwordField = new JPasswordField(20);
        image= new JLabel("",icon,JLabel.CENTER);
        image.setBounds(0,0,700,400);


        this.setLayout(null);
        this.add(label2);
        this.add(textField);
        this.add(label1);
        this.add(label3);
        this.add(passwordField);
        this.add(button1);
        this.add(button2);
        this.add(panelImg);
        this.add(image);
        this.setVisible(true);

        label1.setBounds(130, 10, 500, 60);
        label1.setFont(new Font("Verdana", Font.BOLD, 50));
        label1.setForeground(Color.WHITE);

        label2.setBounds(230, 115, 250, 30);
        label2.setFont(new Font("Verdana", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);

        label3.setBounds(230, 155, 250, 30);
        label3.setFont(new Font("Verdana", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);

        textField.setBounds(360, 120, 200, 30);
        textField.setFont(new Font("Verdana", Font.BOLD, 15));
        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.WHITE);

        passwordField.setBounds(360, 160, 200, 30);
        passwordField.setFont(new Font("Verdana", Font.BOLD, 15));
        passwordField.setBackground(Color.GRAY);
        passwordField.setForeground(Color.WHITE);

        button1.setBounds(410, 210, 100, 30);
        button1.setFont(new Font("Verdana", Font.PLAIN, 20));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        button2.setBounds(405, 250, 110, 30);
        button2.setFont(new Font("Verdana", Font.PLAIN, 20));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);

        button2.addActionListener((ActionEvent event) -> {
            setVisible(false);
            new Signup_frame().sign_frame(userlist, admin, cars);
        });
        button1.addActionListener((ActionEvent event) -> {
            default_user.setEmail(textField.getText());        //input email
            default_user.setPassword(passwordField.getText());     //input password

            default_admin = new Admin(default_user.getEmail(), default_user.getPassword());
            for (int i = 0; i < userlist.size(); i++) {
                check_user = default_user.check_user(userlist.get(i));
                if (check_user == true)
                    break;
            }
            check_admin = default_admin.check_admin(admin);
            if (check_admin == false && check_user == false) {
                JOptionPane.showMessageDialog(this, "invalid email or password",
                        "warning", JOptionPane.WARNING_MESSAGE);
            }
            if (check_user == true){
                setVisible(false);
                new User_frame(cars, default_user).setVisible(true);
            }
            if (check_admin == true){
                setVisible(false);
                new Admin_page(cars, default_user, admin).setVisible(true);
            }
           
        });
    }

}