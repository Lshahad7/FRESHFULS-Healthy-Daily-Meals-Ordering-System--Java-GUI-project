/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreshFuls;

import java.util.Date;


public class Admin extends User{
        private double salary;

    public double getSalary() {
        return salary;
    }
    
    public Admin() {
   
    }

    public Admin(double salary, int userID, String password, String fname, String lname,  Date bdate) {
        super(userID, password,fname, lname, bdate);
        this.salary = salary;
    }

  
}
