package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("    <title>Leveraging Blockchain technology on Identification of Cyber-Security Issues</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/bootstrap.min.css\" >    \r\n");
      out.write("    <!-- Main Style -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/main.css\">\r\n");
      out.write("    <!-- Responsive Style -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/responsive.css\">\r\n");
      out.write("    <!-- Fonts -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/fonts/font-awesome.min.css\">\r\n");
      out.write("    <!-- Icon -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/fonts/simple-line-icons.css\"> \r\n");
      out.write("    <!-- Slicknav -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/slicknav.css\">\r\n");
      out.write("    <!-- Nivo Lightbox -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/nivo-lightbox.css\" > \r\n");
      out.write("    <!-- Animate -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/animate.css\">\r\n");
      out.write("    <!-- Owl carousel -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/owl.carousel.css\">   \r\n");
      out.write("    \r\n");
      out.write("    <!-- Color CSS Styles  -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets2/css/colors/default.css\" media=\"screen\" /> \r\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Area wrapper Starts -->\r\n");
      out.write("    <header id=\"header-wrap\">\r\n");
      out.write("      <!-- Roof area Starts -->\r\n");
      out.write("      <div id=\"roof\" class=\"hidden-xs\">\r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("            <div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("              <div class=\"info-bar-address\">\r\n");
      out.write("                 <i class=\"icon-location-pin\"></i> AU, Visakhapatnam,Andhra Pradesh - 500018              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("              <!-- Quick Contacts Starts -->\r\n");
      out.write("             <div class=\"quick-contacts\">\r\n");
      out.write("                  <span><i class=\"icon-phone\"></i> (+91) 123 456 789</span>\r\n");
      out.write("                  <span><i class=\"icon-envelope\"></i><a href=\"#\">info@vspbitcoin.com</a></span>|\r\n");
      out.write("              \r\n");
      out.write("<span><b>   <a href=\"Security.jsp\">Security</a> | <a href=\"Logout.jsp\">Logout</a></span></b>          \r\n");
      out.write("              </div>              <!-- Quick Contacts End -->\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- Roof area End -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Menu Section Start -->\r\n");
      out.write("      <div class=\"navigation-menu\">\r\n");
      out.write("        <nav class=\"navbar navbar-default navbar-event\" >\r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("            <div class=\"navbar-header col-md-2\">\r\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\">\r\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("              </button>\r\n");
      out.write("              <a class=\"navbar-brand\" href=\"dashboard.jsp\"><img src=\"../assets2/img/logo1.png\" alt=\"\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbar\">\r\n");
      out.write("               <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                <li  class=\"active\"><a href=\"dashboard.jsp\">Dashboard</a></li>                               \r\n");
      out.write("                <li><a href=\"buy.jsp\">Buy </a></li>              \r\n");
      out.write("                <li><a href=\"sell.jsp\">Sell</a></li>              \r\n");
      out.write("                <li><a href=\"send.jsp\">Send</a></li>\r\n");
      out.write("                <li><a href=\"viewusers.jsp\">View User</a></li>                                              \r\n");
      out.write("                <li><a href=\"viewledger.jsp\">View Ledger</a></li>                                              \r\n");
      out.write("                <li><a href=\"Logout.jsp\">Logout</a></li> \r\n");
      out.write("                     \r\n");
      out.write("              </ul> \r\n");
      out.write("            </div><!-- /navbar-collapse -->\r\n");
      out.write("          </div><!-- /container -->\r\n");
      out.write("\r\n");
      out.write("          <!-- Mobile Menu Start -->\r\n");
      out.write("          <ul class=\"wpb-mobile-menu\">\r\n");
      out.write("                           \r\n");
      out.write("                <li  class=\"active\"><a href=\"admin/dashboard.jsp\">Dashboard</a></li>                               \r\n");
      out.write("                <li><a href=\"admin/buy.jsp\">Buy </a></li>              \r\n");
      out.write("                <li><a href=\"admin/sell.jsp\">Sell</a></li>              \r\n");
      out.write("                <li><a href=\"admin/send.jsp\">Send</a></li>\r\n");
      out.write("                <li><a href=\"admin/viewusers.jsp\">View User</a></li>                                              \r\n");
      out.write("                <li><a href=\"admin/viewledger.jsp\">View Ledger</a></li>                                              \r\n");
      out.write("                <li><a href=\"Logout.jsp\">Logout</a></li> \r\n");
      out.write("                     \r\n");
      out.write("             \r\n");
      out.write("                                \r\n");
      out.write("     </ul>\r\n");
      out.write("          <!-- Mobile Menu End -->\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- Nav Menu Section End -->\r\n");
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- Header Area wrapper End -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Main Slider Section Start -->\r\n");
      out.write("    <!-- Main Slider Section End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Call to action Section -->\r\n");
      out.write("        <!-- Call to action Section End -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"page-header\">      \r\n");
      out.write("      <div class=\"container\"> \r\n");
      out.write("        <div class=\"page-header-inner\">         \r\n");
      out.write("          <ol class=\"breadcrumb wow fadeInDown\" data-wow-delay=\"300ms\">\r\n");
      out.write("            <li><a href=\"index.html\">Home</a></li>\r\n");
      out.write("            <li class=\"page\">Administration</li>\r\n");
      out.write("          </ol>\r\n");
      out.write("          <h1 class=\"page-title wow fadeInRight\" data-wow-delay=\"300ms\">\r\n");
      out.write("Administration          </h1>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <section id=\"aboutus\" class=\"section\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-md-12\">\r\n");
      out.write("              <center>\r\n");
      out.write("            <h2 class=\"section-title wow fadeInUp\" data-wow-delay=\"0s\">\r\n");
      out.write("                <h4>Welcome to Administration</h4></center>\r\n");
      out.write("              <br>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Footer Section Start -->   \r\n");
      out.write("    <!-- Footer Section End -->  \r\n");
      out.write("   \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Main contetn End -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Copytight Start -->\r\n");
      out.write("    <section id=\"copyright\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-md-12\">\r\n");
      out.write("            <p class=\"copyright-text text-center\">\r\n");
      out.write("            All rights are reserved. &copy;\r\n");
      out.write("              <a rel=\"nofollow\" href=\"#\">\r\n");
      out.write("            ABCD            </a> | <a  href=\"#terms\">\r\n");
      out.write("              <font color=\"#3399FF\">Terms & Conditions             </font>             </a>\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- Copytight End -->   \r\n");
      out.write("\r\n");
      out.write("    <!-- Go to Top Link -->\r\n");
      out.write("    <a href=\"#\" class=\"back-to-top\">\r\n");
      out.write("    <i class=\"icon-arrow-up\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery Load -->    \r\n");
      out.write("    <script src=\"assets2/js/jquery.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap JS -->\r\n");
      out.write("    <script src=\"assets2/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- Countdown Js -->\r\n");
      out.write("    <script src=\"assets2/js/jquery.countdown.min.js\"></script>\r\n");
      out.write("    <!-- Smooth scroll JS -->   \r\n");
      out.write("    <script src=\"assets2/js/smooth-scroll.js\"></script>        \r\n");
      out.write("    <!-- Wow Scroll -->\r\n");
      out.write("    <script src=\"assets2/js/wow.js\"></script>\r\n");
      out.write("    <!-- Owl carousel -->\r\n");
      out.write("    <script src=\"assets2/js/owl.carousel.min.js\"></script>\r\n");
      out.write("    <!-- Slicknav js -->\r\n");
      out.write("    <script src=\"assets2/js/jquery.slicknav.js\"></script>\r\n");
      out.write("    <!--  Nivo lightbox Js -->\r\n");
      out.write("    <script src=\"assets2/js/nivo-lightbox.js\"></script>   \r\n");
      out.write("    <!-- Contact Form Scripts -->\r\n");
      out.write("    <script src=\"assets2/js/form-validator.min.js\"></script>  \r\n");
      out.write("    <script src=\"assets2/js/contact-form-script.js\"></script>    \r\n");
      out.write(" \r\n");
      out.write("    <!-- All Js plugin -->\r\n");
      out.write("    <script src=\"assets2/js/main.js\"></script> \r\n");
      out.write("    <!-- Map JS -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"assets2/js/jquery.mapit.min.js\"></script>\r\n");
      out.write("    <script src=\"assets2/js/initializers.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
