/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;



/**
 *
 * @author PC1
 */
public class FirstServlet implements Servlet{
    //Life cycle method.
    //1. Init state.
    ServletConfig conf;
    @Override
    public void init(ServletConfig conf)throws ServletException{
        this.conf=conf;
        System.out.println("Creating object.....");
    }
    
    //2. Service 
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
        System.out.println("Servicing......");
        
        //set the content of response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my output from servlet method: </h1>");
        out.println("<h2>Today date is "+new Date().toString()+"</h2>");
    }
    
    //3. Destroy
    @Override
    public void destroy(){
        System.out.println("Going to destroy servlet.");
    }
    
    // Non life cycle methods
    
    @Override
    public ServletConfig getServletConfig(){
        return this.conf;
    } 
    
    @Override
    public String getServletInfo(){
        
        return "This servlet created by Rahul.";
    }
}
