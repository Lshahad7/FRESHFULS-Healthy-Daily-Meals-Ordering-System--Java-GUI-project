/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerService;

/**
 *
 * @author bayanalhumaidan
 */
import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.List;
public class AdminCustService extends JFrame{
    
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int adminID;
    private final JFrame CustServiceFrame;
    private final JTextField complainTF;
    private final JTextField custTF;
    private final JTextField dateTF;
    private final JTextField indexTF;
    private final JTextField nextTF;
    private final JTextField orderTF;
    
    private final JLabel background;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLabel jLabel8;
    private final JLabel jLabel9;
    
    private final JScrollPane jScrollPane1;
    
    private final JButton menuB;
    private final JButton nextB;
    private final JButton backB;
    private final JButton submitB;
    
    private final JTextArea replyTA;
    
    
    private CustomerService currentEntry;
    private List <CustomerService> results;
    private final CustServiceQueries queries;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    // End of variables declaration    
    
    public AdminCustService(Admin currentAdmin) {
        adminID = currentAdmin.getUserID();
        CustServiceFrame= new JFrame();
        complainTF = new JTextField();
        custTF = new JTextField();
        dateTF = new JTextField();
        indexTF = new JTextField();
        nextTF = new JTextField();
        orderTF = new JTextField();
        
        
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();  
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9=new JLabel();   
        
       
        menuB = new JButton();
        nextB = new JButton();
        backB = new JButton();
        submitB = new JButton();
        
        background = new JLabel();
        
        replyTA = new JTextArea();
        
        queries = new CustServiceQueries();
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
    
        
        setLayout(null);

        complainTF.setBackground(new Color(241, 241, 241));
        add(complainTF);
        complainTF.setBounds(230, 370, 190, 30);
        complainTF.setEditable(false);
        
        custTF.setBackground(new Color(241, 241, 241));
        add(custTF);
        custTF.setBounds(230, 270, 190, 30);
        custTF.setEditable(false);
        
        dateTF.setBackground(new Color(241, 241, 241));
        add(dateTF);
        dateTF.setBounds(230, 230, 190, 30);
        dateTF.setEditable(false);
        
        add(indexTF);
        indexTF.setBounds(270, 500, 40, 26);
        indexTF.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    indexTFActionPerformed(evt);
                }
            }
        );
        
        add(nextTF);
        nextTF.setBounds(350, 500, 40, 26);
        nextTF.setEditable(false);
        
        orderTF.setBackground(new Color(241, 241, 241));
        add(orderTF);
        orderTF.setBounds(230, 320, 190, 30);
        orderTF.setEditable(false);
        
        jLabel1.setFont(new Font("Lucida Grande", 0, 14));
        jLabel1.setText("Date:");
        add(jLabel1);
        jLabel1.setBounds(120, 240, 35, 17);
        
        jLabel2.setFont(new Font("Lucida Grande", 0, 14));
        jLabel2.setText("Customer ID:");
        add(jLabel2);
        jLabel2.setBounds(120, 280, 89, 17);
        
        jLabel3.setFont(new Font("Lucida Grande", 0, 14)); 
        jLabel3.setText("Order#:");
        add(jLabel3);
        jLabel3.setBounds(120, 330, 53, 17);
        
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel4.setText("Complain:");
        add(jLabel4);
        jLabel4.setBounds(120, 380, 130, 17);
        
        jLabel5.setFont(new Font("Lucida Grande", 0, 14)); 
        jLabel5.setText("Reply:");
        add(jLabel5);
        jLabel5.setBounds(120, 410, 80, 17);
        
        add(jLabel6);
        jLabel6.setBounds(0, 0, 630, 640);
        
        jLabel7.setFont(new Font("Lucida Grande", 1, 36)); 
        jLabel7.setForeground(new Color(102, 102, 0));
        jLabel7.setText("Admin Page");
        add(jLabel7);
        jLabel7.setBounds(260, 70, 250, 40);
        
        jLabel8.setFont(new Font("Lucida Grande", 2, 18)); 
        jLabel8.setForeground(new Color(102, 102, 0));
        jLabel8.setText("Customer Services");
        add(jLabel8);
        jLabel8.setBounds(260, 100, 250, 40);
        
        jLabel9.setText("of");
        add(jLabel9);
        jLabel9.setBounds(320, 505, 13, 16);
        
        replyTA.setColumns(20);
        replyTA.setRows(5);

        replyTA.setLineWrap(true);
        replyTA.setEditable(false);
        
        jScrollPane1 = new JScrollPane(replyTA);
        add(jScrollPane1);
        jScrollPane1.setBounds(200, 410, 244, 84);
        
        
        menuB.setText("Main Menu");
        add(menuB);
        menuB.setBounds(10, 580, 112, 29);
        menuB.addActionListener(
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
                
        nextB.setText("Next");
        add(nextB);
        nextB.setBounds(330, 530, 85, 29);
        nextB.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               nextActionPerformed(evt);
            } 
         } 
      );
        

        backB.setText("Back");
        add(backB);
        backB.setBounds(220, 530, 85, 29);
        backB.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               backActionPerformed(evt);
            } 
         } 
      );

        submitB.setText("Submit Reply");
        add(submitB);
        submitB.setBounds(450, 460, 110, 29);
        submitB.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    insertReply(evt);
                    AdminCustService frame = new AdminCustService(currentAdmin);
                    frame.setVisible(true); 
                    frame.setLocationRelativeTo(null);
                    dispose();                }
            }
        );
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630,640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);
        background.setIcon(img3);
        add(background);
        background.setBounds(0, 0, 630, 640);
        
        addWindowListener(new WindowAdapter(){  
            public void windowOpened(WindowEvent evt){             
            openWindowEvent();
            }
        });
        
    }  
    private void openWindowEvent(){
      try{
         results = queries.getAllRequest(); 
         numberOfEntries = results.size();
         if (numberOfEntries != 0)
         {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            dateTF.setText(formatter.format(currentEntry.getDate()));
            custTF.setText(""+currentEntry.getCustomerID());
            orderTF.setText(""+currentEntry.getOrderID());
            complainTF.setText(currentEntry.getComplaint());
            replyTA.setText(currentEntry.getReply());
            indexTF.setText(""+ (currentEntryIndex+1));
            nextTF.setText(""+numberOfEntries);
            
            if (currentEntry.getReply()==null)
                replyTA.setEditable(true);
            else
                replyTA.setEditable(false);
         }
         
      }
      catch(Exception e){
             e.printStackTrace();      
      }
      
  }
  
    private void indexTFActionPerformed(ActionEvent evt)
   {
      currentEntryIndex = (Integer.parseInt(indexTF.getText()) - 1);
      if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
            currentEntry = results.get(currentEntryIndex);
            dateTF.setText(formatter.format(currentEntry.getDate()));
            custTF.setText(""+currentEntry.getCustomerID());
            orderTF.setText(""+currentEntry.getOrderID());
            complainTF.setText(currentEntry.getComplaint());
            replyTA.setText(currentEntry.getReply());
            indexTF.setText(""+ (currentEntryIndex+1));
            nextTF.setText(""+numberOfEntries);
            
            if (currentEntry.getReply()==null)
                replyTA.setEditable(true);
            else
                replyTA.setEditable(false);
      
      }  
    }

    private void nextActionPerformed(ActionEvent evt) 
   {
      currentEntryIndex++;      
      if (currentEntryIndex >= numberOfEntries)
         currentEntryIndex = 0;
      
      indexTF.setText("" + (currentEntryIndex + 1));
      indexTFActionPerformed(evt);
   }
   
    private void backActionPerformed(ActionEvent evt)
   {
      currentEntryIndex--;    
      if (currentEntryIndex < 0)
         currentEntryIndex = numberOfEntries - 1;
      
      indexTF.setText("" + (currentEntryIndex + 1));
      indexTFActionPerformed(evt);  
   }
    
    public void insertReply(ActionEvent evt){

        try{
            int orderID = Integer.parseInt(orderTF.getText().trim());        
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to reply to customer# \n"
                    +custTF.getText() + "?", "Confirm Message",JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (confirm == 0){
               Timestamp date = Timestamp.valueOf( dateTF.getText() ) ;
            int result = queries.AdminReply(Integer.parseInt(custTF.getText()), Integer.parseInt(orderTF.getText()), adminID, replyTA.getText());
            if (result == 1)
            JOptionPane.showMessageDialog(this, "Reply sent successfully!","Request sent", JOptionPane.PLAIN_MESSAGE);
            else
            JOptionPane.showMessageDialog(this, "Error:\nCould not send your reply!!","Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error!\nTry again with proper input","Error", JOptionPane.PLAIN_MESSAGE);
        }       
    }
   
    
}