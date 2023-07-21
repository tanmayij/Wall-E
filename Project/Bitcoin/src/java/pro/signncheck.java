/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.mail;

/**
 *
 * @author RenownTechnologies
 */
public class signncheck extends HttpServlet {

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
            throws ServletException, IOException 
    
      {
        response.setContentType("text/html;charset=UTF-8");

            PrintWriter out = response.getWriter();
            
            String pwd,wd;
            pwd=request.getParameter("pwd");
            wd=request.getParameter("wd");
             int flag=0;
            if(wd.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("12345"))
            {
            
                    response.sendRedirect("admin/dashboard.jsp");
                    flag=9;
            }
             
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement one=con.prepareStatement("select * from tbl_register where walletid='"+wd+"' and pwd='"+pwd+"'");
                ResultSet rs=one.executeQuery();
                while(rs.next())
                {
                                 flag=9;        
                    String id=rs.getString("id");
                    String name=rs.getString("name");
                    String mob=rs.getString("Mobile");
                    String email=rs.getString("email");
                    request.getSession(true).setAttribute("wname", name);
                    request.getSession(true).setAttribute("ownerid", id);
                    request.getSession(true).setAttribute("walletid", wd);
                    request.getSession(true).setAttribute("pwd", pwd);
                    request.getSession(true).setAttribute("mob", mob);
                    request.getSession(true).setAttribute("email", email);
                    RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp?id="+id+"&wid="+wd);
                    rd.include(request, response);
                 }
                }
                catch(Exception ex)
                {
                System.out.println(ex);
                }
               if(flag==0) 
               {
               response.sendRedirect("invalidlogin.jsp");
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
