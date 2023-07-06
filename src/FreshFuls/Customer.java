
package FreshFuls;

import java.util.Date;


public class Customer extends User {
        private String address;
        private char gender;
        
    public Customer() {
   
    }

    public Customer(String address, int userID, String paaword,String fname, String lname, Date date) {
        super(userID, paaword,fname,lname, date);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
}
