/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

import Meal.Meal;

/**
 *
 * @author bayanalhumaidan
 */
public class Package extends Meal{
    String dietType;
    String Name;
    
    String[] breakfast;
    String[] lunch;
    String[] dinner;
    packageQueries queries = new packageQueries();

    Package() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String[] getBreakfast() {
        return breakfast;
    }

    public String[] getLunch() {
        return lunch;
    }

    public String[] getDinner() {
        return dinner;
    }

    public String getDietType() {
        return dietType;
    }

    public String getName() {
        return Name;
    }

    public Package(int productID, String Name, double price, String dietType, int calories, boolean keto, boolean vegan, String[] breakfast, String[] lunch, String[] dinner ){
       setID(productID);
       this.Name=Name;
       setCalories(calories);
       this.breakfast=breakfast;
       this.lunch=lunch;
       this.dinner=dinner;
       setPrice(price);
       this.dietType=dietType;
       setVegan(vegan);
       setKeto(keto);     
    }

    public Package(int productID, String Name,int calories){
       setID(productID);
       this.Name=Name;
       setCalories(calories);         
     }
    
    public int calculateCalories(String[] meals){
        int calories=0;

            for (String meal : meals) {
                calories += queries.getCaloriesByName(meal);
            }
        return calories;
    }


}
