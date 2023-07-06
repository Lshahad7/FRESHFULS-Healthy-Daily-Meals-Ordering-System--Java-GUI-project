/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

/**
 *
 * @author bayanalhumaidan
 */

import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author bayanalhumaidapackage oop_project;
n
 */


public class packageQueries {
    
    private Connection con;    
    private PreparedStatement addNewPackage;
    private PreparedStatement displayPackage;
    private PreparedStatement deletePackage;
    
    private PreparedStatement getAllDishes;
    private PreparedStatement getAllDrinks;
    private PreparedStatement getAllDesserts;
    private PreparedStatement getCaloriesByName;
    private PreparedStatement updatePackage;
    private PreparedStatement selectAllPackageNames;
    private PreparedStatement updatePackage1;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //constructor
    public packageQueries(){
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Restaurant; create=true", "APP", "deitel");
            
            displayPackage =  con.prepareStatement("SELECT * FROM Package");

            getAllDishes = con.prepareStatement("SELECT name FROM MEAL WHERE Type='dish'");
            getAllDrinks = con.prepareStatement("SELECT name FROM MEAL WHERE Type='drink'");
            getAllDesserts = con.prepareStatement("SELECT name FROM MEAL WHERE Type='dessert'");
            
            getCaloriesByName = con.prepareStatement("SELECT calories FROM MEAL WHERE name = ? ");
            
            addNewPackage = con.prepareStatement("INSERT INTO Package " + 
            "(Name, PkgPRICE,  PkgCalories, DietType, Vegan, Keto, Breakfast_Dish ,Breakfast_Drink ,Breakfast_Dessert ,"
                    + "  Lunch_Dish, Lunch_Drink ,Lunch_Dessert,Dinner_Dish,Dinner_Drink, Dinner_Dessert) " + 
            "VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");
            
            deletePackage = con.prepareStatement("DELETE FROM PACKAGE WHERE ProductID= ?");        
            
            selectAllPackageNames = con.prepareStatement("SELECT NAME FROM PACKAGE");
            updatePackage= con.prepareStatement("UPDATE Package SET Name=?, PkgPRICE=?,  PkgCalories=?, DietType=?, Vegan=?, Keto=?,"
                    + " Breakfast_Dish=? ,Breakfast_Drink=? ,Breakfast_Dessert=?, Lunch_Dish=?, Lunch_Drink=? ,Lunch_Dessert=?, "
                    + "Dinner_Dish=?,Dinner_Drink=?, Dinner_Dessert=?"+
                  " WHERE ProductID=?");
            updatePackage1= con.prepareStatement("INSERT INTO EDITS(adminID, ProductID, DateTime) VALUES(?,?,?)");
            deletePackage = con.prepareStatement("DELETE FROM PACKAGE WHERE PRODUCTID=?");
        }
        catch(SQLException e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         System.exit(1);
        }
    }
    
//queries methods
    
    public String[] getAllDish(){
        List<String> results = null;
        ResultSet resultSet = null;
        
        try{
         resultSet = getAllDishes.executeQuery(); 
         results = new ArrayList< String >();
            
         while (resultSet.next())
         {
             results.add(resultSet.getString("Name"));
                 }
        }            
        catch(SQLException e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           
        }      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }
      
        String[] resultArray =   results.toArray(new String[0]);
       return resultArray; 
    }
    
    public String[] getAllDrink(){
        List<String> results = null;
        ResultSet resultSet = null;
        
        try{
         resultSet = getAllDrinks.executeQuery(); 
         results = new ArrayList< String >();
            
         while (resultSet.next())
         {
             results.add(resultSet.getString("Name"));
                 }
        }            
        catch(SQLException e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           
        }      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }
      

        String[] resultArray =   results.toArray(new String[0]);
       return resultArray; 
    }

    public String[] getAllDessert(){
        List<String> results = null;
        ResultSet resultSet = null;
        
        try{
         resultSet = getAllDesserts.executeQuery(); 
         results = new ArrayList< String >();
            
         while (resultSet.next())
         {
             results.add(resultSet.getString("Name"));
                 }
        }            
        catch(SQLException e){
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           
        }      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }

        String[] resultArray =   results.toArray(new String[0]);
       return resultArray; 
    }
    
    public int deletePackage(int productID)  {
        int result =0;
        
        try{
            deletePackage.setInt(1,productID);
           result = deletePackage.executeUpdate();           
        }
            catch (SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
      } 
        
        return result;
        
    }
    
    public int addPackage( String Name, double price, int calories, String dietType,
             boolean vegan, boolean keto, String Breakfast_Dish ,String Breakfast_Drink, String Breakfast_Dessert,
            String Lunch_Dish, String Lunch_Drink , String Lunch_Dessert, String Dinner_Dish,
            String Dinner_Drink,String Dinner_Dessert){    

        int result = 0;
    
    try{
        
      addNewPackage.setString(1, Name) ;
      addNewPackage.setDouble(2, price) ;
      addNewPackage.setInt(3, calories) ;
      addNewPackage.setString(4, dietType) ;
      addNewPackage.setBoolean(5, vegan) ;  
      addNewPackage.setBoolean(6, keto) ;        
      addNewPackage.setString(7, Breakfast_Dish) ;
      addNewPackage.setString(8, Breakfast_Drink) ;
      addNewPackage.setString(9, Breakfast_Dessert) ;
      addNewPackage.setString(10, Lunch_Dish) ;
      addNewPackage.setString(11, Lunch_Drink) ;
      addNewPackage.setString(12, Lunch_Dessert) ;
      addNewPackage.setString(13, Dinner_Dish) ;
      addNewPackage.setString(14, Dinner_Drink) ;  
      addNewPackage.setString(15, Dinner_Dessert) ;  
     
      result = addNewPackage.executeUpdate();
      
    }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
         close();  
    }
        
      return result;  
        
    }
    
     public int updatePackage(int adminID, String Name, double price, int calories, String dietType,
            boolean vegan, boolean keto, String Breakfast_Dish ,String Breakfast_Drink, String Breakfast_Dessert,
            String Lunch_Dish, String Lunch_Drink , String Lunch_Dessert, String Dinner_Dish,
            String Dinner_Drink,String Dinner_Dessert, int ID){
         
         int result=0, result1=0;
         try{
      updatePackage.setString(1, Name) ;
      updatePackage.setDouble(2, price) ;
      updatePackage.setInt(3, calories) ;
      updatePackage.setString(4, dietType) ;
      updatePackage.setBoolean(5, vegan) ;  
      updatePackage.setBoolean(6, keto) ;        
      updatePackage.setString(7, Breakfast_Dish) ;
      updatePackage.setString(8, Breakfast_Drink) ;
      updatePackage.setString(9, Breakfast_Dessert) ;
      updatePackage.setString(10, Lunch_Dish) ;
      updatePackage.setString(11, Lunch_Drink) ;
      updatePackage.setString(12, Lunch_Dessert) ;
      updatePackage.setString(13, Dinner_Dish) ;
      updatePackage.setString(14, Dinner_Drink) ;  
      updatePackage.setString(15, Dinner_Dessert) ;  
      updatePackage.setInt(16, ID) ;  

        Calendar calendar = Calendar.getInstance();
      Timestamp date = Timestamp.valueOf( formatter.format(calendar.getTime())) ;
      updatePackage1.setInt(1,adminID);
      updatePackage1.setInt(2,ID);
      updatePackage1.setTimestamp(3, date );
      result1 = updatePackage1.executeUpdate();
      result = updatePackage.executeUpdate();
                      
         }
            catch (SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
      } 
         return result*result1;
 
     }
             
    public int getCaloriesByName(String name){
        int result = 0;
        ResultSet resultSet = null;
        
            try {
                getCaloriesByName.setString(1, name);
                resultSet = getCaloriesByName.executeQuery(); 
                if(resultSet.next())
                result = resultSet.getInt("Calories");
                            
            } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }                   
      finally
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
      
        
        return result;
            }
  
    public List<Package> displayPackages(){
        List<Package> results = null;
        ResultSet resultSet=null;
        ResultSet rs=null;
        try{
            
            resultSet=displayPackage.executeQuery();
            results=new ArrayList<Package>();
            
            while(resultSet.next()){
                
                String[] breakfast = new String[3];
                breakfast[0] = resultSet.getString("breakfast_dish");
                breakfast[1] = resultSet.getString("breakfast_drink");                                
                breakfast[2] = resultSet.getString("breakfast_dessert");
                
                String[] lunch = new String[3];
                lunch[0] = resultSet.getString("lunch_dish");
                lunch[2] = resultSet.getString("lunch_dessert");
                lunch[1] = resultSet.getString("lunch_drink");
                
                String[] dinner = new String[3];
                dinner[0] = (resultSet.getString("dinner_dish"));
                dinner[2] = (resultSet.getString("dinner_dessert"));
                dinner[1] = (resultSet.getString("dinner_drink"));
                
                results.add(new Package(
                resultSet.getInt("ProductID"), resultSet.getString("Name"), resultSet.getDouble("PkgPrice"),
                        resultSet.getString("DietType"), resultSet.getInt("Pkgcalories"),
                        resultSet.getBoolean("keto"), resultSet.getBoolean("vegan"), breakfast, lunch, dinner));                
                              
            }
            
        }      
        catch (SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
      } 
      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }
            return results;
    }   

    public String[] selectAllPackageNames(){
        List<String> results = null;
        ResultSet resultSet = null;
        
        try{
         resultSet = selectAllPackageNames.executeQuery(); 
         results = new ArrayList< String >();
            
         while (resultSet.next())
         {
             results.add(resultSet.getString("Name"));
                 }
        }         
        catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
           
        }
        finally {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            close();
         }
      }
      
        String[] resultArray =   results.toArray(new String[0]);
       return resultArray; 
    }
        
    
    public int calculateCalories(String[] meals){
        int calories=0;

            for (String meal : meals) {
                calories += getCaloriesByName(meal);
            }
        return calories;
    }

    public void close()
   {
      try 
      {
         con.close();
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
   } 
   
}
