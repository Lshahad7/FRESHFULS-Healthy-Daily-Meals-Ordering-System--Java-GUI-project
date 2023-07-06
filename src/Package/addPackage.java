/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

/**
 *
 * @author bayanalhumaidan
 */


import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addPackage extends JFrame {
	private final JPanel contentPane;
	private final JTextField nameField;
	private final JTextField priceField;
	private final JTextField dietField;
        private final JCheckBox ketoCheck;
        private final JCheckBox veganCheck;
        
        JComboBox<String> breakfastDrink;
        JComboBox<String> breakfastDessert;
        JComboBox<String> breakfastDish;
        JComboBox<String> dinnerDrink;
        JComboBox<String> dinnerDish;
        JComboBox<String> dinnerDessert;
        JComboBox<String> lunchDrink;
        JComboBox<String> lunchDessert;
        JComboBox<String> lunchDish;
        
        
        packageQueries queries;
        String[] drinks;
        String[] dishes;
        String[] desserts;
        String breakfastDishName;
        String breakfastDrinkName;
        String breakfastDessertName;
        String lunchDishName;
        String lunchDrinkName;
        String lunchDessertName;
        String dinnerDishName;
        String dinnerDrinkName;
        String dinnerDessertName;
        String[] mealsSelected;
       
        adminMainPage mainPage;
        Admin currentAdmin;

	public addPackage(Admin currentAdmin){
         this.currentAdmin= currentAdmin;
        mealsSelected= new String[9];

         queries = new packageQueries();
         drinks = queries.getAllDrink();
         dishes = queries.getAllDish();
         desserts = queries.getAllDessert();
        
        
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630,640);
        
        
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
	contentPane.setLayout(null);
	
	JLabel nameLabel = new JLabel("Package Name:");
	nameLabel.setBounds(249, 177, 115, 16);
	contentPane.add(nameLabel);
	
	JLabel priceLabel = new JLabel("Package price:");
	priceLabel.setBounds(249, 256, 115, 16);
	contentPane.add(priceLabel);
	
	JLabel dietLabel= new JLabel("Diet Type:");
	dietLabel.setBounds(249, 216, 83, 16);
	contentPane.add(dietLabel);


	JLabel title = new JLabel("Add New Package");
	title.setBounds(272, 86, 230, 64);
	title.setForeground(new Color(153, 102, 0));
	title.setFont(new Font("GE SS", Font.BOLD, 25));
	contentPane.add(title);
	
	nameField = new JTextField();
	nameField.setBackground(SystemColor.window);
	nameField.setBounds(372, 175, 130, 20);
	contentPane.add(nameField);
	nameField.setColumns(10);
	
	
	priceField = new JTextField();
	priceField.setColumns(10);
	priceField.setBackground(SystemColor.window);
	priceField.setBounds(372, 254, 130, 20);
        priceField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = priceField.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        priceField.setText("");
                        JOptionPane.showMessageDialog(null, "Price must be number!");
                    }
                    catch(Exception ex){
                        priceField.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in Price Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
	contentPane.add(priceField);
	
        veganCheck = new JCheckBox("Vegan");
	veganCheck.setBounds(271, 480, 141, 23);
	contentPane.add(veganCheck);
	
        ketoCheck=new JCheckBox("Keto");
	ketoCheck.setBounds(196, 480, 141, 23);
	contentPane.add(ketoCheck);
	
	JButton addPkgButton = new JButton("Add package");
        
	addPkgButton.setBackground(new Color(128, 128, 0));
	addPkgButton.setForeground(new Color(143, 188, 143));
	addPkgButton.setBounds(132, 515, 117, 29);
        addPkgButton.addActionListener(
        new ActionListener(){
                      public void actionPerformed(ActionEvent evt){
                          addPackageActionPerformed(evt);
                      }
  
        }
        );
	contentPane.add(addPkgButton);

	dietField = new JTextField();
	dietField.setBackground(UIManager.getColor("Button.background"));
	dietField.setBounds(372, 211, 130, 26);
	contentPane.add(dietField);
	dietField.setColumns(10);
	
	breakfastDrink = new JComboBox(drinks);
	breakfastDrink.setBounds(348, 311, 130, 24);
	contentPane.add(breakfastDrink);
       
                
	breakfastDessert = new JComboBox(desserts);
	breakfastDessert.setBounds(216, 311, 130, 24);
	contentPane.add(breakfastDessert);

	breakfastDish = new JComboBox(dishes);
	breakfastDish.setBounds(82, 311, 130, 24);
	contentPane.add(breakfastDish);
        
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBounds(0, 6, 630, 640);
	lblNewLabel.setIcon(img3);
	
	JLabel lblNewLabel_6 = new JLabel("Choose breakfast meals:");
	lblNewLabel_6.setBounds(93, 291, 260, 16);
	contentPane.add(lblNewLabel_6);
	
	
	JLabel lunchLabel = new JLabel("Choose lunch meals:");
	lunchLabel.setBounds(93, 340, 260, 16);
	contentPane.add(lunchLabel);

        lunchDish = new JComboBox(dishes);
	lunchDish.setBounds(82, 360, 130, 24);
	contentPane.add(lunchDish);
	
        
	lunchDessert = new JComboBox(desserts);
	lunchDessert.setBounds(216, 360, 130, 24);
	contentPane.add(lunchDessert);

        
	lunchDrink = new JComboBox(drinks);
	lunchDrink.setBounds(348, 360, 130, 24);
	contentPane.add(lunchDrink);
	
        
	JLabel dinnerLabel = new JLabel("Choose dinner meals:");
	dinnerLabel.setBounds(93, 396, 260, 16);
	contentPane.add(dinnerLabel);
	
	dinnerDish = new JComboBox(dishes);
	dinnerDish.setBounds(82, 416, 130, 24);
	contentPane.add(dinnerDish);

        
	dinnerDessert = new JComboBox(desserts);
	dinnerDessert.setBounds(216, 416, 130, 24);
	contentPane.add(dinnerDessert);

        
	dinnerDrink = new JComboBox(drinks);
	dinnerDrink.setBounds(348, 416, 130, 24);
	contentPane.add(dinnerDrink);
        
        
        
	JButton btnCancel_1 = new JButton("Back");
	btnCancel_1.setForeground(new Color(143, 188, 143));
	btnCancel_1.setBackground(new Color(128, 128, 0));
	btnCancel_1.setBounds(372, 515, 117, 29);
	contentPane.add(btnCancel_1);
        	btnCancel_1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt) {
                        mainPage = new adminMainPage(currentAdmin);
                        mainPage.setLocationRelativeTo(null);
                        mainPage.setVisible(true);
                        setVisible(false);
                }}
        );

        contentPane.add(lblNewLabel);
	}


private void addPackageActionPerformed(ActionEvent event){
            boolean vegan;
            boolean keto;

	breakfastDishName = dishes[breakfastDish.getSelectedIndex()];
        mealsSelected[0]=breakfastDishName;            
    	breakfastDrinkName = drinks[breakfastDrink.getSelectedIndex()];
        mealsSelected[1]=breakfastDrinkName;
	breakfastDessertName = desserts[breakfastDessert.getSelectedIndex()];
        mealsSelected[2]=breakfastDessertName;            
	lunchDishName = dishes[lunchDish.getSelectedIndex()];
        mealsSelected[3]=lunchDishName;
	lunchDessertName = desserts[lunchDessert.getSelectedIndex()];
        mealsSelected[4]= lunchDessertName;
	lunchDrinkName = drinks[lunchDrink.getSelectedIndex()];
        mealsSelected[5]=lunchDrinkName;
	dinnerDishName = dishes[dinnerDish.getSelectedIndex()];
        mealsSelected[6]= dinnerDishName;
	dinnerDessertName = desserts[dinnerDessert.getSelectedIndex()];
        mealsSelected[7]=dinnerDessertName ;
	dinnerDrinkName = drinks[dinnerDrink.getSelectedIndex()];        
        mealsSelected[8]=dinnerDrinkName ;

        
        keto = ketoCheck.isSelected();
        vegan = veganCheck.isSelected();
try{
    int cal = calculateCalories(mealsSelected);
    
        double price = Double.parseDouble(priceField.getText().trim());
        int result = queries.addPackage( nameField.getText(), price, cal, dietField.getText() ,
        vegan, keto, breakfastDishName, breakfastDrinkName, breakfastDessertName, lunchDishName, lunchDrinkName,
        lunchDessertName, dinnerDishName, dinnerDrinkName, dinnerDessertName);

         if (result == 1){
         JOptionPane.showMessageDialog(this, "Package added!",
            "Package added successfully", JOptionPane.PLAIN_MESSAGE);
                        mainPage = new adminMainPage(currentAdmin);
                        mainPage.setLocationRelativeTo(null);
                        mainPage.setVisible(true);
                        setVisible(false);
         }
      else
         JOptionPane.showMessageDialog(this, "Package not added!",
            "Error", JOptionPane.ERROR_MESSAGE);
 }
catch(Exception ex){
           JOptionPane.showMessageDialog(this, ex.getMessage(),
            "Error", JOptionPane.PLAIN_MESSAGE);
}     

}

    private int calculateCalories(String[] meals){
        int calories=0;

            for (String meal : meals) {
                calories += queries.getCaloriesByName(meal);
}
        return calories;
    }



} // end class

