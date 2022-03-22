/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.kettering;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doPost(request, response); 
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("uname"); 
        String passWord = request.getParameter("pwd"); 
        
        String fName = request.getParameter("fname"); 
        String lName = request.getParameter("lname"); 
        
        String eMail = request.getParameter("email"); 
        String cPass = request.getParameter("cpwd"); 
        
        UserDatabase myDatabase = new UserDatabase(); 
        
        String RedirectURL = "/SignUp.jsp";
        String message = "";  
        
        if(!myDatabase.CheckUserName(userName))
        {

            User newUser = new User(); 
             
            try{
                if(!cPass.equals(passWord)){
                    message = "Your password must match the confirm password"; 
                } else if (userName==null){}
                else {
                    try {
                        newUser.CreateUser(fName, lName, userName, eMail, passWord);
                        message = userName.toUpperCase(); 
                    } catch (Exception ex){
                        message = "DatabaseError"; 
                    }
                    RedirectURL = "/Userhome.jsp";
                    
                }
            } catch (Exception ex){
                message =  ""; 
            }
            
            // clears the cookies before we store into them
            HttpSession mySession = request.getSession(); 
            mySession.invalidate(); 
        
            // Now we store the user into the cookie
            Cookie c = new Cookie("userName", userName); 
            c.setMaxAge(60*60*24*365*2); // set age to 2 years
            c.setPath("/"); // allow access by entire app
            response.addCookie(c); 
        
        } else {
             RedirectURL = "/SignUp.jsp"; 
             message = "This username already exists, please enter a different one"; 
        }
       
        ServletCommonUtility myUtility = new ServletCommonUtility(); 
        myUtility.RedirectUtility(request, response, RedirectURL, message);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
