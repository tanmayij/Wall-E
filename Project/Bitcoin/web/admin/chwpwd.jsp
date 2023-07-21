<%@page import="java.sql.*"%>
<%@page import="pro.*"%>
<%@page import="mail.mail"%>
<%
    String pwd=request.getParameter("pwd");
    String pwd1=request.getParameter("pwd2");
    String walletid=(String)session.getAttribute("walletid");
    int flag=0;
    String uname="";
    
     try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement one=con.prepareStatement("select * from tbl_register where pwd='"+pwd+"' and walletid='"+walletid+"'");
                ResultSet rs=one.executeQuery();
                while(rs.next())
                {
                   flag=9;
                    
                 }
                if(flag==9)
                {
                   
                    PreparedStatement one1=con.prepareStatement("update tbl_register set pwd='"+pwd1+"' where walletid='"+walletid+"'");
                    one1.executeUpdate();
                    request.getSession(true).setAttribute("pwd", pwd1);
                    response.sendRedirect("changepwdsucess.jsp");
                }
                else
                {
                response.sendRedirect("changepwd.jsp");
                }
                }
     
                catch(Exception ex)
                {
                System.out.println(ex);
                }  
%>