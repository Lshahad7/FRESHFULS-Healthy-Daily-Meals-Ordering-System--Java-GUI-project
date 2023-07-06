/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreshFuls;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.sql.*;
import javax.swing.*;

public class LogInCustomer extends JFrame {

        public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              				try {
					LogInCustomer frame = new LogInCustomer();
					frame.setVisible(true);
                                        frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
 
            }
        });
    }

    public LogInCustomer() {
        	setBounds(0, 0, 630,640);
        contentPanel = new JPanel();
        IDTextField = new JTextField();
        jPasswordLogIn = new JPasswordField();
        jButtonLogIn = new JButton();
        jLabelUserName = new JLabel();
        jLabelPassword = new JLabel();
        jLabelUseIcon = new JLabel();
        jLabelBackground = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        contentPanel.setLayout(null);

        IDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDTextField.setToolTipText("Enter ID number");
        
        IDTextField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = IDTextField.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        IDTextField.setText("");
                        JOptionPane.showMessageDialog(null, "ID must be number!");
                    }
                    catch(Exception ex){
                        IDTextField.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in ID Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        contentPanel.add(IDTextField);
        IDTextField.setBounds(210, 330, 200, 30);

        jPasswordLogIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordLogIn.setToolTipText("Enter Password");
        contentPanel.add(jPasswordLogIn);
        jPasswordLogIn.setBounds(210, 390, 200, 30);

        jButtonLogIn.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogIn.setForeground(new java.awt.Color(135, 136, 107));
        jButtonLogIn.setText("Log In");
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            logInAction(evt);            }
        });
        contentPanel.add(jButtonLogIn);
        jButtonLogIn.setBounds(240, 440, 140, 30);

        jLabelUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUserName.setForeground(new java.awt.Color(135, 136, 107));
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelUserName.setText("Customer ID: ");
        jLabelUserName.setToolTipText("");
        contentPanel.add(jLabelUserName);
        jLabelUserName.setBounds(210, 310, 150, 20);

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(135, 136, 107));
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPassword.setText("Password: ");
        contentPanel.add(jLabelPassword);
        jLabelPassword.setBounds(210, 370, 90, 20);
        signUPLabel = new JLabel();
        
        
        signUPLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUPLabel.setForeground(new java.awt.Color(135, 136, 107));
        signUPLabel.setHorizontalAlignment(SwingConstants.LEFT);
        signUPLabel.setText("If you don't have account, CLICK HERE!");
        contentPanel.add(signUPLabel);
        signUPLabel.setBounds(91, 510, 385, 30);

        signUPLabel.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
             signUp s = new signUp();
             s.setLocationRelativeTo(null);
             s.setVisible(true);
            setVisible(false);
        }  
        }); 
        cancelButton = new JButton();
        cancelButton.setText("Back");
        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(135, 136, 107));
        
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_Interface frame = new main_Interface();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        add(cancelButton);
        cancelButton.setBounds(180, 540, 86, 29);

        
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("userIcon.jpeg"));
	Image img1 = imageIcon2.getImage();
	Image img21 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon img31 = new ImageIcon(img21);
        
        jLabelUseIcon.setText("");
        contentPanel.add(jLabelUseIcon);
        jLabelUseIcon.setBounds(270, 200, 100, 100);
        jLabelUseIcon.setIcon(img31);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

        jLabelBackground.setIcon(img3); 
        contentPanel.add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 630, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }

    private void logInAction(ActionEvent evt) {

        try{
            int custID = Integer.parseInt(IDTextField.getText());
        
        String pass = String.valueOf(jPasswordLogIn.getPassword());

           Customer newCust = checkCustomer(custID,pass);
            if(newCust!=null){
                JOptionPane.showMessageDialog(null, "Welcome " +newCust.getFname()+" "+newCust.getLname()+"! \n You have logged in successfully");
                fileHistory.logInCust(IDTextField.getText());
                customerMainPage page = new customerMainPage(newCust);
                page.setLocationRelativeTo(null);
                 page.setVisible(true);
                 setVisible(false);

                       }
            else{
                 JOptionPane.showMessageDialog(null, "Incorrect ID number or password!", "Insuccessful login", JOptionPane.WARNING_MESSAGE);
            }

        }catch(java.lang.NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter number value", "ERROR",JOptionPane.ERROR_MESSAGE );           
        }
                catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );           
        }

            
        }

    public Customer checkCustomer(int custID, String password){
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM CUSTOMER WHERE customerID =? AND password =?";
            try{
            MyConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant", "APP", "deitel");
            ps= MyConnection.prepareStatement(query);
                
            ps.setInt(1, custID);
            ps.setString(2, password);
            String name;
            rs = ps.executeQuery();
            if(rs.next()){
                rs.getString("lname");
                
             Customer newCust = new Customer(rs.getString("Address"), custID, password,rs.getString("fname"),rs.getString("lname"), rs.getDate("Birthdate"));

                return newCust;
            }
            
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
           return null;
        }



    private JButton jButtonLogIn;
    private JButton cancelButton;
    private JLabel jLabelBackground;
    private JLabel jLabelPassword;
    private JLabel signUPLabel;
    private javax.swing.JLabel jLabelUseIcon;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPasswordField jPasswordLogIn;
    private javax.swing.JTextField IDTextField;
    Connection MyConnection;
    FileWriter fileWriter;
    private FileHistory fileHistory = new FileHistory();
}
