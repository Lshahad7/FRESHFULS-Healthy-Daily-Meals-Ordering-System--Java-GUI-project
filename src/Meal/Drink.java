/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meal;
/*
 * @author Aseel
 */
public class Drink extends Meal {
    private String name;
    
    Drink(){
        setKeto(false);
        setVegan(false);
    }
    
    Drink(int ID, String name, double price, int calories){
        setID(ID);
        this.name = name;
        setCalories(calories);
        setPrice(price);
        setKeto(false);
        setVegan(false);
    }
            public Drink( String name,String type, int calories, boolean keto, boolean vegan, double price){
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
