package com.servlets;

import jakarta.servlet.*;
import java.io.*;

public class GenericServletExample extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("This is servlet using generic servlet.");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1> This is my second servlet using generic servlet. </h1>");
    }
    
}
