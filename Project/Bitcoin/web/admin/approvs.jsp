<!DOCTYPE html><%@page import="java.sql.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
   
    <title>Bitcoin: A Peer-to-Peer Electronic Cash System </title>


    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="assets2/css/bootstrap.min.css" >    
    <!-- Main Style -->
    <link rel="stylesheet" type="text/css" href="assets2/css/main.css">
    <!-- Responsive Style -->
    <link rel="stylesheet" type="text/css" href="assets2/css/responsive.css">
    <!-- Fonts -->
    <link rel="stylesheet" type="text/css" href="assets2/fonts/font-awesome.min.css">
    <!-- Icon -->
    <link rel="stylesheet" type="text/css" href="assets2/fonts/simple-line-icons.css"> 
    <!-- Slicknav -->
    <link rel="stylesheet" type="text/css" href="assets2/css/slicknav.css">
    <!-- Nivo Lightbox -->
    <link rel="stylesheet" type="text/css" href="assets2/css/nivo-lightbox.css" > 
    <!-- Animate -->
    <link rel="stylesheet" type="text/css" href="assets2/css/animate.css">
    <!-- Owl carousel -->
    <link rel="stylesheet" type="text/css" href="assets2/css/owl.carousel.css">   
    
    <!-- Color CSS Styles  -->
    <link rel="stylesheet" type="text/css" href="assets2/css/colors/default.css" media="screen" /> 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <!-- Header Area wrapper Starts -->
    <header id="header-wrap">
      <!-- Roof area Starts -->
      <div id="roof" class="hidden-xs">
          <div class="container">
            <div class="col-md-6 col-sm-6">
              <div class="info-bar-address">
                 <i class="icon-location-pin"></i> AU, Visakhapatnam,Andhra Pradesh - 500018              </div>
            </div>
            <div class="col-md-6 col-sm-6">
              <!-- Quick Contacts Starts -->
             <div class="quick-contacts">
                  <span><i class="icon-phone"></i> (+91) 123 456 789</span>
                  <span><i class="icon-envelope"></i><a href="#">info@vspbitcoin.com</a></span>|
              
<span><b>   <a href="Security.jsp">Security</a> | <a href="Logout.jsp">Logout</a></span></b>          
              </div>              <!-- Quick Contacts End -->
            </div>
          </div>
      </div>
      <!-- Roof area End -->

      <!-- Nav Menu Section Start -->
      <div class="navigation-menu">
        <nav class="navbar navbar-default navbar-event" >
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header col-md-2">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.html"><img src="assets2/img/logo1.png" alt=""></a>
            </div>
            
            <div class="collapse navbar-collapse" id="navbar">
              <ul class="nav navbar-nav navbar-right">
                <li  class="active"><a href="dashboard.jsp">Dashboard</a></li>                               
                <li><a href="buy.jsp">Buy </a></li>              
                <li><a href="sell.jsp">Sell</a></li>              
                <li><a href="send.jsp">Send</a></li>
                <li><a href="viewusers.jsp">View User</a></li>                                              
                <li><a href="viewledger.jsp">View Ledger</a></li>                                              
                <li><a href="Logout.jsp">Logout</a></li> 
                     
              </ul> 
            </div><!-- /navbar-collapse -->
          </div><!-- /container -->

          <!-- Mobile Menu Start -->
          <ul class="wpb-mobile-menu">
                          <li  class="active"><a href="dashboard.jsp">Dashboard</a></li>                               
                <li><a href="buy.jsp">Buy </a></li>              
                <li><a href="sell.jsp">Sell</a></li>              
                <li><a href="send.jsp">Send</a></li>
                <li><a href="viewusers.jsp">View User</a></li>                                              
                <li><a href="viewledger.jsp">View Ledger</a></li>                                              
                <li><a href="Logout.jsp">Logout</a></li> 
                                
     </ul>
          <!-- Mobile Menu End -->

        </nav>
      </div>
      <!-- Nav Menu Section End -->

    </header>
    <!-- Header Area wrapper End -->

    <!-- Main Slider Section Start -->
    <!-- Main Slider Section End -->

        <!-- Call to action Section -->
        <!-- Call to action Section End -->

<div class="page-header">      
      <div class="container"> 
        <div class="page-header-inner">         
          <ol class="breadcrumb wow fadeInDown" data-wow-delay="300ms">
            <li><a href="index.html">Home</a></li>
            <li class="page">Buy</li>
          </ol>
          <h1 class="page-title wow fadeInRight" data-wow-delay="300ms">
Buy         </h1>
        </div>
      </div>
    </div>
    <section id="aboutus" class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <center>
              <% String str="";
                 
                  String noc="0";//(String)session.getAttribute("noc");
                  String walletid="";
                   String idd=request.getParameter("id");
                  //noc=request.getParameter("nb");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bitcoindb","root","root");
                PreparedStatement onea=con.prepareStatement("select * from tbl_coins  where id="+idd);
                ResultSet rsa=onea.executeQuery();
                
                while(rsa.next())
                {
                walletid=rsa.getString(2);
                noc=rsa.getString(3);
                }
                rsa.close();
                onea.close();
                
                PreparedStatement ps=con.prepareStatement("insert into tbl_ledger(date, time,walletid,  type, chainid, transaction,seckey,mainchainid) values(?,?,?,?,?,?,?,?)");
            java.util.Date date=new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                       
            ps.setDate(1,sqlDate);
            ps.setTimestamp(2,sqlTime);
            ps.setString(3,walletid);
            ps.setString(4,"Sell");
            ps.setString(5,"1");
            ps.setString(6,"Sell "+noc+ "Bitcoins");
            String key=walletid.substring(walletid.lastIndexOf("-")+1);
            System.out.println(""+key);
            ps.setString(7,"2"+key+"96");
            String mnid=walletid.substring(0,walletid.indexOf("-"));
            ps.setString(8,""+mnid);
            System.out.println(""+mnid);
            ps.executeUpdate();            
            
            ps.close();
            PreparedStatement one1=con.prepareStatement("update tbl_coins  set status=1 where id="+idd);
                one1.execute();
                PreparedStatement one=con.prepareStatement("select * from tbl_coins  where status=0 and type=2");
                ResultSet rs=one.executeQuery();
                %>
                <br>
                <center>
              <div class="alert alert-success">
  <strong>Approved successfully!</strong>  
</div>
              </center>
                <h4>View Bitcoins Sell Details</h4>
                <table border="1" width="100%" id="table1">
	<tr>
		
		<td align="center"><b>Wallet ID</b></td>
		<td align="center"><b>No of Bitcoins</b></td>
		<td align="center"><b>Date sell </b></td>
		<td align="center"><b>Status</b></td>
	</tr>
	

                <%
                   
                while(rs.next())
                {
                      String id=""+rs.getInt(1);
                    String wd=rs.getString(2);
                    noc=""+rs.getInt(3);
                    String dt=rs.getString(5);
                
                str=str+  "<tr><td align=center>"+wd+"</td>	<td align=center>"+noc+"</td>		<td align=center>"+dt+"</td>		<td align=center><a href=approvb.jsp?id="+id+"&nb="+noc+">Approve</a></td>	</tr> ";
                     
                 }
                }
                catch(Exception ex)
                {
                System.out.println(ex);
                }
                   
                  %>
                  <%=str%>
                  </table><br>
                  </center>
			 
          </div>
        </div>
      </div>
    </section>
     



    <!-- Footer Section Start -->   
    <!-- Footer Section End -->  
   
    </div>
    <!-- Main contetn End -->

    <!-- Copytight Start -->
    <section id="copyright">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <p class="copyright-text text-center">
            All rights are reserved. &copy;
              <a rel="nofollow" href="#">
            ABCD            </a> | <a  href="#terms">
              <font color="#3399FF">Terms & Conditions             </font>             </a>
            </p>
          </div>
        </div>
      </div>
    </section>
    <!-- Copytight End -->   

    <!-- Go to Top Link -->
    <a href="#" class="back-to-top">
    <i class="icon-arrow-up"></i>
    </a>

     

    <!-- jQuery Load -->    
    <script src="assets2/js/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="assets2/js/bootstrap.min.js"></script>
    <!-- Countdown Js -->
    <script src="assets2/js/jquery.countdown.min.js"></script>
    <!-- Smooth scroll JS -->   
    <script src="assets2/js/smooth-scroll.js"></script>        
    <!-- Wow Scroll -->
    <script src="assets2/js/wow.js"></script>
    <!-- Owl carousel -->
    <script src="assets2/js/owl.carousel.min.js"></script>
    <!-- Slicknav js -->
    <script src="assets2/js/jquery.slicknav.js"></script>
    <!--  Nivo lightbox Js -->
    <script src="assets2/js/nivo-lightbox.js"></script>   
    <!-- Contact Form Scripts -->
    <script src="assets2/js/form-validator.min.js"></script>  
    <script src="assets2/js/contact-form-script.js"></script>    
 
    <!-- All Js plugin -->
    <script src="assets2/js/main.js"></script> 
    <!-- Map JS -->
    <script type="text/javascript" src="assets2/js/jquery.mapit.min.js"></script>
    <script src="assets2/js/initializers.js"></script>

  </body>
</html>


