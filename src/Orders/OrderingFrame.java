/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orders;

/**
 *
 * @author bayanalhumaidan
 */
import FreshFuls.Customer;
import FreshFuls.customerMainPage;
import Meal.Menu;
import Meal.MealLinkedList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Package.Package;
import Package.orderPackage;
import java.util.InputMismatchException;


public class OrderingFrame extends  JFrame {
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MealLinkedList mealsOrdered;
    Customer customer;
      //order meals
    public OrderingFrame(Customer customer, MealLinkedList mealsOrdered) {
            super("Create New Order");
            this.customer = customer;
            this.mealsOrdered=mealsOrdered;

            startFrame();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(0,0, 630,640);
            addWindowListener(
             new WindowAdapter() 
             {  public void windowOpened(WindowEvent evt){  
             JScrollPane scroll = new JScrollPane(ProductTextArea);
            scroll.setBounds(150, 255, 300, 50);                     
            getContentPane().add(scroll);            
           ProductTextArea.setText(mealsOrdered.displayOrder());
           totalTextField.setText(mealsOrdered.calculateTotal()+"");
             }
            });

            OrderB.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OrderMealBActionPerformed(evt);
                }
            });      

            BackB.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BackMealActionPerformed(evt);
                }
            });        
    }
    
    //order package
    public OrderingFrame(Customer customer, Package pkg,  double price) {
            this.pkg=pkg;
            this.customer = customer;
            
            startFrame();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(0,0, 630,640);
             addWindowListener(
             new WindowAdapter() 
             {  
              public void windowOpened(WindowEvent evt){
              add(ProductTextArea);
              ProductTextArea.setText(pkg.getName());
              ProductTextArea.setEditable(false);
              totalTextField.setText(""+price);
            }
            });
               OrderB.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OrderPkgBActionPerformed(evt);
                }
            });      

            BackB.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BackPkgActionPerformed(evt);
                }
            });        


                 }
    
    private void startFrame() {
        
         buttonGroup1 = new ButtonGroup();
        ProductLable = new JLabel();
        PaymentLable = new JLabel();
        ProductTextArea = new JTextArea();
        totalTextField = new JTextField();
        customerIDTextField= new JTextField();
        OrderB = new JButton();
        BackB = new JButton();
        cancelButton = new JButton();
        TotalLable = new JLabel();
        HomeB = new JButton();
        jLabel6 = new JLabel();
        CashRadioButton = new JRadioButton();
        madaRadioButton = new JRadioButton();
        jTextField5 = new JTextField();
        ApplePayRadioButton = new JRadioButton();
        DateTextField = new JTextField();
        DatetLable = new JLabel();
        jLabel1 = new JLabel("");
        jLabel7 = new JLabel();

        
        getContentPane().setLayout(null);
        

        
        ProductLable.setBackground(new java.awt.Color(204, 204, 204));
        ProductLable.setFont(new java.awt.Font("Lao MN", 3, 14)); // NOI18N
        ProductLable.setText("Products ");
        getContentPane().add(ProductLable);
        ProductLable.setBounds(80, 255, 70, 30);


        PaymentLable.setBackground(new java.awt.Color(204, 204, 204));
        PaymentLable.setFont(new java.awt.Font("Lao MN", 3, 14)); // NOI18N
        PaymentLable.setText("Payment Method");
        getContentPane().add(PaymentLable);
        PaymentLable.setBounds(80, 340, 130, 30);

        
        ProductTextArea.setWrapStyleWord(true);
        ProductTextArea.setBounds(150, 255, 300, 50);  
        ProductTextArea.setLineWrap(true);
        ProductTextArea.setEditable(false);
        
        
        
        totalTextField.setEditable(false);
        totalTextField.setBounds(150, 310, 200, 26);
        getContentPane().add(totalTextField);

        OrderB.setText("Order");
      
        getContentPane().add(OrderB);
        OrderB.setBounds(80, 410, 160, 40);

        BackB.setIcon(new ImageIcon(getClass().getResource("Back.jpeg"))); // NOI18N
        BackB.setText("Back ");
        
        getContentPane().add(BackB);
        BackB.setBounds(80, 450, 160, 40);
        
        cancelButton.setIcon(new ImageIcon(getClass().getResource("Cancel.jpeg")));// NOI18N
        cancelButton.setText("Exit");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(260, 410, 170, 40);

        TotalLable.setBackground(new java.awt.Color(204, 204, 204));
        TotalLable.setFont(new java.awt.Font("Lao MN", 3, 14)); // NOI18N
        TotalLable.setText("Total");
        getContentPane().add(TotalLable);
        TotalLable.setBounds(80, 310, 70, 30);

        HomeB.setIcon(new ImageIcon(getClass().getResource("Home.jpeg"))); // NOI18N
        HomeB.setText("Go To Home Page");
        getContentPane().add(HomeB);
        HomeB.setBounds(260, 450, 170, 40);
        HomeB.addActionListener(
       
               new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                setVisible(false);
                customerMainPage page = new customerMainPage(customer);
                page.setLocationRelativeTo(null);
                page.setVisible(true);
            }
        } 
        
        );

        buttonGroup1.add(CashRadioButton);
        CashRadioButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        CashRadioButton.setText("Cash");
        getContentPane().add(CashRadioButton);
        CashRadioButton.setBounds(190, 340, 120, 23);

        buttonGroup1.add(madaRadioButton);
        madaRadioButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        madaRadioButton.setText("Mada");
        
        getContentPane().add(madaRadioButton);
        madaRadioButton.setBounds(310, 340, 120, 23);
      
        getContentPane().add(jTextField5);
        jTextField5.setBounds(150, 310, 200, 26);

        buttonGroup1.add(ApplePayRadioButton);
        ApplePayRadioButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        ApplePayRadioButton.setText("Apple Pay");
        getContentPane().add(ApplePayRadioButton);
        ApplePayRadioButton.setBounds(200, 360, 120, 23);

        DateTextField.setEditable(false);
        getContentPane().add(DateTextField);
        DateTextField.setBounds(150, 220, 200, 26);
        Calendar calendar = Calendar.getInstance();
        DateTextField.setText(formatter.format(calendar.getTime()));
        

        DatetLable.setBackground(new java.awt.Color(204, 204, 204));
        DatetLable.setFont(new java.awt.Font("Lao MN", 3, 14)); // NOI18N
        DatetLable.setText("Date");
        getContentPane().add(DatetLable);
        DatetLable.setBounds(90, 220, 70, 30);
        
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);


        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Lao MN", 3, 14)); // NOI18N
        jLabel7.setText("Total");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 310, 70, 30);
        
        OrderQueries = new OrderQueries();
        pack();
        
         jLabel1.setBounds(0, 0,630,640);
	jLabel1.setIcon(img3);

        getContentPane().add(jLabel1);
    
    }
    

    private void BackPkgActionPerformed(java.awt.event.ActionEvent evt) {                                      
        orderPackage frame = new orderPackage(customer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }                                     
     
        
    private void BackMealActionPerformed(java.awt.event.ActionEvent evt) {                                      
        Menu frame = new Menu(customer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }                                     

    private void OrderPkgBActionPerformed(java.awt.event.ActionEvent evt) {                                       
 try{
       double total = Double.parseDouble(totalTextField.getText().trim());
       Timestamp date = Timestamp.valueOf( DateTextField.getText() ) ;
       String payment=null;
       
       if(CashRadioButton.isSelected())
           payment="Cash";
        else if (madaRadioButton.isSelected())
             payment="Mada";
        else if (ApplePayRadioButton.isSelected())   
        payment="Apple Pay";

       if(payment!=null){
        int results = OrderQueries.addOrderPkg(customer.getUserID(), pkg , total , payment , date );
        
        if (results == 1){
            JOptionPane.showMessageDialog(this, "Order Added Successfully " , "Order Added" , JOptionPane.PLAIN_MESSAGE);
            customerMainPage page = new customerMainPage(customer);
            page.setLocationRelativeTo(null);
            page.setVisible(true);
            setVisible(false);
        }
         else
            JOptionPane.showMessageDialog(this, "Order not Added! " , "Error" , JOptionPane.WARNING_MESSAGE);
       }else
            JOptionPane.showMessageDialog(this, "Please choose payment method! " , "Error" , JOptionPane.WARNING_MESSAGE);
        
        }catch(Exception x){
              JOptionPane.showMessageDialog(this, x.getMessage() , "Error" , JOptionPane.ERROR_MESSAGE);
   
       }
        
    }                                      
    
    
    private void OrderMealBActionPerformed(java.awt.event.ActionEvent evt) {                                       
 try{
       double total = Double.parseDouble(totalTextField.getText().trim());
       Timestamp date = Timestamp.valueOf( DateTextField.getText() ) ;
       String payment=null;
       
       if(CashRadioButton.isSelected())
           payment="Visa";
        else if (madaRadioButton.isSelected())
             payment="Mada";
        else if (ApplePayRadioButton.isSelected())   
        payment="Master card";
       
       if(payment!=null){
        int results = OrderQueries.addOrder(customer.getUserID(), mealsOrdered , payment , date );
        
        if (results == 1){
            JOptionPane.showMessageDialog(this, "Order Added! " , "Order Added" , JOptionPane.PLAIN_MESSAGE);
            customerMainPage page = new customerMainPage(customer);
            page.setLocationRelativeTo(null);
            page.setVisible(true);
            setVisible(false);
        }
         else
            JOptionPane.showMessageDialog(this, "Order not Added! " , "Error" , JOptionPane.WARNING_MESSAGE);
       }else
            JOptionPane.showMessageDialog(this, "Please choose payment method! " , "Error" , JOptionPane.WARNING_MESSAGE);
       
        }catch( InputMismatchException  x){
              JOptionPane.showMessageDialog(this, x.getMessage() , "Please enter valid inputs" , JOptionPane.ERROR_MESSAGE);
   
        }catch( Exception x ){
              JOptionPane.showMessageDialog(this, x.getMessage() , "Error" , JOptionPane.ERROR_MESSAGE);
   
       } 
    }                                      

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                        
    
        System.exit(0);
        
    }                                       

  
    

    private javax.swing.JButton BackB;
    private javax.swing.JTextField DateTextField;
    private javax.swing.JLabel DatetLable;
    private javax.swing.JButton HomeB;
    private javax.swing.JButton OrderB;
    private javax.swing.JLabel PackageLable;
    private javax.swing.JTextField PackageTextField;
    private javax.swing.JLabel PaymentLable;
    private javax.swing.JLabel ProductLable;
    private javax.swing.JTextArea ProductTextArea;
    private javax.swing.JLabel TotalLable;
    private javax.swing.JRadioButton CashRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton madaRadioButton;
    private javax.swing.JRadioButton ApplePayRadioButton;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField totalTextField;
    private List <Order> results;
    private OrderQueries OrderQueries; 
    private JTextField productIDTextField;
    private JTextField customerIDTextField;
    private int customerID;

        Package pkg;


}