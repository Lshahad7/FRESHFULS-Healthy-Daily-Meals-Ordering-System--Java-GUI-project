/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreshFuls;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FileHistory {
    FileWriter fileWriter;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    Scanner input;
    
    
public void logInCust(String ID){
        try{
            fileWriter= new FileWriter("History.txt",true);
            fileWriter.write("Sign in Customer: "+ID+" , Date and Time: "+formatter.format(calendar.getTime())+"\n");
            fileWriter.close();
        }catch(SecurityException e){
            JOptionPane.showMessageDialog(null, "Write permission denid", "ERROR",JOptionPane.ERROR_MESSAGE );
            System.exit(1);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error opening file. ", "ERROR",JOptionPane.ERROR_MESSAGE );
            System.exit(1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing. ", "ERROR",JOptionPane.ERROR_MESSAGE );
            } 
        
        }
        
        
    

public void logOutCust(String ID){
        try{
            fileWriter= new FileWriter("History.txt",true); 
            fileWriter.write("Log out Customer: "+ID+" , Date and Time: "+formatter.format(calendar.getTime())+"\n");
            fileWriter.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );
        }
        
        
    }

public void logInAdmin(String ID){
        try{
            fileWriter= new FileWriter("History.txt",true); 
            fileWriter.write("Sign in Admin: "+ID+" , Date and Time: "+formatter.format(calendar.getTime())+"\n");
            fileWriter.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );
        }
        
        
    }

public void logOutAdmin(String ID){
        try{
           fileWriter= new FileWriter("History.txt",true); 
            fileWriter.write("Log out Admin: "+ID+" , Date and Time: "+formatter.format(calendar.getTime())+"\n");
            fileWriter.close();
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );
        }
    }

public void signUpCust(String ID){
        try{
           fileWriter= new FileWriter("History.txt",true); 
            fileWriter.write("Sign up Customer: "+ID+" , Date and Time: "+formatter.format(calendar.getTime())+"\n");
            fileWriter.close();
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );
        }
        
    }

public void readHistory(){
    try{

        String x="";
        input= new Scanner(Paths.get("History.txt"));
        
        while(input.hasNext()){
           x += input.nextLine()+"\n";
        }
        
        String[] buttons = {"reset","OK"};
        JTextArea edit = new JTextArea(x);
        edit.setEditable(false);
        
        int options = JOptionPane.showOptionDialog(null, new JScrollPane(edit), "History",JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[1]);
        
        if(options==0){
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to CLEAR ALL HISTORY?", "Confirm ",JOptionPane.YES_NO_OPTION );
            if(confirm==0){
            fileWriter= new FileWriter("History.txt",false);             
            fileWriter.close();
            }
        }
    }
    catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE );
    }
 
    
    
}

}