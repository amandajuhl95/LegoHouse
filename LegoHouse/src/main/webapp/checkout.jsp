<%-- 
    Document   : checkout
    Created on : 22-03-2019, 14:54:07
    Author     : aamandajuhl
--%>
<%@page import="logic.Order"%>
<%@page import="logic.LogicManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LegoShop</title>
    </head>
    <body>
    <center>
        <form action="LegoHouse" method="POST">
            <br><br><br><br>
            <%
                String message = (String) session.getAttribute("message");
                out.println(message);
            %>
            <br><br><button name="command" value="shop">Go back to shop</button>
        </form>
    </center>
    </body>
</html>