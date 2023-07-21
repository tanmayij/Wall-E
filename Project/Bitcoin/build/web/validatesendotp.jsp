<%
String okey=request.getParameter("keyh");
String dkey=request.getParameter("keyd");
String id=request.getParameter("noc");
String awdid=request.getParameter("wdid");
//out.print(okey);
//out.print("<br>"+dkey);
if(okey.equalsIgnoreCase(dkey))
{
    response.sendRedirect("sendprocessled.jsp?id="+id+"&awdid="+awdid);
}
else
{
    response.sendRedirect("invalidsendotpkey.jsp?id="+id+"&awdid="+awdid+"okey="+okey);
}
%>