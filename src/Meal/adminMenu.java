
package Meal;

import FreshFuls.Admin;
import FreshFuls.adminMainPage;
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

public class adminMenu extends JFrame{
    private int adminID;
    private Admin currentAdmin;
   public adminMenu(Admin currentAdmin){
       this.currentAdmin=currentAdmin;
       initComponents();

        addWindowListener(
         new WindowAdapter() 
         {  public void windowOpened(WindowEvent evt){             
                openWindowEvent();
         }
	});
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
            }
        }
        catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void currentFieldActionPerformed(ActionEvent evt){
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
    
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
        page.setVisible(true);
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
    private JButton backBtn;
    private JPanel jPanel4;
    
    private MealsQueries query =new MealsQueries();
    private Meal currentEntry;
    private List<Meal> menu = query.selectAllMeals();
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
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
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(203, 230, 203));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADMIN MENU", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 24))); // NOI18N
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

        currentField.setEditable(false);
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

        backBtn.setBackground(new java.awt.Color(225, 225, 225));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(prevBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ofLabel)
                    .addComponent(currentField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
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
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn)
                    .addComponent(prevBtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 630));

        pack();
    }
}
