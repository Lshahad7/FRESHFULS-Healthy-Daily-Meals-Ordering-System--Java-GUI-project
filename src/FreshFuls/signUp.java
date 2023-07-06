/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreshFuls;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.sql.*;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
public class signUp extends JFrame {
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              				try {
					signUp frame = new signUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
 
            }
        });
    }

 
    public signUp() {
        setLocationRelativeTo(null);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        birtdatePicker = new JXDatePicker();
 
        cancelButton = new JButton();
        RegisterButton = new JButton();
        FnameTF = new JTextField();
        LnameTF = new JTextField();
        IDField = new JTextField();
        passField = new JPasswordField();
        jScrollPane1 = new JScrollPane();
        addressTA = new JTextArea();
        jLabel8 = new JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(113, 113, 25));
        jLabel1.setText("Please fill the required information to register:");
        add(jLabel1);
        jLabel1.setBounds(220, 100, 350, 60);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("First Name");
        add(jLabel2);
        jLabel2.setBounds(120, 230, 90, 20);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Last Name");
        add(jLabel3);
        jLabel3.setBounds(120, 270, 90, 20);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID number:");
        add(jLabel4);
        jLabel4.setBounds(120, 310, 90, 20);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Password");
        add(jLabel5);
        jLabel5.setBounds(120, 350, 90, 20);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); 
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Address");
        add(jLabel6);
        jLabel6.setBounds(120, 430, 80, 20);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Birth date");
        add(jLabel7);
        jLabel7.setBounds(120, 390, 90, 20);

        cancelButton.setText("Back");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_Interface frame = new main_Interface();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        add(cancelButton);
        cancelButton.setBounds(180, 540, 86, 29);

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(RegisterButton);
        RegisterButton.setBounds(300, 540, 95, 29);

        birtdatePicker.setBounds(210, 390, 230, 26);
        add(birtdatePicker);
        
        FnameTF.setBackground(new java.awt.Color(227, 225, 225));

        add(FnameTF);
        FnameTF.setBounds(210, 230, 230, 26);

        LnameTF.setBackground(new java.awt.Color(227, 225, 225));
        add(LnameTF);
        LnameTF.setBounds(210, 270, 230, 26);

        IDField.setBackground(new java.awt.Color(227, 225, 225));

        add(IDField);
        IDField.setBounds(210, 310, 230, 26);
        IDField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = IDField.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        IDField.setText("");
                        JOptionPane.showMessageDialog(null, "ID must be number!");
                    }
                    catch(Exception ex){
                        IDField.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in ID Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        
        passField.setBackground(new java.awt.Color(227, 225, 225));
        passField.setToolTipText("Password must include at least 8 charachters \n and must have at least one small and capital letters and number value.");
        add(passField);
        passField.setBounds(210, 350, 230, 26);

        addressTA.setBackground(new java.awt.Color(204, 204, 204));
        addressTA.setColumns(20);
        addressTA.setRows(5);
        jScrollPane1.setViewportView(addressTA);

        add(jScrollPane1);
        jScrollPane1.setBounds(210, 430, 230, 80);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

        jLabel8.setIcon(img3); 
        jLabel8.setBounds(0, 0, 630, 640);
        
        	setBounds(0, 0, 630,640);
        
        signInLabel = new JLabel("If already you have account, CLICK HERE!");
        signInLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        signInLabel.setForeground(new java.awt.Color(135, 136, 107));
        signInLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(signInLabel);
        signInLabel.setBounds(91, 517, 385, 30);

        signInLabel.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
             LogInCustomer s = new LogInCustomer();
             s.setLocationRelativeTo(null);
             s.setVisible(true);
            setVisible(false);
        }  
        }); 
        add(jLabel8);

    }
    
    private void jButton2ActionPerformed(ActionEvent evt) {
         String fname =FnameTF.getText();
         String lname = LnameTF.getText();
         int custID = Integer.parseInt(IDField.getText());
         String pass = String.valueOf(passField.getPassword());
         java.util.Date bdate= birtdatePicker.getDate();
         String address = addressTA.getText();
         
         if(pass.equals("")|| address.equals("") || fname.equals("")||lname.equals("") || bdate.equals("") || checkID(custID) ){
             JOptionPane.showMessageDialog(null, "A field is empty, please fill it out, if not then the username is already exists.","FAILUR SIGNING UP" ,JOptionPane.WARNING_MESSAGE);
         }
         else{
             if(pass.length()>=8){
             if(checkPass(pass)){

        PreparedStatement st;
        String query= "INSERT into CUSTOMER (fName, lName, CustomerID,Password,Birthdate, Address) VALUES(?,?,?,?,?,?)";
        try { 
            java.sql.Date date2 = new java.sql.Date(bdate.getTime());
            
            
            MyConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant", "APP", "deitel");
            st= MyConnection.prepareStatement(query);

             st.setString(1, fname);
             st.setString(2, lname);
             st.setInt(3, custID);
             st.setString(4, pass);
             st.setDate(5, date2);
             st.setString(6, address);
             
             if(st.executeUpdate()>0){
             JOptionPane.showMessageDialog(null, "Welcome "+fname+" "+lname);
              fileHistory.signUpCust(custID+"");

             Customer newCust = new Customer(address, custID, pass,fname,lname, bdate);
             customerMainPage page = new customerMainPage(newCust);
             page.setLocationRelativeTo(null);
             page.setVisible(true);
             setVisible(false);
          
             }
        }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage());
        
        } catch (InputMismatchException | NumberFormatException n) {
             JOptionPane.showMessageDialog(null, n.getMessage(), "Error",JOptionPane.ERROR_MESSAGE );

        } catch (Exception x) {
        JOptionPane.showMessageDialog(null, "Wrong input type"+x.getMessage(), "Error",JOptionPane.ERROR_MESSAGE );
        }
         
         }         
             else
         JOptionPane.showMessageDialog(null, "Password must have at least one small and capital letters as well as integer values.", "Password WARNING", JOptionPane.WARNING_MESSAGE);

         }
             else
         JOptionPane.showMessageDialog(null, "Password must include at least 8 characters!", "Password WARNING", JOptionPane.WARNING_MESSAGE);
    }
    }
    
        public boolean checkID(int ID){
            PreparedStatement ps;
            ResultSet rs;
            boolean checkUser = true;
            String query = "SELECT * FROM Customer WHERE 'customerID' =?";
            
            try{
            MyConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant", "APP", "deitel");
   
            ps = MyConnection.prepareStatement(query);
            ps.setInt(1, ID);
            
            rs = ps.executeQuery();
            if(rs.next()){
                checkUser=false;
            }
            
            }
            catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"The ID number is ", "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
           return checkUser;
        }
    
        public static boolean checkPass(String pass){
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;        
        char c;
        for(int i = 0; i<pass.length();i++){
        c= pass.charAt(i);
                if(Character.isDigit(c)){
        hasNum=true;
        }
        else if(Character.isUpperCase(c)){
            hasCap = true;
        }
            else if(Character.isLowerCase(c)){
            hasLow = true;}  
                if(hasNum & hasCap&hasLow){
                    return true;
                }
        }
        return false;}        
        
    private final JButton cancelButton;
    private final JButton RegisterButton;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLabel jLabel8;
    private final JScrollPane jScrollPane1;
    private final JTextArea addressTA;
    private final JTextField IDField;
    private final JPasswordField passField;
    private final JTextField FnameTF;
    private final JTextField LnameTF;
    private final JXDatePicker birtdatePicker;
             Connection MyConnection;
             JLabel signInLabel;
    private final FileHistory fileHistory = new FileHistory();

}
