package FreshFuls;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hindalzahrani
 */
public class main_Interface extends JFrame {

        public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              				try {
					main_Interface frame = new main_Interface();
					frame.setVisible(true);
                                        frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
 
            }
        });
    }


    public main_Interface() {
                setLocationRelativeTo(null);

        signUp = new JButton();
        custLogIn = new JButton();
        jLabel2 = new JLabel();
        adminLogIn = new JButton();
        setLayout(null);
        
        


        setTitle("FRESHFULS");
        signUp.setBackground(new Color(204, 204, 204));
        signUp.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        signUp.setForeground(new java.awt.Color(102, 102, 0));
        signUp.setText("SIGN UP");
        signUp.setAutoscrolls(true);
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });
        add(signUp);
        signUp.setBounds(220, 430, 300, 40);

        custLogIn.setBackground(new java.awt.Color(195, 195, 195));
        custLogIn.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        custLogIn.setForeground(new java.awt.Color(102, 102, 0));
        custLogIn.setText("CUSTOMER LOG IN");
        custLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custLogInActionPerformed(evt);
            }
        });
        add(custLogIn);
        custLogIn.setBounds(220, 390, 300, 40);

        adminLogIn.setBackground(new java.awt.Color(195, 195, 195));
        adminLogIn.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        adminLogIn.setForeground(new java.awt.Color(102, 102, 0));
        adminLogIn.setText("ADMIN LOG IN");
        adminLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogInActionPerformed(evt);
            }
        });
        add(adminLogIn);
        adminLogIn.setBounds(220, 470, 300, 40);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("welcome.jpeg"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

        jLabel2.setIcon(img3); 
        jLabel2.setBounds(0, 0, 630, 640);
        add(jLabel2);
        	setBounds(0, 0, 630, 640);
       
        
    }

    private void signUpActionPerformed(ActionEvent evt) {
        signUp frame = new signUp();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }
    

    private void custLogInActionPerformed(java.awt.event.ActionEvent evt) {
        LogInCustomer frame =new LogInCustomer();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }

    private void adminLogInActionPerformed(java.awt.event.ActionEvent evt) {
        LogInAdmin frame =new LogInAdmin();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }


    private JButton signUp;
    private JButton custLogIn;
    private JButton adminLogIn;
    private JLabel jLabel2;
}
