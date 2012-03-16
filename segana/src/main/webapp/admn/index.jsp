<%-- 
    Document   : index.jsp
    Created on : Mar 15, 2012, 3:13:53 PM
    Author     : Omar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String x = request.getParameter("email");
        String username=(String) session.getAttribute("namen");
              
        if(username!=null)
        {
            if(username.equals("admin@admin.com"))
            {
                response.sendRedirect("admin.jsp");
                out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+ username +"</a> , <a href=\"logout.jsp\" >Logout</a></p> ");
            }
            else
            {
                response.sendRedirect("http://localhost:8084/segana/index.jsp");
            }
        }
        else
        {
            response.sendRedirect("http://localhost:8084/segana/index.jsp");
        }   
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
