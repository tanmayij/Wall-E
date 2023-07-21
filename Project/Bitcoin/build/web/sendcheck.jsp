 <%@page import="java.sql.*"%>
<%
                  String name=(String)session.getAttribute("wname");
                  String walletid=(String)session.getAttribute("walletid");
                  String noc="0";//(String)session.getAttribute("noc");
                   String anoc="0";
                   anoc=request.getParameter("anoc");
                   String awdid=request.getParameter("anoc");
                  
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement one=con.prepareStatement("select sum(noofcoins) from tbl_coins where status=1 and walletid='"+walletid+"'");
                System.out.print("select sum(noofcoins) from tbl_coins where status=1 and walletid='"+walletid+"'");
                ResultSet rs=one.executeQuery();
                while(rs.next())
                {
                      
                    noc=""+rs.getInt(1);
                                        
                     
                 }
                }
                catch(Exception ex)
                {
                System.out.println(ex);
                }
            int a=0;int n=0;
            a=Integer.parseInt(anoc);
            n=Integer.parseInt(noc);
            if(a>n)
            {
            response.sendRedirect("send2.jsp");
            }
            else
            {
            response.sendRedirect("send3.jsp?noc="+anoc+"&wdid="+awdid);
            }
                   %>