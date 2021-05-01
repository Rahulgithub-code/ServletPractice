/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC1
 */
public class RegisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Welcome to Register servlet</h1>");
        //getParameter for getting value from name attribute.
        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String email = req.getParameter("user_email");
        String gender = req.getParameter("user_gender");
        String course = req.getParameter("user_course");
        String cond = req.getParameter("condition");
        //out.println(cond);

        if (cond != null) {
            out.println("<h2>Name : " + name + "</h2>");
            out.println("<h2>Email : " + email + "</h2>");
            out.println("<h2>Gender : " + gender + "</h2>");
            out.println("<h2>Course : " + course + "</h2>");
            
            // Forword requestDispatcher to another servlet.
            RequestDispatcher rd = req.getRequestDispatcher("success");
            rd.forward(req, res);
        } else {
            out.println("<h2>You have not accepted term and conditions</h2>");
            /*    The RequestDispatcher interface provides the facility of dispatching 
                  the request to another resource it may be html, 
                  servlet or jsp. This interface can also be used to include 
                  the content of another resource also. 
                  It is one of the way of servlet collaboration.
             */
            //ResquestDispatcher used for include index.html(another html) as a output.
            //get a object of ResquestDispatcher from HttpServletRequest
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
    }

}
