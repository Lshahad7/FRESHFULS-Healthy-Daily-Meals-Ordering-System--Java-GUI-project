/**
 *
 * @author Aseel
 */

package Meal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import FreshFuls.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addMeal extends JFrame{
    

    private final JPanel contentPane;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField caloriesField;
    private final MealsQueries query;
    private String type;
    JRadioButton drinkButton;
    JRadioButton dishButton;
    JRadioButton dessertButton;
    private boolean keto;
    JRadioButton yesKeto;
    JRadioButton noKeto;
    private boolean vegan;
    JRadioButton yesVegan;
    JRadioButton noVegan;
    JButton addMealButton;
    
    adminMainPage mainPage;
    
    public addMeal(Admin currentAdmin) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
		
        
	JLabel lblNewLabel_1 = new JLabel("Meal Name:");
	lblNewLabel_1.setBounds(120, 252, 83, 16);
	contentPane.add(lblNewLabel_1);
		
	JLabel lblNewLabel_2 = new JLabel("Meal price:");
	lblNewLabel_2.setBounds(120, 331, 83, 16);
	contentPane.add(lblNewLabel_2);
		
	JLabel lblNewLabel_3= new JLabel("Type:");
	lblNewLabel_3.setBounds(120, 291, 83, 16);
	contentPane.add(lblNewLabel_3);

	JLabel lblNewLabel_4 = new JLabel("Is it keto?");
	lblNewLabel_4.setBounds(120, 372, 83, 16);
	contentPane.add(lblNewLabel_4);
                
	JLabel lblNewLabel_5 = new JLabel("Is it vegan?");
	lblNewLabel_5.setBounds(120, 412, 83, 16);
	contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Calories:");
	lblNewLabel_6.setBounds(120, 445, 83, 16);
	contentPane.add(lblNewLabel_6);
        
	JLabel lblAddNewMea = new JLabel("Add New Meal");
	lblAddNewMea.setBounds(272, 86, 230, 64);
	lblAddNewMea.setFont(new Font("GE SS", Font.BOLD, 25));
	lblAddNewMea.setForeground(new Color(153, 102, 0));

	contentPane.add(lblAddNewMea);
		
	nameField = new JTextField();
	nameField.setBackground(SystemColor.window);
	nameField.setBounds(208, 247, 130, 20);
	contentPane.add(nameField);
	nameField.setColumns(10);
		
	drinkButton = new JRadioButton("Drink");
	drinkButton.setBounds(197, 287, 141, 23);
        
	contentPane.add(drinkButton);
		
	dishButton = new JRadioButton("Dish");
	dishButton.setBounds(294, 287, 141, 23);
	contentPane.add(dishButton);
		
	dessertButton = new JRadioButton("Dessert");
	dessertButton.setBounds(397, 287, 141, 23);
	contentPane.add(dessertButton);
        
        typeButtonHandler typeHandler = new typeButtonHandler();
	drinkButton.addActionListener(typeHandler);
        dishButton.addActionListener(typeHandler);
        dessertButton.addActionListener(typeHandler);
        
        ButtonGroup typesBtns = new ButtonGroup();
        typesBtns.add(drinkButton);
        typesBtns.add(dishButton);
        typesBtns.add(dessertButton);
        
	priceField = new JTextField();
	priceField.setColumns(10);
	priceField.setBackground(SystemColor.window);
	priceField.setBounds(208, 326, 130, 20);
        priceField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = priceField.getText();
                boolean done = false;
                    try{
                        double i = Double.parseDouble(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        priceField.setText("");
                        JOptionPane.showMessageDialog(null, "Price must be a number!");
                    }
                    catch(Exception ex){
                        priceField.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in Price Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
	contentPane.add(priceField);
	
	yesKeto = new JRadioButton("Yes");
	yesKeto.setBounds(197, 368, 141, 23);
	contentPane.add(yesKeto);
		
	noKeto = new JRadioButton("No");
	noKeto.setBounds(272, 368, 141, 23);
	contentPane.add(noKeto);
        
        ButtonGroup keto = new ButtonGroup();
        keto.add(yesKeto);
        keto.add(noKeto);
        
        ketoButtonHandler ketoHandler = new ketoButtonHandler();
        yesKeto.addActionListener(ketoHandler);
        noKeto.addActionListener(ketoHandler);
		
	yesVegan = new JRadioButton("Yes");
	yesVegan.setBounds(197, 405, 141, 23);
	contentPane.add(yesVegan);
		
	noVegan = new JRadioButton("No");
	noVegan.setBounds(272, 405, 141, 23);
	contentPane.add(noVegan);
        
        ButtonGroup vegenBtn = new ButtonGroup();
        vegenBtn.add(yesVegan);
        vegenBtn.add(noVegan);
        
        ButtonGroup ketoBtn = new ButtonGroup();
        ketoBtn.add(noKeto);
        ketoBtn.add(yesKeto);
        
        vegenButtonHandler vegenHandler = new vegenButtonHandler();
        yesVegan.addActionListener(vegenHandler);
        noVegan.addActionListener(vegenHandler);
        
        caloriesField = new JTextField();
	caloriesField.setColumns(10);
	caloriesField.setBackground(SystemColor.window);
	caloriesField.setBounds(208, 445, 130, 20);
        caloriesField.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = caloriesField.getText();
                boolean done = false;
                    try{
                        int i = Integer.parseInt(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        caloriesField.setText("");
                        JOptionPane.showMessageDialog(null, "Calories must be a number!");
                    }
                    catch(Exception ex){
                        caloriesField.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in Calories Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
	contentPane.add(caloriesField);
        
	 addMealButton = new JButton("Add meal");
	addMealButton.setBackground(new Color(128, 128, 0));
	addMealButton.setForeground(new Color(143, 188, 143));
	addMealButton.setBounds(133, 498, 117, 29);
	contentPane.add(addMealButton);

	JButton btnCancel = new JButton("Back");
	btnCancel.setForeground(new Color(143, 188, 143));
	btnCancel.setBackground(new Color(128, 128, 0));
	btnCancel.setBounds(271, 498, 117, 29);
	contentPane.add(btnCancel);
	btnCancel.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt) {
                        mainPage = new adminMainPage( currentAdmin);
                        mainPage.setLocationRelativeTo(null);
                        mainPage.setVisible(true);
                        setVisible(false);
                }}
        );
        
       
        try{
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
            Image img = imageIcon.getImage();
            Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
            ImageIcon img3 = new ImageIcon(img2);
            contentPane.setLayout(null);
            
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setBounds(0, 0, 630,640);
            lblNewLabel.setIcon(img3);
            contentPane.add(lblNewLabel);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "The image location is null", 
                                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        query = new MealsQueries();
        
        addMealButtonHandler addHandler = new addMealButtonHandler();
        addMealButton.addActionListener(addHandler);
  
    
    
    }
    
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }


    private class ketoButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent KetoEvt) {
            if(KetoEvt.getSource() == yesKeto)
                keto = true;
            else if (KetoEvt.getSource() == noKeto)
                keto = false;
            else
                JOptionPane.showMessageDialog(null, "Keto status not determined!",
                        "Error", JOptionPane.ERROR_MESSAGE );   
        }
    }
    
    private class vegenButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent vegenEvt) {
            if(vegenEvt.getSource() == yesVegan)
                vegan = true;
            else if (vegenEvt.getSource() == noVegan)
                vegan = false;
            else
                JOptionPane.showMessageDialog(null, "Vegen status not determined!",
                        "Error", JOptionPane.ERROR_MESSAGE );   
        }
    }
    
    private class typeButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent typeEvt) {
            if(typeEvt.getSource() == dishButton)
                type = "dish";
            else if (typeEvt.getSource() == drinkButton)
                type = "drink";
            else if (typeEvt.getSource() == dessertButton)
                type = "dessert";
            else
                JOptionPane.showMessageDialog(null, "Type is not determined!",
                        "Error", JOptionPane.ERROR_MESSAGE );   
        }
    }
    
    private class addMealButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent typeEvt) {
        try{
            double price = Double.parseDouble(priceField.getText().trim());
            int calories = Integer.parseInt(caloriesField.getText());
            
            int result = query.AddMeal(nameField.getText(), type, 
                    calories, vegan, keto, price);
            
            if(result == 1)
                JOptionPane.showMessageDialog(null, "Meal added successfully!",
                        "", JOptionPane.PLAIN_MESSAGE );
            else
                JOptionPane.showMessageDialog(null, "Failed to add meal!",
                        "", JOptionPane.ERROR_MESSAGE );
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        }
    }
}
