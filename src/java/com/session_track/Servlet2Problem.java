/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session_track;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


/**
 *
 * @author PC1
 */
public class Servlet2Problem extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2Problem</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //getting cookie's from client browser
            Cookie[] cookies = request.getCookies();
            
            boolean flag = false;
            String name="";
            if(cookies==null){
                out.println("<h1>You are a new user go to home page and submit your name</h1>");
            }else{
                for(Cookie c: cookies){
                    String temp_name=c.getName();
                    if(temp_name.equals("user_name")){
                        flag=true;
                        name=c.getValue();
                    }
                }
            }
            if(flag){
                out.println("<h1>Hello, "+name+" Welcome back to my website... </h1>");
            out.println("<h1>Thank you</h1>");
            }else{
                out.println("<p style=\"font-size: 25px\"  >Http is a stateless protocol , that's why server can't remember name on second request. <p>");
            out.println("<p style=\"font-size: 25px\">We can use - <b>Cookies, URL rewriting, Hidden form field and HttpSession</b>"
                    + " for resolving the stateless problem. </p>");
            }
            //Geting name value from URL using URL rewriting.
            String url_name = request.getParameter("user_name");
            out.println("<h2 style='color:red'>Welcome back "+name+"</h2>");
            
            //Geting name value from Field using hidden form.
            String url_field_name = request.getParameter("user_field_name");
            out.println("<h2 style='color:blue'>Welcome back "+url_field_name+"</h2>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
