package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletExample extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("This is get method.");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is get method of my httpServlet</h1>");
    }
}
