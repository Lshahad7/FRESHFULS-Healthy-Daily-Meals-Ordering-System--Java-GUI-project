/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;
import FreshFuls.Admin;
import FreshFuls.adminMainPage;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class displayPackage extends JFrame {

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
        
        private final JTextField caloriesField;        
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
       

    public displayPackage(Admin currentAdmin){
        queries = new packageQueries();
        
        
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
	contentPane.setLayout(null);

	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
	contentPane.setLayout(null);
	
	JLabel nameLabel = new JLabel("Package Name:");
	nameLabel.setBounds(249, 150, 115, 16);
	contentPane.add(nameLabel);
        
	JLabel dietLabel= new JLabel("Diet Type:");
	dietLabel.setBounds(249, 180, 83, 16);
	contentPane.add(dietLabel);

	JLabel priceLabel = new JLabel("Price per month:");
	priceLabel.setBounds(249, 210, 115, 16);
	contentPane.add(priceLabel);
	
	JLabel caloriesLabel = new JLabel("Package calories:");
	caloriesLabel.setBounds(249, 240, 115, 16);
	contentPane.add(caloriesLabel);


	JLabel title = new JLabel("Packages");
	title.setFont(new Font("Lucida Grande", Font.BOLD, 25));
	title.setBounds(321, 79, 230, 64);
	title.setForeground(new Color(153, 102, 0));
	contentPane.add(title);
	
	nameField = new JTextField();
	nameField.setBackground(SystemColor.window);
	nameField.setBounds(372, 150, 160, 20);
	contentPane.add(nameField);

        nameField.setEditable(false);
	
	priceField = new JTextField();
	priceField.setColumns(10);
	priceField.setBackground(SystemColor.window);
	priceField.setBounds(372, 210, 130, 20);
	contentPane.add(priceField);
	priceField.setEditable(false);
        
        veganCheck = new JCheckBox("Vegan");
	veganCheck.setBounds(348, 270, 141, 23);
	contentPane.add(veganCheck);
        veganCheck.setEnabled(false);
	
        ketoCheck=new JCheckBox("Keto");
        ketoCheck.setEnabled(false);
	ketoCheck.setBounds(273, 270, 141, 23);
	contentPane.add(ketoCheck);
	
	JButton btnCancel = new JButton(" Main Page");
	btnCancel.setBackground(new Color(128, 128, 0));
	btnCancel.setForeground(new Color(143, 188, 143));
	btnCancel.setBounds(30, 515, 117, 29);
	contentPane.add(btnCancel);
        btnCancel.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
                page.setVisible(true);
                setVisible(false);
            }
        }
        );

	
	dietField = new JTextField();
	dietField.setBackground(UIManager.getColor("Button.background"));
	dietField.setBounds(372, 180, 130, 26);
	contentPane.add(dietField);
        dietField.setEditable(false);
	dietField.setColumns(10);
        
	caloriesField = new JTextField();
	caloriesField.setBackground(UIManager.getColor("Button.background"));
	caloriesField.setBounds(372, 240, 130, 26);
	contentPane.add(caloriesField);
        caloriesField.setEditable(false);
        
	JLabel background = new JLabel("");

	background.setBounds(0, 6, 630, 640);
	background.setIcon(img3);
	
	JLabel lblNewLabel_6 = new JLabel("Breakfast:");
	lblNewLabel_6.setBounds(71, 284, 260, 16);
        
	contentPane.add(lblNewLabel_6);

        JButton backButton = new JButton("Back");
	backButton.setForeground(new Color(143, 188, 143));
	backButton.setBackground(new Color(128, 128, 0));
	backButton.setBounds(200, 515, 117, 29);
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
	nextButton.setBounds(372, 515, 117, 29);
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
        setContentPane(contentPane);

     
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
            caloriesField.setText(""+currentEntry.getCalories());
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
            caloriesField.setText(""+currentEntry.getCalories());
            
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
   
}