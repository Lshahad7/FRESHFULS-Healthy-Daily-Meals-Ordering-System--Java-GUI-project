/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orders;
import Meal.Meal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author bayanalhumaidan
 */
public class Order {
    
   private int TOTAL; 
   private int OrderID;

   private int CUSTOMERID;
   private String PAYMENTMETHOD;
   private Timestamp dateTime;
   
   private Meal[] products;
   
   private Package pkg;
   private PreparedStatement selectProductsByOrderID;
   private PreparedStatement selectMealsByProductID;
    private PreparedStatement selectPkgByProductID;
  
 Connection connection;
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public Order() {
    }
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getOrderID() {
        return OrderID;
    }
     public Order(int total , int CustomerID ,String payment_Method ) {
         setTotal(total);
         setCustomerID(CustomerID);
         setPayment_Method(payment_Method);
     }
     
       public Order(int total , int CustomerID ,String payment_Method,Timestamp dateTime  ) {
         setTotal(total);
         setCustomerID(CustomerID);
         setPayment_Method(payment_Method);
         setDateTime(dateTime);
     }
     
      public Order(int OrderID, int total , int CustomerID ,String payment_Method,Timestamp dateTime  ) {
         setOrderID(OrderID);
          setTotal(total);
         setCustomerID(CustomerID);
         setPayment_Method(payment_Method);
         setDateTime(dateTime);
     }

      public Order( int total , int CustomerID ,String payment_Method,Timestamp dateTime, Meal[] products ) {
          setTotal(total);
         setCustomerID(CustomerID);
        this.products =products;
         setPayment_Method(payment_Method);
         setDateTime(dateTime);
     }
         
    public String getProductsByOrderID(int orderid){
            String products="";
        
        try{
             ResultSet resultSet = null;
             connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant; create=true", "APP", "deitel");
             
            selectProductsByOrderID =
                     connection.prepareStatement("SELECT * FROM ORDER_CONTAINS WHERE ORDERID=?");
             
            selectProductsByOrderID.setInt(1,orderid);
                 
                 resultSet = selectProductsByOrderID.executeQuery();
                 
             while(resultSet.next()){
                String name = getNameByID(resultSet.getInt("ProductID"));
                products+= resultSet.getInt("quantity")+" "+ name+": "+resultSet.getDouble("Price")+"SR\n";
                }
                 
             } catch (SQLException ex) {
                 Logger.getLogger(OrderQueries.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             return products;
    }

    
    public String getNameByID(int productID){
        String productNames = "" ;
            try{
              ResultSet resultSet = null;
              ResultSet resultSet1 = null;
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant; create=true", "APP", "deitel");
                
                selectMealsByProductID=
                        connection.prepareStatement("SELECT name FROM MEAL WHERE PRODUCTID=?");
                selectPkgByProductID =
                        connection.prepareStatement("SELECT NAME FROM PACKAGE WHERE PRODUCTID=?");
                
                
                    selectMealsByProductID.setInt(1,productID);
                    resultSet=  selectMealsByProductID.executeQuery();  
                    
                    if(resultSet.next())
                    productNames =resultSet.getString("Name");
                    
                    else {
                    selectPkgByProductID.setInt(1,productID);
                    resultSet1 = selectPkgByProductID.executeQuery();
                    if(resultSet1.next())
                    productNames =resultSet1.getString("Name");
                        
                  }
              }
               catch (SQLException ex) {
                    ex.getMessage();
               }
                catch (Exception ex) {
                    ex.getMessage();
                    }
                   
        return productNames;
        
    }


    public void setTotal(int total) {
        this.TOTAL = total;
    }

    public void setCustomerID(int CustomerID) {
        this.CUSTOMERID = CustomerID;
    }


    public void setPayment_Method(String payment_Method) {
        this.PAYMENTMETHOD = payment_Method;
    }   
    
    public int getTOTAL() {
        return TOTAL;
    }

    public int getCUSTOMERID() {
        return CUSTOMERID;
    }

    
    public String getPAYMENTMETHOD() {
        return PAYMENTMETHOD;
    }
    
  
    
}