/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;

import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class deleteMeal extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
           MealsQueries query;
        String[] allMeals;
        ArrayList<Meal> meals;
        Meal currentMeal;

	public deleteMeal(Admin currentAdmin) {
            
             query = new MealsQueries();
             allMeals= query.selectAllMealsNames();
             
        meals = query.selectAllMeals();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
    
	
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

	contentPane.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Choose Meal :");
	lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(108, 275, 152, 55);
	contentPane.add(lblNewLabel_1);
	

	JComboBox comboBox = new JComboBox(allMeals);
	comboBox.setBounds(220, 271, 219, 70);
	contentPane.add(comboBox);
	
	JLabel lblDeleteMeal = new JLabel("Delete Meal");
	lblDeleteMeal.setForeground(new Color(153, 102, 0));
	lblDeleteMeal.setFont(new Font("GE SS", Font.BOLD, 25));
	lblDeleteMeal.setBounds(285, 89, 230, 64);
	contentPane.add(lblDeleteMeal);
	
	JButton btnDelete = new JButton("delete");
	btnDelete.setForeground(new Color(143, 188, 143));
	btnDelete.setBackground(new Color(128, 128, 0));
	btnDelete.setBounds(126, 454, 130, 29);
	contentPane.add(btnDelete);
	
	JButton btnCancel = new JButton("Back");
	btnCancel.setForeground(new Color(143, 188, 143));
	btnCancel.setBackground(new Color(128, 128, 0));
	btnCancel.setBounds(264, 454, 117, 29);
	contentPane.add(btnCancel);
	btnCancel.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
               page.setVisible(true);
               setVisible(false);
            } 
         } 
      );
        
        
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBounds(0, 0, 630,640);
	lblNewLabel.setIcon(img3);
	
		contentPane.add(lblNewLabel);
                                        
		comboBox.addItemListener(
                new ItemListener(){
                    @Override
                     public void itemStateChanged (ItemEvent e){ 
                         
                         if(e.getStateChange()==ItemEvent.SELECTED){
                        currentMeal = meals.get(comboBox.getSelectedIndex());                             
     
                         }
                     }
                    }   
                );
                
                
                 btnDelete.addActionListener( 
                            new ActionListener(){
                                
          @Override
          public void actionPerformed(ActionEvent e) {                                                            
                           
               try{  
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+currentMeal.getMealname()+" ?", "Confirm ",JOptionPane.YES_NO_OPTION );
                 if(confirm==0){
                     
                  int result = query.DeleteMeal(currentMeal.getMealname());
                  if (result >0){
                      JOptionPane.showMessageDialog(null, " deleted successfully");
                   adminMainPage page = new adminMainPage(currentAdmin);
                    page.setLocationRelativeTo(null);
                   page.setVisible(true);
                   setVisible(false);
                  }
                  else
                      JOptionPane.showMessageDialog(null, " cannot apply delet process!");
                  }}
                 catch(Exception ex){
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                  } 
          }
                                   }); 
                

}
                         
                         }
   