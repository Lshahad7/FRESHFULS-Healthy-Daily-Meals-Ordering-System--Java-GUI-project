package Package;

/**
 *
 * @author bayanalhumaidan
 */
import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class updatePackage extends JFrame {
	private final JPanel contentPane;
	private final JTextField pkgName;
	private final JTextField pkgPrice;
	private final JTextField dietType;
        private final JCheckBox veganCheck;
        private final JCheckBox ketoCheck;
        
        JComboBox<String> breakfastDrink;
        JComboBox<String> breakfastDessert;
        JComboBox<String> breakfastDish;
        JComboBox<String> dinnerDrink;
        JComboBox<String> dinnerDish;
        JComboBox<String> dinnerDessert;
        JComboBox<String> lunchDrink;
        JComboBox<String> lunchDessert;
        JComboBox<String> lunchDish;
        JComboBox<String> AllPkg;
        
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
        int pkgID;
        int adminID;
        String[] allPkgNames ;
        List<Package> allPkgs;
        adminMainPage mainPage;
        Admin currentAdmin;
        
    public updatePackage(Admin currentAdmin){
        this.currentAdmin=currentAdmin;
        adminID = currentAdmin.getUserID();
        mealsSelected= new String[9];
        
        queries = new packageQueries();
        drinks = queries.getAllDrink();
        dishes = queries.getAllDish();
        desserts = queries.getAllDessert();
        allPkgNames = queries.selectAllPackageNames();    
        allPkgs = queries.displayPackages();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Package Name:");
	lblNewLabel_1.setBounds(250, 199, 115, 16);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Price per month:");
	lblNewLabel_2.setBounds(250, 261, 115, 16);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3= new JLabel("Diet Type:");
	lblNewLabel_3.setBounds(250, 229, 83, 16);
	contentPane.add(lblNewLabel_3);


	JLabel lblAddNewMea = new JLabel("Update Package");
	lblAddNewMea.setBounds(272, 86, 230, 64);
	lblAddNewMea.setFont(new Font("GE SS", Font.BOLD, 25));
	lblAddNewMea.setForeground(new Color(153, 102, 0));

	contentPane.add(lblAddNewMea);
	
	pkgName = new JTextField();
	pkgName.setBackground(SystemColor.window);
	pkgName.setBounds(373, 197, 130, 20);
	contentPane.add(pkgName);
	pkgName.setColumns(10);

	
	pkgPrice = new JTextField();
	pkgPrice.setColumns(10);
	pkgPrice.setBackground(SystemColor.window);
	pkgPrice.setBounds(373, 259, 130, 20);
        pkgPrice.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = pkgPrice.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        pkgPrice.setText("");
                        JOptionPane.showMessageDialog(null, "Price must be number!");
                    }
                    catch(Exception ex){
                        pkgPrice.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in Price Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
	contentPane.add(pkgPrice);

	JButton btnNewButton = new JButton("update package");
	btnNewButton.setBackground(new Color(128, 128, 0));
	btnNewButton.setForeground(new Color(143, 188, 143));
	btnNewButton.setBounds(132, 515, 130, 29);
	contentPane.add(btnNewButton);
                btnNewButton.addActionListener( 
                            new ActionListener(){
                  @Override
                     public void actionPerformed(ActionEvent e) {                                                                                     
                    updatePackageButtonActionPerformed(e);
                        }});
                
        veganCheck = new JCheckBox("Vegan");
	veganCheck.setBounds(271, 480, 141, 23);
	contentPane.add(veganCheck);
	
        ketoCheck=new JCheckBox("Keto");
	ketoCheck.setBounds(196, 480, 141, 23);
	contentPane.add(ketoCheck);


	JButton btnCancel = new JButton("Back");
	btnCancel.setForeground(new Color(143, 188, 143));
	btnCancel.setBackground(new Color(128, 128, 0));
	btnCancel.setBounds(270, 515, 117, 29);
	contentPane.add(btnCancel);
	btnCancel.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                adminMainPage page = new adminMainPage( currentAdmin);
                page.setLocationRelativeTo(null);
              page.setVisible(true);
              setVisible(false);
            }
        }
        );

	dietType = new JTextField();
	dietType.setBackground(UIManager.getColor("Button.background"));
	dietType.setBounds(373, 224, 130, 26);
	contentPane.add(dietType);
	dietType.setColumns(10);
	

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
	
	
	JLabel lblNewLabel_6_1 = new JLabel("Choose lunch meals:");
	lblNewLabel_6_1.setBounds(93, 340, 260, 16);
	contentPane.add(lblNewLabel_6_1);
	
	 lunchDish = new JComboBox(dishes);
	lunchDish.setBounds(82, 360, 130, 24);
	contentPane.add(lunchDish);
	
	 lunchDessert = new JComboBox(desserts);
	lunchDessert.setBounds(216, 360, 130, 24);
	contentPane.add(lunchDessert);
	
	 lunchDrink = new JComboBox(drinks);
	lunchDrink.setBounds(348, 360, 130, 24);
	contentPane.add(lunchDrink);
	
	JLabel lblNewLabel_6_2 = new JLabel("Choose dinner meals:");
	lblNewLabel_6_2.setBounds(93, 396, 260, 16);
	contentPane.add(lblNewLabel_6_2);
	
	 dinnerDish = new JComboBox(dishes);
	dinnerDish.setBounds(82, 416, 130, 24);
	contentPane.add(dinnerDish);
	
	 dinnerDessert = new JComboBox(desserts);
	dinnerDessert.setBounds(216, 416, 130, 24);
	contentPane.add(dinnerDessert);
	
	dinnerDrink = new JComboBox(drinks);
	dinnerDrink.setBounds(348, 416, 130, 24);
	contentPane.add(dinnerDrink);
	
	JLabel lblNewLabel_1_1 = new JLabel("Choose Package :");
	lblNewLabel_1_1.setBounds(250, 166, 115, 16);
	contentPane.add(lblNewLabel_1_1);
	
	 AllPkg = new JComboBox(allPkgNames);
	AllPkg.setBounds(373, 162, 129, 27);
	contentPane.add(AllPkg);
	AllPkg.addItemListener(
        new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            PkgComboBoxitemStateChanged(e);
            }
        }
        );
        
	contentPane.add(lblNewLabel);

	}
    
    public void PkgComboBoxitemStateChanged (ItemEvent e){
        
            Package currentPackage ;

            if(e.getStateChange()==ItemEvent.SELECTED){
              veganCheck.setSelected(false);
              ketoCheck.setSelected(false);

        try{
            currentPackage = allPkgs.get(AllPkg.getSelectedIndex());  

            pkgName.setText(currentPackage.getName());
            dietType.setText(currentPackage.getDietType());
            pkgID = currentPackage.getID();
             pkgPrice.setText(""+currentPackage.getPrice());
             if(currentPackage.isVegan()) veganCheck.setSelected(true);
             if(currentPackage.isKeto()) ketoCheck.setSelected(true);
            
             String[] breakfast = currentPackage.getBreakfast();
             String[] lunch = currentPackage.getLunch();
             String[] dinner = currentPackage.getDinner();
            
            selectItemByString(breakfast[0],breakfastDish );
            selectItemByString(breakfast[2],breakfastDessert );
            selectItemByString(breakfast[1],breakfastDrink );

            selectItemByString(lunch[0],lunchDish );
            selectItemByString(lunch[2],lunchDessert );
            selectItemByString(lunch[1],lunchDrink );
 
            selectItemByString(dinner[0],dinnerDish );
            selectItemByString(dinner[2],dinnerDessert );
            selectItemByString(dinner[1],dinnerDrink );
            
        }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
        }
    }
         
    private void selectItemByString(String s, JComboBox<String> x) {
        for (int i=0; i<x.getItemCount(); i++) {
        if (x.getItemAt(i).equals(s)) {
        x.setSelectedIndex(i);
        break;
      }
    }
    return;
  }
         
    public void updatePackageButtonActionPerformed(ActionEvent evt){
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
        
        double price = Double.parseDouble(pkgPrice.getText().trim());
        int result = queries.updatePackage(adminID, pkgName.getText(), price, cal, dietType.getText() ,
        vegan, keto, breakfastDishName, breakfastDrinkName, breakfastDessertName, lunchDishName, lunchDrinkName,
        lunchDessertName, dinnerDishName, dinnerDrinkName, dinnerDessertName, pkgID );

         if (result == 1){
         JOptionPane.showMessageDialog(this, "Package Updated!",
            "Package added successfully", JOptionPane.PLAIN_MESSAGE);
                adminMainPage page = new adminMainPage( currentAdmin);
                page.setLocationRelativeTo(null);
              page.setVisible(true);
              setVisible(false);
         }
      else
         JOptionPane.showMessageDialog(this, "Package not updated!",
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
     
             
         }
    
    


