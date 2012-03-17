<%-- 
    Document   : logout
    Created on : Mar 14, 2012, 8:28:09 PM
    Author     : Omar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session.removeAttribute("namen");
        session.removeAttribute("admin");
        response.sendRedirect("index.jsp");
    %>    
</html>
