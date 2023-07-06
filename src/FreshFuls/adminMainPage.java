
package FreshFuls;


/**
 *
 * @author bayanalhumaidan
 */
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import Package.addPackage;
import Meal.*;
import Orders.ViewOrdersFrame;
import Package.deletePackage;
import Package.displayPackage;
import Package.updatePackage;
import customerService.AdminCustService;

public class adminMainPage extends JFrame {

	private JPanel contentPane;
        Admin currentAdmin;
        int adminID;
        private JButton btnAddMeal;
        private JButton btnAddPackage;
        private JButton btnUpdateMeal;
        private  JButton btnDeleteMeal;      
        private JButton btnDeletePackage;
        private  JButton btnDisplayOrders;     
        private JButton btnUpdatePackage;
        private JButton btnCustService;
        private JButton displayMeal;
        private JButton displayPackages;

        private JButton displayHistory;
        
    private FileHistory fileHistory = new FileHistory();

        
        public adminMainPage(Admin currentAdmin) {
            this.currentAdmin=currentAdmin;
                adminID=currentAdmin.getUserID();
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 630, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel adminMainPage = new JLabel("");
		adminMainPage.setBounds(0, 0, 630, 640);

		ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
		Image img = imageIcon.getImage();
		Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
		ImageIcon img3 = new ImageIcon(img2);
		contentPane.setLayout(null);
		
		 btnAddMeal = new JButton("Add Meal");
		btnAddMeal.setBackground(UIManager.getColor("Button.background"));
		btnAddMeal.setBounds(119, 246, 130, 35);
		contentPane.add(btnAddMeal);
		
		btnAddPackage = new JButton("Add Package");
		btnAddPackage.setBackground(SystemColor.window);
		btnAddPackage.setBounds(119, 281, 130, 35);
		contentPane.add(btnAddPackage);
		
		 btnUpdateMeal = new JButton("Update Meal");
		btnUpdateMeal.setBackground(SystemColor.window);
		btnUpdateMeal.setBounds(119, 316, 130, 35);
		contentPane.add(btnUpdateMeal);
		
		 btnDeleteMeal = new JButton("Delete Meal");
		btnDeleteMeal.setBackground(SystemColor.window);
		btnDeleteMeal.setBounds(261, 281, 130, 35);
		contentPane.add(btnDeleteMeal);
		
		 btnUpdatePackage = new JButton("Update Package");
		btnUpdatePackage.setBackground(SystemColor.window);
		btnUpdatePackage.setBounds(119, 350, 130, 35);
		contentPane.add(btnUpdatePackage);
		
                displayPackages= new JButton("Display Packages");
		displayPackages.setBackground(SystemColor.window);
		displayPackages.setBounds(119, 384, 130, 35);
		contentPane.add(displayPackages);
                
                displayMeal= new JButton("Display Meals");
		displayMeal.setBackground(SystemColor.window);
		displayMeal.setBounds(261, 384, 130, 35);
		contentPane.add(displayMeal);

                
              	displayHistory = new JButton("Log in/out History");
		displayHistory.setBackground(SystemColor.window);
		displayHistory.setBounds(119, 419, 130, 35);
                displayHistory.setFont(new Font("GE SS", Font.PLAIN, 11));
		contentPane.add(displayHistory);
                displayHistory.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    fileHistory.readHistory();
                }
            });
                
		 btnDeletePackage = new JButton("Delete Package");
		btnDeletePackage.setBackground(SystemColor.window);
		btnDeletePackage.setBounds(261, 246, 130, 35);
		contentPane.add(btnDeletePackage);
		
		 btnDisplayOrders = new JButton("Display Orders");
		btnDisplayOrders.setBackground(UIManager.getColor("CheckBox.background"));
		btnDisplayOrders.setBounds(261, 316, 130, 35);
		contentPane.add(btnDisplayOrders);
		
		 btnCustService = new JButton("Customer Service");
		btnCustService.setBounds(261, 350, 130, 35);
		contentPane.add(btnCustService);
                
		JLabel LabelMainPage = new JLabel("Admin Main Page");
		LabelMainPage.setForeground(new Color(153, 102, 0));
		LabelMainPage.setFont(new Font("GE SS", Font.BOLD, 25));
		LabelMainPage.setBounds(254, 138, 249, 58);
		contentPane.add(LabelMainPage);
		
		JButton logOutBtn = new JButton("log out");
		logOutBtn.setBounds(172, 500, 117, 29);
                logOutBtn.setForeground(new Color(255, 51, 51));

                logOutBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    main_Interface frame = new main_Interface();
                    fileHistory.logOutAdmin(adminID+"");
                   frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    setVisible(false);

                }
            });
		contentPane.add(logOutBtn);
		adminMainPage.setIcon(img3);
                
		contentPane.add(adminMainPage);
                
        
                Handler handler = new Handler();
                btnAddPackage.addActionListener(handler);
                btnAddMeal.addActionListener(handler);
                btnDisplayOrders.addActionListener(handler);
                btnCustService.addActionListener(handler);
                btnDeleteMeal.addActionListener(handler);
                btnUpdatePackage.addActionListener(handler);
                btnUpdateMeal.addActionListener(handler);  
                btnDeletePackage.addActionListener(handler);  
                displayPackages.addActionListener(handler);  
                displayMeal.addActionListener(handler);  
	}
        
        private class Handler implements ActionListener {
		@Override
                public void actionPerformed(ActionEvent evt){
                    
                    if(evt.getSource()==btnAddPackage){
                    addPackage frame = new addPackage( currentAdmin);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    setVisible(false);
                    }
                    else  if(evt.getSource()==btnAddMeal){
                    addMeal frame = new addMeal( currentAdmin);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == btnDisplayOrders){
                    ViewOrdersFrame frame = new ViewOrdersFrame(currentAdmin);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == btnCustService){                    
                    AdminCustService page = new AdminCustService(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == btnDeleteMeal){                    
                    deleteMeal page = new deleteMeal(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == btnDeletePackage){                    
                    deletePackage page = new deletePackage(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == btnUpdatePackage){                    
                    updatePackage page = new updatePackage(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }    
                    else if(evt.getSource() == btnUpdateMeal){                    
                    updateMeal page = new updateMeal(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == displayPackages){                    
                    displayPackage page = new displayPackage(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    else if(evt.getSource() == displayMeal){                    
                    adminMenu page = new adminMenu(currentAdmin);
                    page.setLocationRelativeTo(null);
                    page.setVisible(true);
                    setVisible(false);
                    }
                    
                    
                }
	}
        
    
}
