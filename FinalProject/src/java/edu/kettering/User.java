/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kettering;


import java.sql.*;
import java.util.List;
/**
 *
 * @author root
 */
public class User {
   
    
     public void CreateUser(String fname, String lname, String uname, String email, String pwd) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      
        String INSERT_USERS_SQL = "INSERT INTO `FinalProjectDB`.`users` "  +
            "  (id, uname, pwd, firstName, lastName, email, profilePic, Bio) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";
        String defualtPic = "assets/img/characters/DefaultProfilePicture.png"; 
        
        try
        (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB?useSSL=false", "root", "password"); 

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        
        Statement stmt = connection.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
       
        int nextID = getNextID(); 
        
        preparedStatement.setInt(1, nextID);

        preparedStatement.setString(2, uname);
        preparedStatement.setString(3, pwd);
        preparedStatement.setString(4, fname);
        preparedStatement.setString(5, lname);
        preparedStatement.setString(6, email);
        preparedStatement.setString(7, defualtPic);
        preparedStatement.setString(8, "");
        //preparedStatement.setString(7, "assets/img/characters/DefaultProfilePicture.png");
        // Step 3: Execute the query or update query

        System.out.println(preparedStatement);
        int result = preparedStatement.executeUpdate();
        connection.close();
        } catch (Exception ex){

            
            ex.printStackTrace();
  
            // Prints what exception has been thrown
            System.out.println(ex);
            
        }
        
    }
    private int getNextID() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Driver myDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        
        DriverManager.registerDriver(myDriver);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB", "root", "password"); 
        
        Statement stmt = conn.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
        int nextID = 0; 
        
        // now we will get the largest ID in the database
        while(rs.next()){
            if(nextID< Integer.parseInt(rs.getString("id"))) {
                nextID = Integer.parseInt(rs.getString("id")); 
            }
        }
        nextID++; 
        return nextID; 
    }
    
    public void UpdateUser(String fname, String lname, String uname, String email, String pwd, String bio, int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      
        String INSERT_USERS_SQL = "UPDATE `FinalProjectDB`.`users` SET "
                + "`uname` = ?, "
                + "`pwd` = ?, " 
                + " `firstName` = ?, "
                + "`lastName` = ?, "
                + "`email` = ?, " 
                + " `Bio` = ? "
                + "WHERE (`id` = ?);";
        
        try
        (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProjectDB?useSSL=false", "root", "password"); 

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        
        Statement stmt = connection.createStatement(); 
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM FinalProjectDB.users;"); 
       
        int nextID = getNextID(); 
        
        preparedStatement.setString(1, uname);

        preparedStatement.setString(2, pwd);
        preparedStatement.setString(3, fname);
        preparedStatement.setString(4, lname);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, bio);
        preparedStatement.setInt(7, id);

        // Step 3: Execute the query or update query

        System.out.println(preparedStatement);
        int result = preparedStatement.executeUpdate();
        connection.close();
        } catch (Exception ex){

            
            ex.printStackTrace();
  
            // Prints what exception has been thrown
            System.out.println(ex);
            
        }
    }
  
}
