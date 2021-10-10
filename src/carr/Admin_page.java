package carr;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author DELL
 */
public class Admin_page extends javax.swing.JFrame {


 
    /**
     * Creates new form Admin_page
     */
    private ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\Downloads\\logo2.jpg");
    
    private void add(ArrayList<Car> cars){
        
        if(color_w.isSelected()){
            Car newcar=new Car(Integer.parseInt(txt_manufact.getText()), txt_model.getText(),txt_type.getText(),
                    Double.valueOf(txt_price.getText()),"White");
            cars.add(newcar);
        }
        if(color_p.isSelected()){
            Car newcar=new Car(Integer.parseInt(txt_manufact.getText()), txt_model.getText(),txt_type.getText(),
                    Double.valueOf(txt_price.getText()),"Black");
            cars.add(newcar);
        }
        if(color_g.isSelected()){
            Car newcar=new Car(Integer.parseInt(txt_manufact.getText()), txt_model.getText(),txt_type.getText(),
                    Double.valueOf(txt_price.getText()),"Gray");
            cars.add(newcar);
        }
        if(color_b.isSelected()){
            Car newcar=new Car(Integer.parseInt(txt_manufact.getText()), txt_model.getText(),txt_type.getText(),
                    Double.valueOf(txt_price.getText()),"Blue");
            cars.add(newcar);
        }
        if(color_r.isSelected()){
            Car newcar=new Car(Integer.parseInt(txt_manufact.getText()), txt_model.getText(),txt_type.getText(),
                    Double.valueOf(txt_price.getText()),"Red");
            cars.add(newcar);
        }
    }
    public Admin_page(ArrayList<Car> cars,User user,Admin admin) {
        initComponents();
        this.setTitle("Car Sales System");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
        this.setSize(700,700);
        
        btn_add.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent ae){
            if(txt_manufact.getText().isEmpty()||txt_type.getText().isEmpty()||txt_model.getText().isEmpty()
                    ||txt_price.getText().isEmpty()||(!color_b.isSelected()&&!color_w.isSelected()&&!color_p.isSelected()
                    &&!color_g.isSelected()&&!color_r.isSelected())){
            JOptionPane.showMessageDialog(rootPane,"please Enter all fields","ERORR",JOptionPane.ERROR_MESSAGE);
            }
            else if(Integer.parseInt(txt_manufact.getText())>2021 || Integer.parseInt(txt_manufact.getText())<2000){
            JOptionPane.showMessageDialog(rootPane,"Invalid year","ERORR",JOptionPane.ERROR_MESSAGE);
            }
            else {
                add(cars);

            txt_manufact.setText(" ");
            txt_type.setText(" ");
            txt_model.setText(" ");
            txt_price.setText(" ");
            color_w.setSelected(false);
            color_p.setSelected(false);
            color_g.setSelected(false);
            color_b.setSelected(false);
            color_r.setSelected(false);
        } }
    });
        
        btn_Update.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ae){
                
                int carid= Integer.parseInt(txt_ID.getText());
                if(carid<0||carid>cars.size())
                  JOptionPane.showMessageDialog(rootPane,"Invalid ID","ERORR",JOptionPane.ERROR_MESSAGE);  
                else{
                float newcost= Float.parseFloat(JOptionPane.showInputDialog("Please Enter the new cost"));
                JOptionPane.showMessageDialog(null, "new cost is: "+newcost);
                admin.update(cars, carid-1,newcost);
               
                } txt_ID.setText("");
            }
        });
        btn_view.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                     user.ViewSavedCars(cars, jTextArea1);
                }
        });
        btn_remove.addActionListener(new ActionListener(){
                @Override
            public void actionPerformed(ActionEvent ae){
                int carid= Integer.parseInt(txt_ID.getText());
                if(carid<0||carid>cars.size())
                  JOptionPane.showMessageDialog(rootPane,"Invalid ID","ERORR",JOptionPane.ERROR_MESSAGE);  
                else{
                admin.delete(cars , carid-1);
                JOptionPane.showMessageDialog(null, "car is deleted sucssefully");
                
                }txt_ID.setText("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        tap = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_model = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_manufact = new javax.swing.JTextField();
        txt_type = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_ID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_Update = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btn_view = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        color_b = new JCheckBox("Blue");
        color_r = new JCheckBox("Red");
        color_w = new JCheckBox("White");
        color_g = new JCheckBox("Gray");
        color_p = new JCheckBox("Black");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        setSize(new java.awt.Dimension(700, 700));

        tap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tap.setFont(new Font("Verdana", Font.BOLD, 20)); // NOI18N
        tap.setPreferredSize(new java.awt.Dimension(150, 200));

        jPanel1.setLayout(null);
        
        jLabel4.setFont(new Font("Verdana", Font.BOLD, 25)); // NOI18N
        jLabel4.setForeground(Color.BLACK);
        jLabel4.setText("Model Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(158, 210, 200, 30);
        
        jLabel9.setFont(new Font("Verdana", Font.BOLD, 25));// NOI18N
        jLabel9.setForeground(Color.BLACK);
        jLabel9.setText("Manufacturer Type");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 260, 273, 30);
        
        jLabel2.setFont(new Font("Verdana", Font.BOLD, 25)); // NOI18N
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("Year of manufaturer");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 310, 300, 30);

        jLabel5.setFont(new Font("Verdana", Font.BOLD, 25)); // NOI18N
        jLabel5.setForeground(Color.BLACK);
        jLabel5.setText("Price");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(260, 360, 261, 30);

        jLabel7.setFont(new Font("Verdana", Font.BOLD, 25)); // NOI18N
        jLabel7.setForeground(Color.BLACK);
        jLabel7.setText("Color");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 410, 176, 30);
        
        jPanel1.add(txt_model);
        txt_model.setBounds(390, 210,210, 35);
        txt_model.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        jPanel1.add(txt_type);
        txt_type.setBounds(390, 260,210, 35);
        txt_type.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        jPanel1.add(txt_manufact);
        txt_manufact.setBounds(390, 310,210, 35);
        txt_manufact.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_price);
        txt_price.setBounds(390, 360, 210, 35);
        txt_price.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        color_w.setBounds(390, 410, 100, 35);
        color_w.setFont(new Font("Verdana", Font.PLAIN, 20));
        color_w.setOpaque(false);
        jPanel1.add(color_w);
        color_p.setBounds(490, 410, 100, 35);
        color_p.setFont(new Font("Verdana", Font.PLAIN, 20));
        color_p.setOpaque(false);
        jPanel1.add(color_p);
        color_g.setBounds(390, 440, 100, 35);
        color_g.setFont(new Font("Verdana", Font.PLAIN, 20));
        color_g.setOpaque(false);
        jPanel1.add(color_g);
        color_b.setBounds(490, 440, 100, 35);
        color_b.setFont(new Font("Verdana", Font.PLAIN, 20));
        color_b.setOpaque(false);
        jPanel1.add(color_b);
        color_r.setBounds(390, 470, 100, 35);
        color_r.setFont(new Font("Verdana", Font.PLAIN, 20));
        color_r.setOpaque(false);
        jPanel1.add(color_r);
        
        btn_add.setText("Add");
        btn_add.setFont(new Font("Verdana", Font.PLAIN, 20));
        btn_add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 6, true));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add);
        btn_add.setBounds(500, 500, 140, 42);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\car2.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 600);

        tap.addTab("Add", jPanel1);

        jPanel2.setLayout(null);
        
        txt_ID.setBounds(100, 370,200, 40);
        txt_ID.setFont(new Font("Verdana", Font.PLAIN, 25));
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });
        jPanel2.add(txt_ID);
       

        jLabel6.setText("Enter CAR ID");
        jPanel2.add(jLabel6);
        jLabel6.setFont(new Font("Verdana", Font.BOLD, 35));// NOI18N
        jLabel6.setForeground(Color.BLACK);
        jLabel6.setBounds(80, 330, 273, 30);

        btn_Update.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btn_Update.setText("Update Cost");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Update);
        btn_Update.setBounds(420, 380, 200, 40);

        btn_remove.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_remove);
        btn_remove.setBounds(430, 430, 170, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\car2.jpg")); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 1280, 600);

        tap.addTab("Update and Remove", jPanel2);

        jPanel4.setLayout(null);


        jTextArea1.setOpaque(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jTextArea1.setForeground(Color.black);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(50, 100, 600, 450);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        btn_view.setFont(new java.awt.Font("Tw Cen MT", 1, 35)); // NOI18N
        btn_view.setText("View Cars");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextArea1.setBackground(Color.lightGray);
                jScrollPane1.setOpaque(true);
                jScrollPane1.getViewport().setOpaque(true);
                btn_viewActionPerformed(evt);
            }
        });
        jPanel4.add(btn_view);
        btn_view.setBounds(50, 30, 200, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\car2.jpg")); // NOI18N
        jPanel4.add(jLabel8);
        jLabel8.setBounds(0, 0, 720, 600);

        tap.addTab("view Saved Cars", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tap, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        
    }                                       
    
    private void txt_colourActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txt_purchaseActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           

    }                                          

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        
            
        
    }                                          

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane tap;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_manufact;
    private javax.swing.JTextField txt_model;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_type;
    private javax.swing.JCheckBox color_w;
    private javax.swing.JCheckBox color_p;
    private javax.swing.JCheckBox color_g;
    private javax.swing.JCheckBox color_r;
    private javax.swing.JCheckBox color_b;
    // End of variables declaration                   
}