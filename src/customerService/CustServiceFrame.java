/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerService;
import FreshFuls.Customer;
import FreshFuls.customerMainPage;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
/**
 *
 * @author hindalzahrani
 */
public class CustServiceFrame extends JFrame  {
    
    //we can NOT display the TimeStamp as it is so we convert it to date and display is as a formatter
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final JButton backButton;
    private final ButtonGroup buttonGroup1;
    private final JTextField dateTF;
    private final JButton jButton1;
    private final JButton jButton2;
    private final JButton jButton3;
    private final JButton jButton4;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel7;
    private final JTextField jTextField1;
    private final JTextField orderTF;
    private final JButton otherButton;
    
    private final CustServiceQueries customerQuery = new CustServiceQueries();
    
    private final String button1;
    private final String button2;
    private final String button3;
    private final String button4;
    private final String button5;
    private final String backbutton;
    
    int custID;
    
    public CustServiceFrame(Customer customer) {
        custID=customer.getUserID();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orderTF = new javax.swing.JTextField();
        dateTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        otherButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0,0, 630, 640);

        
        jTextField1.setText("jTextField1");
        setLayout(null);
        
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("Customer Service");
        add(jLabel1);
        jLabel1.setBounds(200, 80, 323, 43);
        
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("customerService.jpeg"));
	Image img4 = imageIcon2.getImage();
	Image img5 = img4.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
	ImageIcon img6 = new ImageIcon(img5);
        jLabel3.setIcon(img6);
        add(jLabel3);
        jLabel3.setBounds(500, 20, 130, 130);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Date:");
        add(jLabel2);
        jLabel2.setBounds(270, 160, 78, 22);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 0));
        jLabel4.setText("Order#: ");
        add(jLabel4);
        jLabel4.setBounds(250, 190, 80, 22);

        orderTF.setBackground(new java.awt.Color(240, 240, 240));
        add(orderTF);
        orderTF.setBounds(330, 190, 220, 26);

        orderTF.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = orderTF.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        orderTF.setText("");
                        JOptionPane.showMessageDialog(null, "Order ID must be number!");
                    }
                    catch(Exception ex){
                        orderTF.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in ID Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        
        dateTF.setBackground(new java.awt.Color(240, 240, 240));
        add(dateTF);
        dateTF.setBounds(330, 160, 220, 26);
        //to set date and time of TODAY
        Calendar calendar = Calendar.getInstance();
        dateTF.setText(formatter.format(calendar.getTime()));
        dateTF.setEditable(false);
        
        button1="Subpar food and drink quality";
        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setText(button1);
        add(jButton1);
        jButton1.setBounds(140, 240, 270, 50);
        
        button2="Long wait time";
        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText(button2);
        add(jButton2);
        jButton2.setBounds(140, 300, 270, 50);

        button3="Delivery related issues";
        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText(button3);
        add(jButton3);
        jButton3.setBounds(140, 360, 270, 50);

        button4="Website not working properly";
        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setText(button4);
        add(jButton4);
        jButton4.setBounds(140, 420, 270, 50);
        
        button5="Other";
        otherButton.setBackground(new java.awt.Color(204, 204, 204));
        otherButton.setText(button5);
        add(otherButton);
        otherButton.setBounds(140, 480, 270, 50);
        
        backbutton="Back";
        backButton.setText(backbutton);
        add(backButton);
        backButton.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               customerMainPage page = new customerMainPage(customer);
               page.setLocationRelativeTo(null);
              page.setVisible(true);
              setVisible(false);
            }
        }
        );
        
        backButton.setBounds(60, 530, 97, 29);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
        jLabel7.setIcon(img3);
        add(jLabel7);
        jLabel7.setBounds(0, 0, 630, 640);
        
        Handler h = new Handler();
        jButton1.addActionListener(h);
        jButton2.addActionListener(h);
        jButton3.addActionListener(h);
        jButton4.addActionListener(h);
        otherButton.addActionListener(h);
    }//end of constructor                       
    
    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String s="";
            if (event.getSource()== jButton1)
                s=button1;
            else
            if (event.getSource()== jButton2)
                s=button2; 
            else
            if (event.getSource()== jButton3)
                s=button3;
            else
            if (event.getSource()== jButton4)
                s=button4;
            else
            if(event.getSource()==otherButton){
                s = JOptionPane.showInputDialog(null, "Tell us about the problem...", "Customer Service", JOptionPane.INFORMATION_MESSAGE);
                
            }
            insertCust(s);
        }
    }
    
    public void insertCust(String complaint){
        try{
            int orderID = Integer.parseInt(orderTF.getText().trim());        
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to send \n"+complaint + "?", "Confirm Message",JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (confirm == 0){
            Timestamp date = Timestamp.valueOf( dateTF.getText() ) ;
            
            if (customerQuery.duplicate(custID, orderID)){
                
                int result = customerQuery.CustomerService(custID, orderID, date, complaint);
            
            if (result == 1)
                JOptionPane.showMessageDialog(this, "Request sent successfully!",
                "Request sent", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Request not sent!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "You alrealdy has sent a compliment for this order", "Error", JOptionPane.ERROR_MESSAGE);

            }
            }
            catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error!\nTry again with proper order number","Error", JOptionPane.ERROR_MESSAGE);
        }            catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }       
    }
}