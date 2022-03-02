/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kettering;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author root
 */
public class ServletCommonUtility {
    public void RedirectUtility(HttpServletRequest request, HttpServletResponse response, String RedirectURL, 
            String message)throws ServletException, IOException{
            
            request.setAttribute("message", message); 
            ServletContext myLocation = request.getServletContext(); 
            RequestDispatcher myVehicle = myLocation.getRequestDispatcher(RedirectURL); 
            myVehicle.forward(request, response); 
    }
}
