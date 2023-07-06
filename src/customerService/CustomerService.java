/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerService;

/**
 *
 * @author bayanalhumaidan
 */
import java.util.Date;

public class CustomerService {
    int CustomerID;
    int OrderID;
    int AdminID;
    boolean checked;
    Date date;
    String Complaint;
    String Reply;
    //this constructor used in customer page
    public CustomerService(int CustomerID, int OrderID, Date date, String Complaint){
       this.CustomerID= CustomerID;
       this.OrderID=OrderID;
       this.date=date;
       this.Complaint=Complaint;
       this.Reply=Reply;
    }
    //this constructor used in Admin page
    public CustomerService(int CustomerID,int OrderID,boolean checked, Date date, String Complaint, String Reply){
       this.CustomerID = CustomerID;
       this.OrderID = OrderID;
       this.checked=checked;
       this.date=date;
       this.Complaint=Complaint;
       this.Reply=Reply;
    }
    //Gettors
    public int getCustomerID() {
        return CustomerID;
    }
    
    public int getOrderID() {
        return OrderID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public boolean isChecked() {
        return checked;
    }

    public Date getDate() {
        return date;
    }

    public String getComplaint() {
        return Complaint;
    }

    public String getReply() {
        return Reply;
    }
}