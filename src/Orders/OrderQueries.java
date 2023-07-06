/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orders;

/**
 *
 * @author bayanalhumaidan
 */
import Package.Package;

import Meal.MealLinkedList;
import Meal.MealLinkedList.Node;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class OrderQueries {
    
    private static final String URL = "jdbc:derby://localhost:1527/Restaurant";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";
    
    private Connection connection;
    private PreparedStatement selectAllOrders;
    private PreparedStatement insertNewOrder1;
    private PreparedStatement insertNewOrder2;
    
    private PreparedStatement selectOrdersByCustId;
    
    
    public OrderQueries() {
    
        try {
        
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant; create=true", "APP", "deitel");
                
                selectAllOrders = 
                        connection.prepareStatement("SELECT * FROM ORDERS");
                
                selectOrdersByCustId = 
                        connection.prepareStatement("SELECT * FROM ORDERS WHERE CUSTOMERID = ? ORDER BY DATETIME DESC");

                insertNewOrder1 = 
                        connection.prepareStatement("INSERT INTO ORDERS (CUSTOMERID, TOTAL, PAYMENTMETHOD, DATETIME)"
                                + "VALUES( ? , ? , ? , ?)"); 
                    insertNewOrder2 = 
                        connection.prepareStatement("INSERT INTO ORDER_CONTAINS( ORDERID , PRODUCTID , PRICE , QUANTITY) "
                                + "VALUES( ? , ? , ? , ?)");                        
                        }
        catch (SQLException exc){
                exc.printStackTrace();
                System.exit(1);
        }
    
    } // end of the constructor
    
    
    public List<Order> getAllOrders()
    {
    
    List<Order> result = null;
    ResultSet resultSet = null;
    
    try 
    {
                resultSet = selectAllOrders.executeQuery();
                result = new ArrayList<Order>();
                
                while (resultSet.next())
                {
                    result.add(new Order(
                    resultSet.getInt("ORDERID"),                                                        
                    resultSet.getInt("TOTAL"),
                    resultSet.getInt("CUSTOMERID"),
                    resultSet.getString("PAYMENTMETHOD"),
                    resultSet.getTimestamp("DateTime")
                    ));
                }
    }
    catch (SQLException ex)
    {
         JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    } 
    finally {
                try
                {
                resultSet.close();
                }
                catch (SQLException exc)
                {
                exc.printStackTrace(); 
                close();
                }    
    } // end finally
    
    return result;
    
}
    
    public Order getLastOrderByCustomerID (int CUSTOMERID)
    {
    
    Order result = null;
    ResultSet resultSet = null;
    
    
    try
    {
          selectOrdersByCustId.setInt(1, CUSTOMERID);
           resultSet = selectOrdersByCustId.executeQuery();
                      if (resultSet.next())
                {
                    result = (
                            new Order(
                    resultSet.getInt("ORDERID"),                            
                    resultSet.getInt("TOTAL"),
                    resultSet.getInt("CUSTOMERID"),
                    resultSet.getString("PAYMENTMETHOD"),
                    resultSet.getTimestamp("dateTime")
                    ));
                }

    }
    catch (SQLException exc)
    {
         JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    finally {
                try
                {
                resultSet.close();
                }
                catch (SQLException exc)
                {
                exc.printStackTrace(); 
                close();
                }    
    } // end finally
    
    return result;
    
    }

    public int addOrderPkg(int CustomerID, Package pkg, double Total , String payment , Timestamp datetime){
     int result = 0;
        int result2 = 0;

        try 
        {
            insertNewOrder1.setInt(1, CustomerID);
            insertNewOrder1.setDouble(2, Total);
            insertNewOrder1.setString(3, payment);
            insertNewOrder1.setTimestamp(4, datetime);
                        
            result = insertNewOrder1.executeUpdate();
            
            if (result == 1)
            {
            
           Order o = getLastOrderByCustomerID(CustomerID);
           
           insertNewOrder2.setInt(1 , o.getOrderID());
           insertNewOrder2.setInt(2 , pkg.getID());
           insertNewOrder2.setDouble(3,Total);
           insertNewOrder2.setInt(4,1);
           
           result2 = insertNewOrder2.executeUpdate();
           }
           
            }
           
        
        catch (SQLException exc)
    {
             //   exc.printStackTrace(); 
        JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                close();
    }
        
        
    return result*result2 ;        
        
    }
    
    
    public int addOrder(int CustomerID,  MealLinkedList meals , String payment , Timestamp datetime){
    
        int result = 0;
        int result2 = 0;
        
        try 
        {
            insertNewOrder1.setInt(1, CustomerID);
            insertNewOrder1.setDouble(2, meals.calculateTotal());
            insertNewOrder1.setString(3, payment);
            insertNewOrder1.setTimestamp(4, datetime);
            
            //WORKS
            
            result = insertNewOrder1.executeUpdate();
            
            if (result == 1)
            {
            
            //NOT WORKS
            
           int size = meals.size();
           Node currentEntry = meals.getHead();

           Order o = getLastOrderByCustomerID(CustomerID);

           while(currentEntry!=null){
           
           insertNewOrder2.setInt(1 , o.getOrderID());
           insertNewOrder2.setInt(2 , currentEntry.getData().getID());
           insertNewOrder2.setDouble(3, currentEntry.getPrice());
           insertNewOrder2.setInt(4, currentEntry.getQuantity());
           currentEntry = currentEntry.getNext();
           result2 = insertNewOrder2.executeUpdate();
           
           }
           
            }
           
        }
        catch (SQLException exc)
    {
             //   exc.printStackTrace(); 
        JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                close();
    }
        
        
    return result*result2 ;
    }   

        public List<Order> getOrderByCustomerID (int CUSTOMERID)
    {
    
      List<Order> result = null;
    ResultSet resultSet = null;
    
    
    try
    {
          selectOrdersByCustId.setInt(1, CUSTOMERID);
           resultSet = selectOrdersByCustId.executeQuery();
           
           result = new ArrayList<Order>();
           while (resultSet.next())
                {
                result.add(new Order(
                    resultSet.getInt("OrderID"),                            
                    resultSet.getInt("TOTAL"),
                    resultSet.getInt("CUSTOMERID"),
                    resultSet.getString("PAYMENTMETHOD"),
                    resultSet.getTimestamp("dateTime")                           
                    ));
                }
   
    }
    catch (SQLException ex)
    {
         JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    finally {
                try
                {
                resultSet.close();
                }
                catch (SQLException exc)
                {
                exc.printStackTrace(); 
                close();
                }    
    } // end finally
    
    return result;
    
    }

public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}

    public void close(){
    
        try 
        {
                connection.close();
        }
        catch (SQLException exc)
        {
                exc.printStackTrace(); 
        }
    
    }
    
}