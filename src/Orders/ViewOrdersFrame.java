/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orders;


import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;


public class ViewOrdersFrame extends JFrame {
    
    private Order currentEntry; // for the entry 
    private OrderQueries OrderQueries; // to create the connection 
    private List <Order> results;
    private int numberOfEntries = 0 ;
    private int currentEntryIndex;
    
    
    private JLabel productIDLable;
    private JTextArea productsTextField;
    private JLabel customerIDLable;
    private JTextField customerIDTextField;
    private JLabel TotalLable;
    private JTextField TotalTextField;
    private JLabel paymentLable;
    private JTextField paymentTextField;
    private JTextField indexTextField; 
    private JTextField maxTextField;
    private JTextField queryTextField;
    private JTextField orderIDField;

    private JButton browseButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton queryButton;
    private JButton backButton;
    
    private JLabel ofLabel;
    private JLabel queryLabel;
    private JLabel orderIDLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;


    public ViewOrdersFrame(Admin currentAdmin){
    
        super("View Customers Orders | Admin Page");
        
    
        OrderQueries = new OrderQueries();
        
        navigatePanel = new JPanel();
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField =  new JTextField(2);
        nextButton = new JButton();
        
    
        orderIDField = new JTextField();
        orderIDLabel = new JLabel();
        displayPanel = new JPanel();
        productIDLable = new JLabel();
        productsTextField = new JTextArea();
        
        customerIDLable = new JLabel();
        customerIDTextField = new JTextField();
        TotalLable = new JLabel();
        TotalTextField = new JTextField();
        paymentLable = new JLabel();
        paymentTextField = new JTextField();
        
        
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(10);
        queryButton = new JButton();
        browseButton = new JButton();
        getContentPane().setBackground(new java.awt.Color(203, 230, 203));

        getContentPane().setBackground(new Color(203, 230, 203)); 
        queryPanel.setBackground(new Color(203, 230, 203)); 
        displayPanel.setBackground(new Color(203, 230, 203)); 
        navigatePanel.setBackground(new Color(203, 230, 203)); 
        
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setBounds(100,100,630,640);
        setResizable(true);

        //************ the beganing of navigatePanel Defenetion ************
        
        navigatePanel.setLayout(new BoxLayout(navigatePanel , BoxLayout.X_AXIS));
        previousButton.setText("Previous");
        previousButton.setEnabled(false);
        
        previousButton.addActionListener(
        new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
            previousButtonActionPerformed(evt);
            }
        
        }
        
        );// end of addActionListener method "ananoymus class"
        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        navigatePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, navigatePanel.getMinimumSize().height));
        queryPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, queryPanel.getMinimumSize().height));
        displayPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, displayPanel.getMaximumSize().height));
        
        indexTextField.setHorizontalAlignment(JTextField.CENTER);
        
        indexTextField.addActionListener(
            new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
            indexTextFieldActionPerformed(evt);
            }
        
        }    
        
        );// end of addActionListener method "ananoymus class"
        navigatePanel.add(indexTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        ofLabel.setText("of");
        navigatePanel.add(ofLabel);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        maxTextField.setHorizontalAlignment(JTextField.CENTER);
        maxTextField.setEditable(false);
        navigatePanel.add(maxTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(
        
                new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
            nextButtondActionPerformed(evt);
            }
        
        } 
        
        );// end of addActionListener method "ananoymus class"
        
        navigatePanel.add(nextButton);
        add(navigatePanel);
        
        //************ End navigatePanel Defenetion ************
        
        ///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///
        
        //************ the beganing of displayPanel Defenetion ************
        
        displayPanel.setLayout(new GridLayout(5 , 2 , 5, 3));
        
        orderIDField = new JTextField();
        orderIDLabel.setText("Order ID = ");
        orderIDField.setEditable(false);
        displayPanel.add(orderIDLabel);
        displayPanel.add(orderIDField);
        
        displayPanel.setSize(400, 500);
        productIDLable.setText("Products = ");
        displayPanel.add(productIDLable);
         JScrollPane scroll = new JScrollPane(productsTextField);
            scroll.setBounds(150, 255, 300, 50);                     
            displayPanel.add(scroll);            
       
        productsTextField.setLineWrap(true);
        productsTextField.setEditable(false);
        
        customerIDLable.setText("Customer ID = ");
        displayPanel.add(customerIDLable);
        displayPanel.add(customerIDTextField);
        customerIDTextField.setEditable(false);
        
        TotalLable.setText("Total  = ");
        displayPanel.add(TotalLable);
        displayPanel.add(TotalTextField);
        TotalTextField.setEditable(false);
        
        paymentLable.setText("Payment Method  = ");
        displayPanel.add(paymentLable);
        displayPanel.add(paymentTextField);
        paymentTextField.setEditable(false);
        add(displayPanel);
         
        //************ End displayPanel Defenetion ************
        
        ///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///
        
        //************ the beganing of queryPanel Defenetion ************


        queryPanel.setLayout(new BoxLayout(queryPanel , BoxLayout.X_AXIS));        
        queryPanel.setBorder(BorderFactory.createTitledBorder("Find The Orders That Belong To Specific Customer "));
        queryLabel.setText("Customer ID = ");
        queryPanel.add(Box.createHorizontalStrut(5));
        queryPanel.add(queryLabel);
        queryPanel.add(Box.createHorizontalStrut(10));
        queryPanel.add(queryTextField);
        queryPanel.add(Box.createHorizontalStrut(10));       
        queryButton.setText("Find");
        queryButton.addActionListener(
                
                new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
            queryButtonActionPerformed(evt);
            }
        
        } 
        
        );// end of addActionListener method "ananoymus class"
        
        queryPanel.add(queryButton);
        queryPanel.add(Box.createHorizontalStrut(5));
        add(queryPanel);
        
        

        //************ End queryPanel Defenetion ************
        
        ///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///
        
       browseButton.setText("Retrive All The Orders");
       browseButton.addActionListener(
       
               new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
            browseButtonActionPerformed(evt);
            }
        
        } 
        
        );// end of addActionListener method "ananoymus class"
       
       add(browseButton);
       backButton = new JButton("Back");
       add(backButton);
      backButton.addActionListener(
       
               new ActionListener()
        {
        
            public void actionPerformed(ActionEvent evt)
            {
                setVisible(false);
                adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
                page.setVisible(true);
            }
        } 
        
        );
               displayPanel.setSize(300, 500);

       addWindowListener(
       
               new WindowAdapter()
               {
                   public void windowClosing(WindowEvent evt)
                   {
                   
                       OrderQueries.close();
                       System.exit(0);
                       
                   }
               }
       );
       
    
       setVisible(true);
        
    }//end of the constructor
    
    
    private void previousButtonActionPerformed (ActionEvent evt)
    {
    
        currentEntryIndex--;
        
        if (currentEntryIndex < 0)
            currentEntryIndex = numberOfEntries - 1;
        
        indexTextField.setText(" " + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
        
    }
    
    private void nextButtondActionPerformed(ActionEvent evt)
    {
        currentEntryIndex++;
        if (currentEntryIndex >= numberOfEntries) 
            currentEntryIndex = 0 ;
        
        indexTextField.setText(" " + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
    
    }
    
    private void queryButtonActionPerformed (ActionEvent evt)
    {
        try{
        int i = Integer.parseInt(queryTextField.getText().trim());

        results =  OrderQueries.getOrderByCustomerID(i);
        
        numberOfEntries = results.size();
        
        if (numberOfEntries != 0)
        {
           currentEntryIndex = 0 ;
           currentEntry = results.get(currentEntryIndex);
         int OrderID = currentEntry.getOrderID();
            orderIDField.setText(""+currentEntry.getOrderID());
           productsTextField.setText(currentEntry.getProductsByOrderID(OrderID)); //customerIDTextField
           customerIDTextField.setText("" + currentEntry.getCUSTOMERID());
           TotalTextField.setText("" + currentEntry.getTOTAL());
           paymentTextField.setText("" + currentEntry.getPAYMENTMETHOD());
           indexTextField.setText("" + (currentEntryIndex + 1));
           maxTextField.setText("" + numberOfEntries);
           nextButton.setEnabled(true);
           previousButton.setEnabled(true);
         
        }
        else {
        browseButtonActionPerformed(evt);
        JOptionPane.showMessageDialog(null, "No orders with this customer ID");
        }
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter valid number", "Error in query field", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    
    
    private void indexTextFieldActionPerformed(ActionEvent evt)
    {
    try{
        currentEntryIndex = 
                (Integer.parseInt(indexTextField.getText().trim()) - 1);
        
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
        {
        
           currentEntry = results.get(currentEntryIndex);
         int OrderID = currentEntry.getOrderID();
            orderIDField.setText(""+currentEntry.getOrderID());
        
            
           productsTextField.setText(currentEntry.getProductsByOrderID(OrderID)); 
           
           customerIDTextField.setText("" + currentEntry.getCUSTOMERID());
           TotalTextField.setText("" + currentEntry.getTOTAL());
           paymentTextField.setText("" + currentEntry.getPAYMENTMETHOD());
           indexTextField.setText("" + (currentEntryIndex + 1));
           maxTextField.setText("" + numberOfEntries);
           
        }else
        JOptionPane.showMessageDialog(null, "Please enter valid number", "Error in current field", JOptionPane.ERROR_MESSAGE);
        
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter a number", "Error in current field", JOptionPane.ERROR_MESSAGE); 
}   
    }
    
    
    
    
    private void browseButtonActionPerformed (ActionEvent evt)
    {
    
        try
        {
            results = OrderQueries.getAllOrders();
            numberOfEntries = results.size();
            if (numberOfEntries != 0)
        {
           currentEntryIndex = 0 ;
           currentEntry = results.get(currentEntryIndex);
         int OrderID = currentEntry.getOrderID();
          
            orderIDField.setText(""+currentEntry.getOrderID());
           productsTextField.setText(currentEntry.getProductsByOrderID(OrderID));
           customerIDTextField.setText("" + currentEntry.getCUSTOMERID());
           TotalTextField.setText("" + currentEntry.getTOTAL());
           paymentTextField.setText("" + currentEntry.getPAYMENTMETHOD());
           indexTextField.setText("" + (currentEntryIndex + 1));
           maxTextField.setText("" + numberOfEntries);
           nextButton.setEnabled(true);
           previousButton.setEnabled(true);
         

        }
        }catch (Exception e)
        {
              JOptionPane.showMessageDialog(this, e.getMessage() , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        
    }
//    


} // end of ViewOrdersFrame class