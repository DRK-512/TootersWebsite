/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kettering;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class UserFind {
    
    private String uname = ""; 
    private String pwd = ""; 
    private String fName = ""; 
    private String lName = ""; 
    private String email = ""; 
    private String pPic = ""; 
    private String Bio = ""; 
    private String uNum = ""; 

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }


 public static ArrayList<UserFind> getUserList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        Driver myDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        
        DriverManager.registerDriver(myDriver);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB", "root", "password"); 
        
        Statement stmt = conn.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
        
        
        ArrayList<UserFind> uList = new ArrayList<UserFind>(); 
        
        while(rs.next()){
            UserFind u = new UserFind(); 
            u.setuNum(rs.getString("id"));
            u.setUname(rs.getString("uname")); 
            u.setPwd(rs.getString("pwd")); 
            u.setfName(rs.getString("firstName"));
            u.setlName(rs.getString("lastName")); 
            u.setEmail(rs.getString("email")); 
            u.setpPic(rs.getString("profilePic"));
            u.setBio(rs.getString("Bio")); 
            
            uList.add(u); 
            
        }
        return uList; 
    }
 
    public static UserFind getUser(String userName) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        Driver myDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        
        DriverManager.registerDriver(myDriver);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB", "root", "password"); 
        
        Statement stmt = conn.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
        
        
        UserFind user = new UserFind(); 
        
        while(rs.next()){
            if(rs.getString("uname").equals(userName)){
            UserFind u = new UserFind(); 
                u.setuNum(rs.getString("id"));
                u.setUname(rs.getString("uname")); 
                u.setPwd(rs.getString("pwd")); 
                u.setfName(rs.getString("firstName"));
                u.setlName(rs.getString("lastName")); 
                u.setEmail(rs.getString("email")); 
                u.setpPic(rs.getString("profilePic"));
                u.setBio(rs.getString("Bio")); 
                return u; 
            }
            
        }
        return null; 
        
    }
}