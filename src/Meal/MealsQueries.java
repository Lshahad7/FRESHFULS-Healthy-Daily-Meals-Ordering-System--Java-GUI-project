/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class MealsQueries {
    private static final String URL = "jdbc:derby://localhost:1527/Restaurant";
    private static final String USERNAME = "APP";
    private static final String PASSWORD = "deitel";
    
    private Connection connection;
    private PreparedStatement selectAllMeals;
    private PreparedStatement insertNewMeal;
    private PreparedStatement updateMeal;
    private PreparedStatement deleteMeal;
    private PreparedStatement selectAllMealNames;
    private PreparedStatement updates;
    
    public MealsQueries(){
        try{
            connection = 
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            //select all entries in Meal table
            selectAllMeals = connection.prepareStatement("SELECT * FROM Meal");
            
            selectAllMealNames = connection.prepareStatement("SELECT name FROM Meal");
           
            //insert a new meal in Meal table
            insertNewMeal = connection.prepareStatement(
                    "INSERT INTO Meal"+
                    "(Name, Type, Calories, Vegan, Keto, Price)"+
                    "VALUES (?, ?, ?, ?, ?, ?)");
                deleteMeal =connection.prepareStatement("DELETE FROM MEAL WHERE NAME= ? ");
                updateMeal =connection.prepareStatement("UPDATE Meal SET Name=?,Type=?,Price=?,Calories=?,Vegan=?,Keto=? WHERE Name=?");
                updates = connection.prepareStatement("INSERT INTO EDITS(adminID, ProductID, DateTime) VALUES(?,?,?)");
        
        }
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    public void close(){
        try{
            connection.close();
        }
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int AddMeal(String Name, String Type, int Calories , 
                       boolean Vegan , boolean Keto, double Price){
        
        int result = 0;
        try{
            insertNewMeal.setString(1, Name);
            insertNewMeal.setString(2, Type);
            insertNewMeal.setInt(3, Calories);
            insertNewMeal.setBoolean(4, Vegan);
            insertNewMeal.setBoolean(5, Keto);
            insertNewMeal.setDouble(6, Price);
            
            result = insertNewMeal.executeUpdate();
        }
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                close();
        }
        
        return result;
    }

    public String[] selectAllMealsNames(){
        List<String> results = null;
        ResultSet resultSet = null;
        
        try{
         resultSet = selectAllMealNames.executeQuery(); 
         results = new ArrayList< String >();
            
         while (resultSet.next())
         {
             results.add(resultSet.getString("Name"));
                 }
        }            
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
           
        }      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException ex)
         {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }
      
        String[] resultArray =   results.toArray(new String[0]);
       return resultArray; 
    }
   
    public int  DeleteMeal ( String x) throws SQLException{
    int result=0;
          try {

    deleteMeal.setString(1, x);
    result = deleteMeal.executeUpdate();
    }catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    } finally {
            if (deleteMeal != null) {
                deleteMeal.close();
            }
        }
          return result;
    }
      
    public int  updateMeal (String Name,int productID, String Type, int Calories, double price ,Boolean Vegan ,Boolean Keto, int adminID) throws SQLException{
      
         
              int result=0;
    try{

           updateMeal.setString(1, Name);
           updateMeal.setString(2, Type);
           updateMeal.setDouble(3,price);
           updateMeal.setInt(4, Calories);
           updateMeal.setBoolean(5, Vegan);
           updateMeal.setBoolean(6, Keto);
           updateMeal.setString(7, Name);
           
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Timestamp date = Timestamp.valueOf( formatter.format(calendar.getTime())) ;
           updates.setInt(1, adminID);
           updates.setInt(2, productID);
           updates.setTimestamp(3, date );
       
        int result1 = updateMeal.executeUpdate();
        int result2 = updates.executeUpdate();
        result = result1 * result2;
    }
    catch (SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
      } 
         return result;
}

    public ArrayList<Meal> selectAllMeals(){
        ArrayList<Meal> menu = new ArrayList();
        ResultSet resultSet = null;
    
        try{
            resultSet = selectAllMeals.executeQuery();
      
            while(resultSet.next()){
                    menu.add(new Meal(
                        resultSet.getInt("ProductID"),    
                        resultSet.getString("Name"),
                        resultSet.getString("Type"),
                        resultSet.getInt("Calories"),
                        resultSet.getBoolean("Vegan"),
                        resultSet.getBoolean("Keto"),
                        resultSet.getDouble("Price"))
                    );   
                }            
        }
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        finally{
            try{
                resultSet.close();
            }
            catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                close();
            }
        }               
        return menu;
    }

     
        
}