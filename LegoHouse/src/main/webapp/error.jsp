<%-- 
    Document   : error
    Created on : 25-03-2019, 11:21:29
    Author     : aamandajuhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=request.getAttribute("message")%>
    </body>
</html>
