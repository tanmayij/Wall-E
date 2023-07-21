/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.mail;

/**
 *
 * @author David
 */
public class Register extends HttpServlet {

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
            
            String name,pass,mobile,email,address,type,state,country;
            name=request.getParameter("T1");
            pass=request.getParameter("Password");
            mobile=request.getParameter("mobile");
            email=request.getParameter("Email");
            address=request.getParameter("Address");
            state=request.getParameter("State");
            country=request.getParameter("Country");
            String userkey="";
            for(int i=0;i<email.length();i++)
            {
                userkey+=email.charAt(i);
                if(i==2)
                {
                    break;
                }
            }
              for(int i=0;i<name.length();i++)
            {
                userkey+=name.charAt(i);
                if(i==1)
                {
                    break;
                }
            }
            Random rr=new Random();
            String uk=userkey;
            userkey="";
            int key1=rr.nextInt(99999);
            int key2=rr.nextInt(99999);
            int key3=rr.nextInt(99999);
            userkey+=key1;
            userkey+="-"+key2;
            userkey+="-"+key3;
            System.out.println("This is User Key   "+uk+"-"+userkey);
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement one=con.prepareStatement("insert into tbl_register(name,pwd,mobile,email,address,state,country,walletid,dt_created,status)values('"+name+"','"+pass+"','"+mobile+"','"+email+"','"+address+"','"+state+"','"+country+"','"+uk+"-"+userkey+"',now(),1)");
                one.executeUpdate(); 
                
                //---------------------mail part ----------------------//
                String em[]= new String[1];
                String subject="Wallet Credentials";
                String message="Name  : "+name
                            +"\nWallet - ID   : "+uk+"-"+userkey
                            +"\nPassword       : "+pass;
                String fr="danithoneap";   //with out @gmail.com
                String pw="dani@123";		      // sender password
                em[0]=email;
                mail mmm=new mail();
                mmm.sendFromGMail(fr, pw, em, subject, message);
                System.out.println("email "+em[0]);
                //-----------------completed mail part --------------------//
                 try
                {
               NewClass n=new NewClass();
               n.send("maxbulksms", "12345678", mobile, message);
                }
                catch(Exception ex)
                {
                System.out.println(ex);
                }
                out.println("<script type=\"text/javascript\">"); 			
                out.println("alert(\"Successfully registered\")");
                out.println("</script>");
                
                RequestDispatcher rd=request.getRequestDispatcher("signupsucess.jsp");
                rd.include(request, response);
            }
            catch (ClassNotFoundException | SQLException e) 
            { 
                System.out.println(e);
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
