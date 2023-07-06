
package FreshFuls;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.*;

public class LogInAdmin extends JFrame {

        public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              				try {
					LogInAdmin frame = new LogInAdmin();
					frame.setVisible(true);
                                        frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
 
            }
        });
    }
 
    public LogInAdmin() {

        jPanel1 = new JPanel();
        IDTextField = new JTextField();
        jPasswordLogIn = new JPasswordField();
        jButtonLogIn = new JButton();
        jLabelUserName = new JLabel();
        jLabelPassword = new JLabel();
        jLabelUseIcon = new JLabel();
        jLabelBackground = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(630,640));
        jPanel1.setLayout(null);

        IDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDTextField.setToolTipText("Enter ID number");
        jPanel1.add(IDTextField);
        
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
        IDTextField.setBounds(210, 350, 200, 30);

        jPasswordLogIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordLogIn.setToolTipText("Enter Password");
        jPanel1.add(jPasswordLogIn);
        jPasswordLogIn.setBounds(210, 410, 200, 30);

        jButtonLogIn.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogIn.setForeground(new java.awt.Color(135, 136, 107));
        jButtonLogIn.setText("Log In");
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            logInAction(evt); 
            }
        });
        jPanel1.add(jButtonLogIn);
        jButtonLogIn.setBounds(240, 460, 140, 30);

        jLabelUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUserName.setForeground(new java.awt.Color(135, 136, 107));
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelUserName.setText("Admin ID: ");
        jLabelUserName.setToolTipText("");
        jPanel1.add(jLabelUserName);
        jLabelUserName.setBounds(210, 330, 150, 20);

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(135, 136, 107));
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPassword.setText("Password: ");
        jPanel1.add(jLabelPassword);
        jLabelPassword.setBounds(210, 390, 90, 20);

        cancelButton = new JButton();
        cancelButton.setText("Back");
        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(135, 136, 107));
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                main_Interface frame = new main_Interface();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        add(cancelButton);
        cancelButton.setBounds(240, 510, 140, 30);
    try{
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("userIcon.jpeg"));
	Image img1 = imageIcon2.getImage();
	Image img21 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon img31 = new ImageIcon(img21);
        
        jLabelUseIcon.setText("");
        jPanel1.add(jLabelUseIcon);
        jLabelUseIcon.setBounds(270, 200, 100, 100);
        jLabelUseIcon.setIcon(img31);
                
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

        jLabelBackground.setIcon(img3); 
        jPanel1.add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 630, 640);
       } 
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "The image location is null", 
                                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }

    
    private void logInAction(java.awt.event.ActionEvent evt) {
        try{
            int adminID = Integer.parseInt(IDTextField.getText());
        
        String pass = String.valueOf(jPasswordLogIn.getPassword());

           Admin currentAdmin = checkCustomer(adminID,pass);
           
               if(currentAdmin!=null){
                JOptionPane.showMessageDialog(null, "Welcome " +currentAdmin.getFname()+" "+currentAdmin.getLname()+"! \n You have logged in successfully");
                fileHistory.logInAdmin(adminID+"");
                adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
                page.setVisible(true);
                setVisible(false);
            }
            else{
                 JOptionPane.showMessageDialog(null, "Incorrect ID number or password!", "Insuccessful login", JOptionPane.WARNING_MESSAGE);
            }

        }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter number value", "ERROR",JOptionPane.ERROR_MESSAGE );           
        }
                catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );           
        }

            
        }

    public Admin checkCustomer(int custID, String password){
            PreparedStatement ps;
            String name;
            ResultSet rs;
            String query = "SELECT * FROM ADMIN WHERE adminID =? AND password =?";
            
            try{
                MyConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant", "APP", "deitel");
                ps= MyConnection.prepareStatement(query);

                ps.setInt(1, custID);
                ps.setString(2, password);

                rs = ps.executeQuery();
                if(rs.next()){
                    Admin currentAdmin = new Admin(rs.getDouble("Salary"), rs.getInt("adminID"),rs.getString("Password"),
                    rs.getString("fname"),rs.getString("lname"),rs.getTimestamp("Birthdate"));
                    return currentAdmin;
                }
                }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
           return null;
        }

    
    private JButton jButtonLogIn;
        JButton cancelButton;
    private JLabel jLabelBackground;
    private JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUseIcon;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordLogIn;
    private javax.swing.JTextField IDTextField;
    Connection MyConnection;
    private FileHistory fileHistory = new FileHistory();
    
}
