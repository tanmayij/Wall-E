<%@page import="java.sql.*"%>
<%@page import="pro.*"%>
<%@page import="mail.mail"%>
<%
    String email=request.getParameter("email");
    String phonenum=request.getParameter("phonenum");
    int flag=0;
    String uname="";
    String pwd="";
     try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement one=con.prepareStatement("select * from tbl_register where email='"+email+"' and Mobile='"+phonenum+"'");
                ResultSet rs=one.executeQuery();
                while(rs.next())
                {
                   flag=9; 
                   uname=rs.getString(2);
                   pwd=rs.getString(4);
                 }
                if(flag==9)
                {
                NewClass c=new NewClass();
                String msg="Your Wallet ID: "+uname+", Password: "+pwd;
                c.send("maxbulksms", "12345678", phonenum,msg);
                String em[]= new String[1];
                String subject="Wallet Credentials";
                String message=""+"\nWallet - ID   : "+uname+"-"+"\nPassword  : "+pwd;
                
                String fr="danithoneap";   //with out @gmail.com
                String pw="dani@123";		      // sender password
                em[0]=email;
                mail mmm=new mail();
                mmm.sendFromGMail(fr, pw, em, subject, message);
                response.sendRedirect("forgotpasswordsends.jsp");
                }
                else
                {
                response.sendRedirect("invalidforgotpassword.jsp");
                }
                }
     
                catch(Exception ex)
                {
                System.out.println(ex);
                }  
%>