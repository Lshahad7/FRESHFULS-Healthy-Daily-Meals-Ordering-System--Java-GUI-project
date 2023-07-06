/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;

/*
 * @author Aseel
 */
public class Meal {
    private int ID, calories;
    private double price;
    private boolean keto, vegan;
    String type; 
    String Mealname;


    public String getMealname() {
        return Mealname;
    }

    public void setMealname(String Mealname) {
        this.Mealname = Mealname;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public Meal(){
        this.keto = false;
        this.vegan = false;
    }
    
    public Meal(int ID, double price, int calories){
        this.ID = ID;
        this.calories = calories;
        this.price = price;
        this.keto = false;
        this.vegan = false;
    }
        public Meal( String Mealname , String type, int calories, boolean keto, boolean vegan, double price){
        setType(type);
        setMealname(Mealname);
        setCalories(calories);
        setPrice(price);
        setKeto(keto);
        setVegan(vegan);

            }
          public Meal(int productID, String Mealname , String type, int calories, boolean keto, boolean vegan, double price){
        setType(type);
        setID(productID);
        setMealname(Mealname);
        setCalories(calories);
        setPrice(price);
        setKeto(keto);
        setVegan(vegan);

            }
      

    public int getID(){ return this.ID; }
    public int getCalories(){ return this.calories; }
    public double getPrice(){ return this.price; }
    public boolean isKeto(){ return this.keto; }
    public boolean isVegan(){ return this.vegan; }
    
    public void setID(int ID) { this.ID = ID; }
    public void setCalories(int calories) { this.calories = calories; }
    public void setPrice(double price) { this.price = price; }
    public void setKeto(boolean keto) { this.keto = keto; }
    public void setVegan(boolean vegan) { this.vegan = vegan; }   
}
