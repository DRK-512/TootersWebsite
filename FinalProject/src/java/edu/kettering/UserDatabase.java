/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.kettering;

import java.sql.*;


//import com.mysql.jdbc.Driver; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
public class UserDatabase {
    
    public boolean CheckUserName(String UserName){
        boolean myResult = false; 
        try{
            myResult = UserQuerry(UserName); 
        } catch (Exception ex){
            myResult = false; 
        }
        return myResult; 
    }
    
    public boolean UserQuerry(String uname) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Driver myDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        
        DriverManager.registerDriver(myDriver);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB", "root", "password"); 
        
        Statement stmt = conn.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
        
        while(rs.next()){
            //System.out.print(rs.getString("id")+" ");
            //System.out.print(rs.getString("uname")+" ");
            //System.out.print(rs.getString("pwd")+" ");
            if(uname.equalsIgnoreCase(rs.getString("uname"))) {
                return true; 
            }
        }
        return false; 
    }
    
    public boolean CheckUserExists(String UserName, String PassWord){
        boolean myResult = false; 
        
        try {
            myResult = QuerryDatabase(UserName, PassWord); 
                  
        }
        catch (Exception ex){
            myResult = false; 
        }
      
        return myResult; 
    }
    
    
    public boolean QuerryDatabase(String uname, String pwd) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // this looks at schemas name, user name, password for sql (if the Schemas was named QWERTY then 
        // instead of SessionManagement we would put QWERTY after localhost:3306
        Driver myDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        
        DriverManager.registerDriver(myDriver);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB", "root", "password"); 
        
        Statement stmt = conn.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
        
        while(rs.next()){
            //System.out.print(rs.getString("id")+" ");
            //System.out.print(rs.getString("uname")+" ");
            //System.out.print(rs.getString("pwd")+" ");
            if(uname.equalsIgnoreCase(rs.getString("uname")) && pwd.equals(rs.getString("pwd"))) {
                return true; 
            }
        }
        return false; 
    }
    
    
    
}
