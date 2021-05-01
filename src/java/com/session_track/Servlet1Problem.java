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
public class Servlet1Problem extends HttpServlet {

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
            out.println("<title>Servlet Servlet1Problem</title>");
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("name");

            //Solution 1:- Session tracking Solution with the help of Cookie class.
            //creating object of cookie from cookie class present in jakarta.servlet.http
            Cookie c = new Cookie("user_name", name);
            
            // add cookie in client browser with the help of HttpServletRequest
            response.addCookie(c);
            
            out.println("<h1>Hello, " + name + " Welcome to my website... </h1>");
            out.println("<h1><a href='Servlet2Problem'>Go to Servlet 2 (Cookie)</h1>");
            
            //Solution 2 :- Session tracking solution with the help of URL rewriting
            out.println("<h1><a href='Servlet2Problem?user_name="+name+"'>Go to Servlet 2 (URL Rewriting)</h1>");
            
            //Solution 3 :- Session tracking solution with the help of Hidden form field
            out.println("<form action='Servlet2Problem'>"
                    + "<input type='hidden' name='user_field_name' value='"+name+"' />"
                    + "<button style='font-size:25px' type='submit'>Go to servlet 2 (Hidden form field)</button>"
                    + "</form>");
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
