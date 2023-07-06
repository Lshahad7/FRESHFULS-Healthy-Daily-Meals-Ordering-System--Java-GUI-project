/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;


import FreshFuls.Customer;
import FreshFuls.customerMainPage;
import Orders.OrderingFrame;

/**
 *
 * @author bayanalhumaidan
 */

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class orderPackage extends JFrame {

	private final JPanel contentPane;
        
        private Package currentEntry;
        private final packageQueries queries;
        private List<Package> results;
        private int numberOfEntries = 0;
        private int currentEntryIndex;    
        
        String breakfastDishName;
        String breakfastDrinkName;
        String breakfastDessertName;
        String lunchDishName;
        String lunchDrinkName;
        String lunchDessertName;
        String dinnerDishName;
        String dinnerDrinkName;
        String dinnerDessertName;
        
        private final JTextField nameField;
	private final JTextField priceField;
	private final JTextField dietField;
        private final JCheckBox ketoCheck;
        private final JCheckBox veganCheck;
        private final JTextField breakfastDishField;
        private final JTextField breakfastDessertField;
        private final JTextField breakfastDrinkField;
        private final JTextField lunchDishField;
        private final JTextField lunchDessertField;
        private final JTextField lunchDrinkField;
        private final JLabel dinnerLabel;
        private final JTextField dinnerDishField;
        private final JTextField dinnerDessertField;
        private final JTextField dinnerDrinkField;
        
        private final JTextField currentField;
        private final JTextField totalField;
        private final JLabel ofLabel;
        private final JButton orderButton;
        private final int customerID;
       Customer customer;

        
    public orderPackage(Customer customer){
        this.customer= customer;
        queries = new packageQueries();
        customerID=customer.getUserID();
        
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
	setContentPane(contentPane);
	contentPane.setLayout(null);

	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
	contentPane.setLayout(null);
	
	JLabel nameLabel = new JLabel("Package Name:");
	nameLabel.setBounds(249, 157, 115, 16);
	contentPane.add(nameLabel);
	
	JLabel priceLabel = new JLabel("Price per month:");
	priceLabel.setBounds(249, 236, 115, 16);
	contentPane.add(priceLabel);
	
	JLabel dietLabel= new JLabel("Diet Type:");
	dietLabel.setBounds(249, 196, 83, 16);
	contentPane.add(dietLabel);


	JLabel title = new JLabel("Packages");
	title.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	title.setBounds(321, 79, 230, 64);
	title.setForeground(new Color(153, 102, 0));
	contentPane.add(title);
	
	nameField = new JTextField();
	nameField.setBackground(SystemColor.window);
	nameField.setBounds(372, 155, 160, 20);
	contentPane.add(nameField);

        nameField.setEditable(false);
	
	priceField = new JTextField();
	priceField.setColumns(10);
	priceField.setBackground(SystemColor.window);
	priceField.setBounds(372, 234, 130, 20);
	contentPane.add(priceField);
	priceField.setEditable(false);
        
        veganCheck = new JCheckBox("Vegan");
	veganCheck.setBounds(348, 264, 141, 23);
	contentPane.add(veganCheck);
        veganCheck.setEnabled(false);
	
        ketoCheck=new JCheckBox("Keto");
        ketoCheck.setEnabled(false);
	ketoCheck.setBounds(273, 264, 141, 23);
	contentPane.add(ketoCheck);
        
	orderButton = new JButton("Order this Package");
	orderButton.setForeground(new Color(128, 128, 0));
	orderButton.setBackground(new Color(208, 229, 204));
        orderButton.setBounds(450, 515, 150, 40);
        orderButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               orderButton(evt);
            } 
         } 
      );
	contentPane.add(orderButton);

        
	JButton btnMenu = new JButton(" Main Page");
	btnMenu.setForeground(new Color(128, 128, 0));
	btnMenu.setBackground(new Color(143, 188, 143));
	btnMenu.setBounds(20, 515, 110, 30);
	contentPane.add(btnMenu);
        btnMenu.addActionListener(
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

	
	dietField = new JTextField();
	dietField.setBackground(UIManager.getColor("Button.background"));
	dietField.setBounds(372, 191, 130, 26);
	contentPane.add(dietField);
        dietField.setEditable(false);
	dietField.setColumns(10);
        
	JLabel background = new JLabel("");
	background.setBounds(0, 0, 630, 640);
	background.setIcon(img3);
	
	JLabel lblNewLabel_6 = new JLabel("Breakfast:");
	lblNewLabel_6.setBounds(71, 284, 260, 16);
	contentPane.add(lblNewLabel_6);

        JButton backButton = new JButton("Back");
	backButton.setForeground(new Color(143, 188, 143));
	backButton.setBackground(new Color(128, 128, 0));
	backButton.setBounds(170, 515, 90, 29);
	contentPane.add(backButton);
	backButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               backActionPerformed(evt);
            } 
         } 
      );
        
	JButton nextButton = new JButton("next");
	nextButton.setForeground(new Color(143, 188, 143));
	nextButton.setBackground(new Color(128, 128, 0));
	nextButton.setBounds(320, 515, 90, 29);
	contentPane.add(nextButton);
        nextButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               nextActionPerformed(evt);
            } 
         } 
      );
        
        breakfastDishField = new JTextField();
        breakfastDishField.setBounds(13, 304, 185, 26);
        breakfastDishField.setEditable(false);
        contentPane.add(breakfastDishField);
        breakfastDishField.setColumns(10);
        
        breakfastDessertField = new JTextField();
        breakfastDessertField.setColumns(10);
        breakfastDessertField.setBounds(211, 304, 185, 26);
        breakfastDessertField.setEditable(false);
        contentPane.add(breakfastDessertField);
        
        breakfastDrinkField = new JTextField();
        breakfastDrinkField.setColumns(10);
        breakfastDrinkField.setBounds(409, 304, 178, 26);
        breakfastDrinkField.setEditable(false);
        contentPane.add(breakfastDrinkField);
        
        JLabel lblNewLabel_6_1 = new JLabel("Lunch:");
        lblNewLabel_6_1.setBounds(71, 342, 260, 16);
        contentPane.add(lblNewLabel_6_1);
        
        lunchDishField = new JTextField();
        lunchDishField.setColumns(10);
        lunchDishField.setBounds(13, 362, 185, 26);
        lunchDishField.setEditable(false);
        contentPane.add(lunchDishField);
        
        lunchDessertField = new JTextField();
        lunchDessertField.setColumns(10);
        lunchDessertField.setBounds(211, 362, 185, 26);
        lunchDessertField.setEditable(false);
        contentPane.add(lunchDessertField);
        
        lunchDrinkField = new JTextField();
        lunchDrinkField.setColumns(10);
        lunchDrinkField.setBounds(409, 362, 178, 26);
        lunchDrinkField.setEditable(false);
        contentPane.add(lunchDrinkField);
        
        dinnerLabel = new JLabel("Dinner:");
        dinnerLabel.setBounds(71, 400, 260, 16);
        contentPane.add(dinnerLabel);
        
        dinnerDishField = new JTextField();
        dinnerDishField.setColumns(10);
        dinnerDishField.setBounds(13, 420, 185, 26);
        dinnerDishField.setEditable(false);
        contentPane.add(dinnerDishField);
        
        dinnerDessertField = new JTextField();
        dinnerDessertField.setEditable(false);
        dinnerDessertField.setColumns(10);
        dinnerDessertField.setBounds(211, 420, 185, 26);
        dinnerDessertField.setEditable(false);
        contentPane.add(dinnerDessertField);
        
        dinnerDrinkField = new JTextField();
        dinnerDrinkField.setEditable(false);
        dinnerDrinkField.setColumns(10);
        dinnerDrinkField.setBounds(409, 420, 178, 26);
        contentPane.add(dinnerDrinkField);
        
        currentField = new JTextField();
        currentField.setBounds(191, 487, 46, 26);
        contentPane.add(currentField);
        currentField.setColumns(10);
        currentField.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        currentFieldActionPerformed(event);
                    }
                });
        
        totalField = new JTextField();
        totalField.setColumns(10);
        totalField.setBounds(348, 487, 46, 26);
        contentPane.add(totalField);
        totalField.setEditable(false);
        
        ofLabel = new JLabel("OF");
        ofLabel.setBounds(281, 492, 24, 16);
        contentPane.add(ofLabel);
        contentPane.add(background);

        addWindowListener(
         new WindowAdapter() 
         {  public void windowOpened(WindowEvent evt){             
             openWindowEvent();
         }
	});
  
                      }      
        
    private void openWindowEvent(){
      try{
         results = queries.displayPackages(); 
         numberOfEntries = results.size();
         
         if (numberOfEntries != 0)
         {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            nameField.setText(currentEntry.getName());
            priceField.setText(""+currentEntry.getPrice());
            dietField.setText(currentEntry.getDietType());
            
            if(currentEntry.isVegan())
            veganCheck.setSelected(true); else veganCheck.setSelected(false); 
        
            if(currentEntry.isKeto())
            ketoCheck.setSelected(true); else ketoCheck.setSelected(false); 

                String[] breakfast= currentEntry.getBreakfast();
                String[] lunch = currentEntry.getLunch();
                String[] dinner = currentEntry.getDinner();
            
            breakfastDishField.setText(breakfast[0]);
            breakfastDessertField.setText(breakfast[1]);
            breakfastDrinkField.setText(breakfast[2]);
            lunchDishField.setText(lunch[0]);
            lunchDessertField.setText(lunch[1]);
            lunchDrinkField.setText(lunch[2]);
            dinnerDishField.setText(dinner[0]);
            dinnerDessertField.setText(dinner[1]);
            dinnerDrinkField.setText(dinner[2]);
            
         currentField.setText(""+ (currentEntryIndex+1));
         totalField.setText(""+numberOfEntries);
            
         }
         
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
      
  }
  
    private void currentFieldActionPerformed(ActionEvent evt)
   {
       try{ 
        currentEntryIndex = 
         (Integer.parseInt(currentField.getText()) - 1);
      
      if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
            currentEntry = results.get(currentEntryIndex);
            nameField.setText(currentEntry.getName());
            priceField.setText(""+currentEntry.getPrice());
            dietField.setText(currentEntry.getDietType());
            
            if(currentEntry.isVegan())
            veganCheck.setSelected(true); else veganCheck.setSelected(false); 
        
            if(currentEntry.isKeto())
            ketoCheck.setSelected(true); else ketoCheck.setSelected(false); 

                String[] breakfast= currentEntry.getBreakfast();
                String[] lunch = currentEntry.getLunch();
                String[] dinner = currentEntry.getDinner();
            
            breakfastDishField.setText(breakfast[0]);
            breakfastDrinkField.setText(breakfast[1]);
            breakfastDessertField.setText(breakfast[2]);
            
            lunchDishField.setText(lunch[0]);
            lunchDrinkField.setText(lunch[1]);
            lunchDessertField.setText(lunch[2]);
            
            dinnerDishField.setText(dinner[0]);
            dinnerDrinkField.setText(dinner[1]);
            dinnerDessertField.setText(dinner[2]);
            dinnerDrinkField.setText(dinner[1]);

         currentField.setText(""+ (currentEntryIndex+1));
         totalField.setText(""+numberOfEntries);
          
        }else
          JOptionPane.showMessageDialog(null, "Please enter valid number", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
       }
      }

    private void nextActionPerformed(ActionEvent evt) 
   {
      currentEntryIndex++;      
      if (currentEntryIndex >= numberOfEntries)
         currentEntryIndex = 0;
      
      currentField.setText("" + (currentEntryIndex + 1));
      currentFieldActionPerformed(evt);
   }
   
    private void backActionPerformed(ActionEvent evt)
   {
      currentEntryIndex--;    
      if (currentEntryIndex < 0)
         currentEntryIndex = numberOfEntries - 1;
      
      currentField.setText("" + (currentEntryIndex + 1));
      currentFieldActionPerformed(evt);  
   } 
   
    private void orderButton(ActionEvent event){
        try{
        String[] options = {"1 month",  "3 months","6 months", "1 year"};
        String message = "Choose the duration of the package subscribtion: \n  if you choosed: \n  3  months: 50% discount for 1 month.\n  6 months: 1 free month. \n  1 year: 3 free months.";
        int option = JOptionPane.showOptionDialog(null, message,"Choose Option", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options,options[0] );
        double price = Double.parseDouble(priceField.getText());
        
        switch(option){
            case 0: break;
            case 1: price= (3*price) - (price*0.50) ;break;
            case 2: price=(6*price) - (price);break;
            case 3: price=(12*price) - (price*3);break;
            default: break;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "The price will be = "+price+", Are you sure you want to order?", "Confirm Order",JOptionPane.YES_NO_OPTION );

        //0=yes, 1=no, 2=cancel
        if(confirm==0){
        OrderingFrame frame= new OrderingFrame( customer,  currentEntry,  price);   
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
        }
        
    
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
}
}