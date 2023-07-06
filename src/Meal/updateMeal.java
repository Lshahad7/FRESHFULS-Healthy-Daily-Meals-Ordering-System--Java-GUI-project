
package Meal;
import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.ArrayList;

import java.awt.event.*;
import java.util.NoSuchElementException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;




public class updateMeal extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;

	
	public updateMeal(Admin currentAdmin) {
            int adminID = currentAdmin.getUserID();
            query = new MealsQueries();
             allMeals= query.selectAllMealsNames();
             
             meals = query.selectAllMeals();
             
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 630, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Meal :");
		lblNewLabel_1.setBounds(120, 222, 100, 16);
		contentPane.add(lblNewLabel_1);
		

		MealcomboBox = new JComboBox(allMeals);
		MealcomboBox.setBounds(232, 218, 166, 27);
		contentPane.add(MealcomboBox);
		MealcomboBox.addItemListener(
                new ItemListener(){
                    @Override
                     public void itemStateChanged (ItemEvent e){ 
                         String type;
                         if(e.getStateChange()==ItemEvent.SELECTED){
                          veganCheck.setSelected(false);
                          ketoCheck.setSelected(false);
                             
                        currentMeal = meals.get(MealcomboBox.getSelectedIndex());                             
                        nameField.setText(currentMeal.getMealname());
                        type = currentMeal.getType();
                         caloriesTF.setText(""+currentMeal.getCalories());
                         if(null != type)
                             switch (type) {
                                case "dish":
                                    dishBtn.setSelected(true);
                                    break;
                                case "drink":
                                    DrinkBtn.setSelected(true);
                                    break;
                                case "dessert":
                                    dessertBtn.setSelected(true);
                                    break;
                                default:
                                    break;
                            }

                        priceTF.setText(""+currentMeal.getPrice());
                         if(currentMeal.isVegan()) veganCheck.setSelected(true);
                         if(currentMeal.isKeto()) ketoCheck.setSelected(true);
                         
                         }
                     }
                    }   
                );
		
		JLabel lblNewLabel_2 = new JLabel("Meal price:");
		lblNewLabel_2.setBounds(120, 331, 83, 16);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_5 = new JLabel("Meal calories:");
		lblNewLabel_5.setBounds(120, 370, 110, 16);
		contentPane.add(lblNewLabel_5);

                
		JLabel lblNewLabel_3= new JLabel("Type:");
		lblNewLabel_3.setBounds(120, 294, 83, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblAddNewMea = new JLabel("Update Meal");
		lblAddNewMea.setBounds(272, 86, 230, 64);
		lblAddNewMea.setFont(new Font("GE SS", Font.BOLD, 25));
		lblAddNewMea.setForeground(new Color(153, 102, 0));

		contentPane.add(lblAddNewMea);
		
		DrinkBtn = new JRadioButton("Drink");
		DrinkBtn.setBounds(197, 290, 141, 23);
		contentPane.add(DrinkBtn);
		
		dishBtn = new JRadioButton("Main dish");
		dishBtn.setBounds(294, 290, 141, 23);
		contentPane.add(dishBtn);
		
		 dessertBtn = new JRadioButton("Dessert");
		dessertBtn.setBounds(397, 290, 141, 23);
		contentPane.add(dessertBtn);
		
                ButtonGroup buttons = new ButtonGroup();
                buttons.add(dishBtn);
                buttons.add(DrinkBtn);
                buttons.add(dessertBtn);
               
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBackground(SystemColor.window);
		priceTF.setBounds(208, 326, 130, 20);
        priceTF.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                String str = priceTF.getText();
                boolean done = false;
                    try{
                        double i = Double.parseDouble(str);
                        done = true;
                    }
                    catch(NumberFormatException exception){
                        priceTF.setText("");
                        JOptionPane.showMessageDialog(null, "Price must be a number!");
                    }
                    catch(Exception ex){
                        priceTF.setText("");
                        JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                "Error Occurred in Price Field", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
		contentPane.add(priceTF);
		
		caloriesTF = new JTextField();
		caloriesTF.setColumns(10);
		caloriesTF.setBackground(SystemColor.window);
		caloriesTF.setBounds(208, 370, 130, 20);
		contentPane.add(caloriesTF);
                caloriesTF.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent e){
                        String str = caloriesTF.getText();
                        boolean done = false;
                            try{
                                int i = Integer.parseInt(str);
                                done = true;
                            }
                            catch(NumberFormatException exception){
                                caloriesTF.setText("");
                                JOptionPane.showMessageDialog(null, "Calories must be a number!");
                            }
                            catch(Exception ex){
                                caloriesTF.setText("");
                                JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                        "Error Occurred in Calories Field", JOptionPane.ERROR_MESSAGE);
                            }
                    }
                });

		 updateBtn = new JButton("update meal");
		updateBtn.setBackground(new Color(128, 128, 0));
		updateBtn.setForeground(new Color(143, 188, 143));
		updateBtn.setBounds(133, 498, 117, 29);
		contentPane.add(updateBtn);
        
                updateBtn.addActionListener( 
                            new ActionListener(){
                                
          @Override
          public void actionPerformed(ActionEvent e) {                                                            
                           

              try{
                  String type1;
                  if ( dishBtn.isSelected())
                      type1 = "dish";
                  if (DrinkBtn.isSelected())
                      type1 = "drink";
                  if (dessertBtn.isSelected())
                      type1 = "dessert";
                  else
                      type1 = "null";
                  
                 
                  boolean vegan = false;
                  if (veganCheck.isSelected())
                      vegan=true;
                  boolean keto = false;
                  if (ketoCheck.isSelected())
                      keto=true;

                int calories = Integer.parseInt(caloriesTF.getText());
                double price = Double.parseDouble(priceTF.getText());
                Meal currentMeal = meals.get(MealcomboBox.getSelectedIndex());
                int productID = currentMeal.getID();
                
                  int result = query.updateMeal(nameField.getText(),productID,type1,calories,price, vegan, keto ,adminID );
                  if (result >0)
                      JOptionPane.showMessageDialog(null, " updated successfully");
                  else
                      JOptionPane.showMessageDialog(null, " cannot apply update process!");
                  }
              catch(NoSuchElementException ex){
                   
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "Wrong Format!!",JOptionPane.ERROR_MESSAGE);
                  } 
                  catch(Exception ex){
                   
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                  } 
          }
                                   });

		 btnCancel = new JButton("Back");
		btnCancel.setForeground(new Color(143, 188, 143));
		btnCancel.setBackground(new Color(128, 128, 0));
		btnCancel.setBounds(271, 498, 117, 29);
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

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBackground(SystemColor.window);
		nameField.setBounds(219, 261, 130, 20);
		contentPane.add(nameField);

                
		JLabel lblNewLabel_2_1 = new JLabel("Meal Name:");
		lblNewLabel_2_1.setBounds(120, 263, 83, 16);
		contentPane.add(lblNewLabel_2_1);
		

		ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
		Image img = imageIcon.getImage();
		Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
		ImageIcon img3 = new ImageIcon(img2);
		
		JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 630, 640);
			lblNewLabel.setIcon(img3);
			
			 ketoCheck = new JCheckBox("Keto");
			ketoCheck.setBounds(240, 430, 128, 23);
			contentPane.add(ketoCheck);
			
			veganCheck = new JCheckBox("Vegan");
			veganCheck.setBounds(170, 430, 128, 23);
			contentPane.add(veganCheck);

			contentPane.add(lblNewLabel);

			
        }
        
	JCheckBox ketoCheck;
	JCheckBox veganCheck;
	JRadioButton dishBtn;
	JRadioButton DrinkBtn;
	JRadioButton dessertBtn;
	JComboBox<String> MealcomboBox;
	JTextField priceTF;
 	JTextField caloriesTF;
       
	JButton updateBtn;
	JButton btnCancel;
        MealsQueries query;
        String[] allMeals;
        ArrayList<Meal> meals;
        Meal currentMeal ;
        

}
