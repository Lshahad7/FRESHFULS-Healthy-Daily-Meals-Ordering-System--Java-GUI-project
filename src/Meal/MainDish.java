/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;

public class MainDish extends Meal {
    private String name;
    
    MainDish(){
        setKeto(false);
        setVegan(false);
    }
    
    MainDish(int ID, String name, double price, int calories){
        setID(ID);
        this.name = name;
        setCalories(calories);
        setPrice(price);
        setKeto(false);
        setVegan(false);
    }
        public MainDish( String name,String type, int calories, boolean keto, boolean vegan, double price){
         setType(type);
        this.name = name;
        setCalories(calories);
        setPrice(price);
        setKeto(keto);
        setVegan(vegan);
  
            
        }


    
    public void setName(String name){ this.name = name; }
    public String getName(){ return this.name; }
}
