<%
String okey=request.getParameter("keyh");
String dkey=request.getParameter("keyd");
String id=request.getParameter("id");
//out.print(okey);
//out.print("<br>"+dkey);
if(okey.equalsIgnoreCase(dkey))
{
response.sendRedirect("viewtransfulldetails.jsp?id="+id);
}
else
{
response.sendRedirect("invalidkey.jsp?id="+id);
}
%>