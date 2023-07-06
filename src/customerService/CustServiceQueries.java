/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerService;
import java.sql.*;


import java.util.ArrayList;
import java.util.List;

public class CustServiceQueries {
    final String DATABASE_URL = "jdbc:derby://localhost:1527/Restaurant";
    private  Connection connection;
    private PreparedStatement InsertCustService;
    private PreparedStatement DisplayAdmin_CustService;
    private PreparedStatement InsertReply;
    private PreparedStatement duplicated_Order;
    
    public CustServiceQueries(){
            try{
            connection = DriverManager.getConnection(DATABASE_URL, "APP", "deitel"); 
                InsertCustService = connection.prepareStatement("INSERT INTO customer_service(CUSTOMERID,ORDERID,Date_and_Time,Complaint) VALUES(?,?,?,?)");
                DisplayAdmin_CustService = connection.prepareStatement("SELECT * FROM customer_service");
                InsertReply = connection.prepareStatement("UPDATE customer_service SET reply=?, AdminID=? ,checked=True WHERE orderID=? AND customerID=?");
                duplicated_Order = connection.prepareStatement("SELECT *FROM customer_service WHERE customerID=? AND orderID=?");
            }
            catch (SQLException sqlException){                                                                  
                sqlException.printStackTrace();
            }
    }

    public int CustomerService(int custID,int orderID, Timestamp date, String Comp){
        int result=0;
        try{
            InsertCustService.setInt(1, custID);
            InsertCustService.setInt(2, orderID);
            InsertCustService.setTimestamp(3, date);
            InsertCustService.setString(4, Comp);
            result = InsertCustService.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();         
        } 
        return result;
    }
    
    public List <CustomerService> getAllRequest(){
        List <CustomerService> results=null;
        ResultSet resultSet=null;
        try{
            resultSet =DisplayAdmin_CustService.executeQuery();
            results= new ArrayList<CustomerService> ();
            while(resultSet.next()){
                Timestamp ts = resultSet.getTimestamp("Date_and_Time");
                Date date=new Date(ts.getTime());
                results.add(new CustomerService(
                        resultSet.getInt("CustomerID"),
                        resultSet.getInt("OrderID"),
                        resultSet.getBoolean("Checked"),
                        date,
                        resultSet.getString("Complaint"),
                        resultSet.getString("Reply")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            } 
            catch (SQLException sqlException){
                sqlException.printStackTrace();         
                close();
            }
        }
        return results;
    }
    
    public int AdminReply(int custID,int orderID,int adminID, String reply){
        int result=0;
        try{
            InsertReply.setString(1, reply);
            InsertReply.setInt(2, adminID);
            InsertReply.setInt(3, orderID);
            InsertReply.setInt(4, custID);
            result = InsertReply.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();         
        } 
        return result;
    }
    
    public void close(){
        try{
            connection.close();
        } 
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        } 
    }
    
    public boolean duplicate (int custID, int orderID){
        ResultSet resultSet = null;
        boolean value=true ;
        try{
            duplicated_Order.setInt(1,custID);
            duplicated_Order.setInt(2,orderID);
            resultSet =duplicated_Order.executeQuery();
            if (resultSet.next()) 
                value=false; 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            } 
            catch (SQLException sqlException){
                sqlException.printStackTrace();         
                close();
            }
        }
        return value;
    }
}

