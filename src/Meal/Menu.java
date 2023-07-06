/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;

import FreshFuls.Customer;
import FreshFuls.customerMainPage;
import Orders.OrderingFrame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Aseel
 */

public class Menu extends JFrame {
     int customerID;
     Customer customer;
    public Menu(Customer customer) {
        this.customer=customer;
        customerID = customer.getUserID();
        cart = new MealLinkedList();
        
     
        
        addWindowListener(
         new WindowAdapter() 
         {  public void windowOpened(WindowEvent evt){             
                openWindowEvent();
         }
	});
       initComponents();

    }
    
    private void openWindowEvent(){
        try{
            query = new MealsQueries();
            menu = query.selectAllMeals();
            numberOfEntries = menu.size();
            
            if (numberOfEntries != 0){
                currentEntryIndex = 0;
                currentEntry = menu.get(currentEntryIndex);
                nameOutputLabel.setText("" + currentEntry.getMealname());
                typeOutputLabel.setText(currentEntry.getType());
                calOutputLabel.setText("" + currentEntry.getCalories());
                ketoOutputLabel.setText(String.format("%sSuitable for Keto",
                                       (currentEntry.isKeto() ? "" : "Not ")));
                veganOutputLabel.setText(String.format("%sSuitable for Vegan",
                                       (currentEntry.isVegan() ? "" : "Not ")));
                priceOutputLabel.setText("" + currentEntry.getPrice());
                
                currentField.setText(""+ (currentEntryIndex+1));
                totalField.setText(""+numberOfEntries);
                quantityField.setText("" + (quantity = 0));
            }
        }
        catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void currentFieldActionPerformed(ActionEvent evt){
        try{
        currentEntryIndex = 
         (Integer.parseInt(currentField.getText()) - 1);
      
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
            currentEntry = menu.get(currentEntryIndex);
            nameOutputLabel.setText("" + currentEntry.getMealname());
            typeOutputLabel.setText(currentEntry.getType());
            calOutputLabel.setText("" + currentEntry.getCalories());
            ketoOutputLabel.setText(String.format("%sSuitable for Keto",
                                   (currentEntry.isKeto() ? "" : "Not ")));
            veganOutputLabel.setText(String.format("%sSuitable for Vegan",
                                   (currentEntry.isVegan() ? "" : "Not ")));
            priceOutputLabel.setText("" + currentEntry.getPrice());

            currentField.setText(""+ (currentEntryIndex+1));
            totalField.setText("" + numberOfEntries);
            quantityField.setText("" + (quantity = 0));
            cartInfo.setText("");
        }else
        JOptionPane.showMessageDialog(null, "Please enter valid number", "Error in current field", JOptionPane.ERROR_MESSAGE);
        
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter a number", "Error in current field", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void nextBtnActionPerformed(ActionEvent evt) {
        currentEntryIndex++;      
        if (currentEntryIndex >= numberOfEntries)
            currentEntryIndex = 0;
      
        currentField.setText("" + (currentEntryIndex + 1));
        currentFieldActionPerformed(evt);
    }

    private void prevBtn1ActionPerformed(ActionEvent evt) {
        currentEntryIndex--;    
        if (currentEntryIndex < 0)
            currentEntryIndex = numberOfEntries - 1;
      
        currentField.setText("" + (currentEntryIndex + 1));
        currentFieldActionPerformed(evt);
    }
    
    private void lessBtnActionPerformed(ActionEvent evt) {
        if(quantity != 0){
            quantity--;
            quantityField.setText(""+ quantity);
            quantityFieldActionPerformed(evt);
        }
    } 
    
    private void moreBtnActionPerformed(ActionEvent evt) {
        if(quantity < 20){
            quantity++;
            quantityField.setText(""+ quantity);
            quantityFieldActionPerformed(evt);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Dear customer, you can only get 20 of the same meal in one order.", 
                                "Maximum Quantity Reached", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void quantityFieldActionPerformed(ActionEvent evt) {
        quantityField.setText(""+ quantity);
    }
    
    private void addToCartBtnActionPerformed(ActionEvent evt) {
        cartInfo.setText("");
        quantity = (Integer.parseInt(quantityField.getText()));
        if(quantity != 0){
            cartAction = cart.findNode(currentEntry, quantity);
            switch(cartAction){
                case 1:
                    cartInfo.setText("Quantity updated successfuly");
                    break;
                case 2:
                    cartInfo.setText("Already exist");
                    break;
                case 3:{
                    cart.addFirst(currentEntry, quantity);
                    quantityField.setText("" + (quantity = 0));
                    cartInfo.setText("Added successfuly");
                    break;
            } }   
        }
        else
            cartInfo.setText("Quantity not specified");
    } 
    
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
                customerMainPage frame = new customerMainPage(customer);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                setVisible(false);        
    }
    
    private void viewOrderbtnActionPerformed(java.awt.event.ActionEvent evt) {  
        OrderingFrame frame = new OrderingFrame(customer, cart);    
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setVisible(false);
    }

    private JLabel Calories;
    private JLabel Keto;
    private JLabel Name;
    private JLabel Price;
    private JLabel Type;
    private JLabel Vegan;
    private JLabel calOutputLabel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel ketoOutputLabel;
    private JLabel nameOutputLabel;
    private JButton nextBtn;
    private JButton prevBtn1;
    private JLabel priceOutputLabel;
    private JLabel typeOutputLabel;
    private JLabel veganOutputLabel;
    private JTextField currentField;
    private JLabel ofLabel;
    private JTextField totalField;
    private JPanel orderPanel;
    private JTextField quantityField;
    private JButton moreBtn;
    private JButton lessBtn;
    private JButton addToCartBtn;
    private JLabel cartInfo;
    private JButton backBtn;
    private JButton viewOrderbtn;
    
    private MealsQueries query = new MealsQueries();
    private Meal currentEntry;
    private List<Meal> menu = query.selectAllMeals();
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private int quantity = 0;
    private MealLinkedList cart;
    private int cartAction = 0;
    
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        Calories = new javax.swing.JLabel();
        Keto = new javax.swing.JLabel();
        Vegan = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        nameOutputLabel = new javax.swing.JLabel();
        typeOutputLabel = new javax.swing.JLabel();
        calOutputLabel = new javax.swing.JLabel();
        ketoOutputLabel = new javax.swing.JLabel();
        veganOutputLabel = new javax.swing.JLabel();
        priceOutputLabel = new javax.swing.JLabel();
        prevBtn1 = new javax.swing.JButton();
        currentField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        ofLabel = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        lessBtn = new javax.swing.JButton();
        moreBtn = new javax.swing.JButton();
        addToCartBtn = new javax.swing.JButton();
        quantityField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        cartInfo = new javax.swing.JLabel();
        viewOrderbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(203, 230, 203));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 24))); // NOI18N
        jPanel1.setName("MENU"); // NOI18N

        Name.setText("Name: ");

        Type.setText("Type:");

        Calories.setText("Calories: ");

        Keto.setText("Keto: ");

        Vegan.setText("Vegan: ");

        Price.setText("Price: ");

        nextBtn.setBackground(new java.awt.Color(225, 225, 225));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        nameOutputLabel.setText("?");

        typeOutputLabel.setText("?");

        calOutputLabel.setText("?");

        ketoOutputLabel.setText("?");

        veganOutputLabel.setText("?");

        priceOutputLabel.setText("?");

        prevBtn1.setBackground(new java.awt.Color(225, 225, 225));
        prevBtn1.setText("Prev");
        prevBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtn1ActionPerformed(evt);
            }
        });

        currentField.setEditable(true);
        currentField.setBackground(new java.awt.Color(255, 255, 255));
        currentField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        currentField.setMinimumSize(new java.awt.Dimension(10, 10));
        currentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentFieldActionPerformed(evt);
            }
        });

        totalField.setEditable(false);
        totalField.setBackground(new java.awt.Color(255, 255, 255));
        totalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ofLabel.setText("of");

        orderPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        lessBtn.setBackground(new java.awt.Color(225, 225, 225));
        lessBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lessBtn.setText("-");
        lessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessBtnActionPerformed(evt);
            }
        });

        moreBtn.setBackground(new java.awt.Color(225, 225, 225));
        moreBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        moreBtn.setText("+");
        moreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreBtnActionPerformed(evt);
            }
        });

        addToCartBtn.setBackground(new java.awt.Color(225, 225, 225));
        addToCartBtn.setText("Add to cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        quantityField.setEditable(false);
        quantityField.setBackground(new java.awt.Color(255, 255, 255));
        quantityField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quantityField.setMinimumSize(new java.awt.Dimension(10, 10));
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lessBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(addToCartBtn)
                .addGap(26, 26, 26))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addToCartBtn)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lessBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setBackground(new java.awt.Color(225, 225, 225));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        viewOrderbtn.setBackground(new java.awt.Color(225, 225, 225));
        viewOrderbtn.setText("View Order");
        viewOrderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewOrderbtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ofLabel)
                                .addGap(18, 18, 18)
                                .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Name)
                                    .addComponent(Type)
                                    .addComponent(Calories)
                                    .addComponent(Keto)
                                    .addComponent(Price)
                                    .addComponent(Vegan))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ketoOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(veganOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(prevBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(cartInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ofLabel)
                    .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn)
                    .addComponent(prevBtn1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calories, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Keto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ketoOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vegan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(veganOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceOutputLabel))
                .addGap(18, 18, 18)
                .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(viewOrderbtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 630));

        pack();
    }
    

}

