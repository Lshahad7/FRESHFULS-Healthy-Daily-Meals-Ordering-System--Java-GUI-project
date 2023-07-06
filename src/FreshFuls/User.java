/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreshFuls;

import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shahad
 */
public class User {
    private int userID;
    private String fname;
    private String lname;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    private String password;
    private Date date;

    public User(int userID, String password,String fname, String lname, Date date) {
        this.userID = userID;
        this.password = password;
        this.date = date;
        this.fname=fname;
        this.lname=lname;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPaaword() {
        return password;
    }

    public void setPaaword(String paaword) {
        this.password = paaword;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User() {
    }
    
}
