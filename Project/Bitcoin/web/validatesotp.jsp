<%
String okey=request.getParameter("keyh");
String dkey=request.getParameter("keyd");
String id=request.getParameter("noc");
//out.print(okey);
//out.print("<br>"+dkey);
if(okey.equalsIgnoreCase(dkey))
{
    response.sendRedirect("sellprocessled.jsp?id="+id);
}
else
{
    response.sendRedirect("invalidotpkey.jsp?id="+okey);
}
%>