package pro;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Vector;
 
/**
 *
 * @author user
 */
public class SMSS extends HttpServlet {

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
        PrintWriter out = response.getWriter();
          String name = request.getParameter("uname");
            String x = request.getParameter("form_x");
            String y = request.getParameter("form_y");
            System.out.println("1");
        try {
         //   String s[]=request.getParameterValues("id");
            String uid="maxbulksms"; String pwd="12345678"; String phone=""; String msg="";
            String temp = "";
        if ((uid == null) || (uid.length() == 0)) {
            throw new IllegalArgumentException("User ID should be present.");
        }
 
        uid = URLEncoder.encode(uid, "UTF-8");
 
        if ((pwd == null) || (pwd.length() == 0)) {
            throw new IllegalArgumentException("Password should be present.");
        }
        pwd = URLEncoder.encode(pwd, "UTF-8");
       
        if ((phone == null) || (phone.length() == 0)) {
            throw new IllegalArgumentException("At least one phone number should be present.");
        }
        if ((msg == null) || (msg.length() == 0)) {
            throw new IllegalArgumentException("SMS message should be present.");
        }
        msg = URLEncoder.encode(msg, "UTF-8");
 
        Vector numbers = new Vector();
       
        if (phone.indexOf(59) >= 0) {
            String[] pharr = phone.split(";");
            for (String t : pharr) {
                try {
                    numbers.add(Long.valueOf(t));
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Give proper phone numbers.");
                }
            }
        } else {
            try {
                numbers.add(Long.valueOf(phone));
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Give proper phone numbers.");
            }
        }
        
	if (numbers.size() == 0) {
            throw new IllegalArgumentException("At least one proper phone number should be present to send SMS.");
        }
        ///String temp = "";
        String content = "username=" + uid + "&password=" + pwd;
        URL u = new URL("http://www.vnssms.in/quicksms/api.php");
        HttpURLConnection uc = (HttpURLConnection) u.openConnection();
        uc.setDoOutput(true);
        uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
        uc.setRequestProperty("Content-Length", String.valueOf(content.length()));
        uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        uc.setRequestProperty("Accept", "*/*");
        uc.setRequestProperty("Referer", "http://www.vnssms.in/quicksms/index.php");
        uc.setRequestMethod("POST");
        uc.setInstanceFollowRedirects(false);
 
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
        pw.print(content);
        pw.flush();
        pw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
 
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }
         String cookie = uc.getHeaderField("Set-Cookie");
 
        u = null;
        uc = null;
        for (Iterator localIterator = numbers.iterator(); localIterator.hasNext();) {
            long num = ((Long) localIterator.next()).longValue();
 
            content = "custid=undefined&HiddenAction=instantsms&Action=custfrom450000&login=&pass=&MobNo=" + num + "&textArea=" + msg;
           u = new URL("http://www.vnssms.in/quicksms/api.php?username=maxbulksms&password=12345678&to="+num+"&from=SPCATM&message="+msg);
            uc = (HttpURLConnection) u.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
            uc.setRequestProperty("Content-Length", String.valueOf(content.getBytes().length));
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uc.setRequestProperty("Accept", "*/*");
            uc.setRequestProperty("Cookie", cookie);
            uc.setRequestMethod("POST");
            uc.setInstanceFollowRedirects(false);
            pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
            pw.print(content);
            pw.flush();
            pw.close();
            br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            while ((temp = br.readLine()) != null);
            br.close();
            u = null;
            uc = null;
        }
        u = new URL("http://www.vnssms.in/quicksms/index.php");
        uc = (HttpURLConnection) u.openConnection();
        uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
        uc.setRequestProperty("Accept", "*/*");
        uc.setRequestProperty("Cookie", cookie);
        uc.setRequestMethod("GET");
        uc.setInstanceFollowRedirects(false);
        br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        while ((temp = br.readLine()) != null);
        br.close();
        u = null;
        uc = null;
        
                      //  getServletContext().getRequestDispatcher("http://localhost:8080/E-Election/ClickPoint2a.jsp").forward(request, response);
                      
                     // out.print("<table width='100%'><tr width='100%'><td width='100%'><img src='./images/Banner.jpg' width='100%'> <td>   </td></tr></table><center>");
		//out.print("<h2>User registered successfully</h2><br><a href='index.jsp'>Click here to login</a></center>");
            //response.sendRedirect("http://localhost:8080/E-Election/ClickPoint2a.jsp");
             } catch (Exception e) {
            System.out.println("Driver not found" +e);//
        }
       finally {
            out.close();
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
