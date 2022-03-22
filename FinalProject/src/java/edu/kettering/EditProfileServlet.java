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
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/editprofile"})
public class EditProfileServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
     
        
        String RedirectURL = "/EditProfile.jsp"; 
        String message = request.getParameter("uname");   
       
        if(message==null){
            
            Cookie[] cookies = request.getCookies(); 
            String cookieName = "userName"; 
            
            for(Cookie cookie: cookies){
                if(cookieName.equals(cookie.getName())){
                    message = cookie.getValue(); 
                }
            }
        } 
        
        try {
            UserFind user = new UserFind().getUser(message);
            request.setAttribute("user", user); 
            request.setAttribute("userName", message.toUpperCase()); 
        }catch(Exception e){
            message = "ERROR"; 
        }
        
        message = message.toUpperCase(); 
        
        ServletCommonUtility myUtility = new ServletCommonUtility(); 
        myUtility.RedirectUtility(request, response, RedirectURL, message);
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
        
        String bio = request.getParameter("bio"); 
        
        UserFind oldUser = new UserFind(); 
        
        String RedirectURL = "/Profile.jsp";
        String message=null;   
        int id = 0; 
        
        if(message==null){
            
            Cookie[] cookies = request.getCookies(); 
            String cookieName = "userName"; 
            
            for(Cookie cookie: cookies){
                if(cookieName.equals(cookie.getName())){
                    message = cookie.getValue(); 
                }
            }
        } 
        
         
        try {
            // message holds the username that is currently in the cookie
            // if we update the username we will run into trouble if we dont use it
            oldUser = new UserFind().getUser(message);
            
            id = Integer.parseInt(oldUser.getuNum()); 
           
       
        } catch (Exception e){}
        
       
        
        try {
            if(cPass.equals(passWord)){
                User user = new User(); 
               
                user.UpdateUser(fName, lName, userName, eMail, passWord, bio, id);
                
                oldUser.setfName(fName); 
                oldUser.setlName(lName);
                oldUser.setUname(userName);
                oldUser.setEmail(eMail);
                oldUser.setPwd(passWord);
                oldUser.setBio(bio);
               
                request.setAttribute("user", oldUser); 
            
            } else {
                RedirectURL = "/EditProfile.jsp";
                message = "Password and Confirm Password do not match, please retype them"; 
                UserFind user = new UserFind().getUser(message);
                request.setAttribute("user", user); 
            }
            
        }catch(Exception e){
            message = "ERROR"; 
        }
        
        // Now we set the new username into the cookie
        try{
            // If we update the username, we must also update the cookies
            HttpSession mySession = request.getSession(); 
            mySession.invalidate(); 
            
            Cookie c = new Cookie("userName", oldUser.getUname()); 
            c.setMaxAge(60*60*24*365*2); // set age to 2 years
            c.setPath("/"); // allow access by entire app
            response.addCookie(c); 
        }catch(Exception ex){}
        
        message = oldUser.getUname().toUpperCase(); 
        
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
