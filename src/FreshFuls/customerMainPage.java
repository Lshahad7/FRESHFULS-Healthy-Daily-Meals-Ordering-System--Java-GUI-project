
package FreshFuls;

import Meal.Menu;
import Orders.Order;
import Orders.OrderQueries;
import Package.orderPackage;
import customerService.CustServiceFrame;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * * @author shahad

 */
public class customerMainPage  extends JFrame {
    private JButton menuBtn;
    private JButton LastOrderBtn;
    private JButton massCalc;
    private JButton custServiceBtn;
    private JButton logOut;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    
    private Order currentEntry;
    private OrderQueries OrderQueries; 
    private FileHistory fileHistory = new FileHistory();
    private int customerID;

    
    public  customerMainPage(Customer customer) {
        customerID=customer.getUserID();
        
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        menuBtn = new JButton();
        LastOrderBtn = new JButton();
        massCalc = new JButton();
        custServiceBtn = new JButton();
        jLabel4 = new JLabel();
        logOut = new JButton("Log out");
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setTitle("Customer Home Page");
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Lucida Console", 1, 30)); 
        jLabel1.setText("WELCOME "+ customer.getFname());
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 200, 350, 49);

        jLabel2.setFont(new Font("Lucida Console", 0, 16)); 
        jLabel2.setText("Dear custumer...choose what do you want to do");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 250, 472, 17);

        menuBtn.setBackground(java.awt.SystemColor.controlHighlight);
        menuBtn.setText("View Menu");
        menuBtn.setMaximumSize(new java.awt.Dimension(90, 29));
        getContentPane().add(menuBtn);
        menuBtn.setBounds(70, 290, 350, 50);
        menuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              String[] buttons = {"Meals Menu","Package Menu"};
         int options = JOptionPane.showOptionDialog(null, "Choose menu:", "Choose menu:",JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
             
         if(options==0){       
                Menu frame = new Menu(customer);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
         }
         else if(options==1){
                  orderPackage frame = new orderPackage(customer);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
           
         }
            }
        });
        
        logOut.setForeground(new Color(255, 51, 51));
        logOut.setBounds(400,60,150,30 );
        add(logOut);
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                main_Interface frame = new main_Interface();
                fileHistory.logOutCust(customerID+"");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
                
            }
        });
                
                
        LastOrderBtn.setBackground(java.awt.SystemColor.controlHighlight);
        LastOrderBtn.setText("Last Order");
        LastOrderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            LastBActionPerformed(evt);

            }
        });
        getContentPane().add(LastOrderBtn);
        LastOrderBtn.setBounds(70, 350, 350, 50);

        massCalc.setBackground(java.awt.SystemColor.controlHighlight);
        massCalc.setText("Body Mass Calculator");
        massCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calculateBodyMass(evt);
            }
        });
        getContentPane().add(massCalc);
        massCalc.setBounds(70, 410, 350, 50);

        custServiceBtn.setBackground(java.awt.SystemColor.controlHighlight);
        custServiceBtn.setText("Customer Service");
        custServiceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              CustServiceFrame page = new CustServiceFrame(customer);
               page.setLocationRelativeTo(null);
              page.setVisible(true);
              setVisible(false);
            }
        });
        
        getContentPane().add(custServiceBtn);
        custServiceBtn.setBounds(70, 470, 350, 50);

        jLabel4.setDisplayedMnemonic('h');
        
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

       jLabel4.setIcon(img3); 

        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 630, 640);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0,0, 630, 640);
        OrderQueries = new OrderQueries();
        
        
    }
    private void LastBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        String LastOrder = "";
      if(evt.getSource() == LastOrderBtn){
        try
        {
           currentEntry = OrderQueries.getLastOrderByCustomerID(customerID);
        if (currentEntry != null )
        {
           String x = currentEntry.getProductsByOrderID(currentEntry.getOrderID());
           LastOrder = "Dear Customer  With ID #" + currentEntry.getCUSTOMERID() + " You have order# " +currentEntry.getOrderID()+ "\n" +x+
                   " and your total = " + currentEntry.getTOTAL() + " using " + currentEntry.getPAYMENTMETHOD() + " as a payment method ";
            JOptionPane.showMessageDialog(this, LastOrder , "Last Order" , JOptionPane.PLAIN_MESSAGE);         
        }
        else 
        {
         LastOrder = "Dear Customer  With ID #" + customerID + " you don't have any order " ;
        JOptionPane.showMessageDialog(this, LastOrder , "Last Order" , JOptionPane.WARNING_MESSAGE );
        }
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),
            "Error", JOptionPane.PLAIN_MESSAGE);
        }
      }  
    }                                     


    private void calculateBodyMass(ActionEvent evt) {
        try{
        String FNumber = JOptionPane.showInputDialog(null,"enter your height(cm)","Body Mass calculator",JOptionPane.QUESTION_MESSAGE);
        String SNumber = JOptionPane.showInputDialog(null,"enter your weight(kg)","Body Mass calculator",JOptionPane.QUESTION_MESSAGE);
        
        if(FNumber !=null && SNumber!=null){
        int num1 = Integer.parseInt(FNumber);
        int num2 = Integer.parseInt(SNumber);
        int mass=(num2*num2)/num1;

        JOptionPane.showMessageDialog(null, "your body mass is \t" + mass,"Body Mass calculator", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        JOptionPane.showMessageDialog(null, "Null value not accepted. Try again", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException x){
        JOptionPane.showMessageDialog(null, "Please enter valid numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


}
