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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LegoShop</title>
    </head>
    <body>
    <center>
        <form action="LegoHouse" method="POST">
            <button name="command" value="logout">Log out</button>
            <br><br><br><br>
            <%
                String message = (String) session.getAttribute("message");
                out.println(message);
                session.removeAttribute("message");
            %>
            <br><br><button name="command" value="shop">Go back to shop</button>
        </form>
    </center>
    </body>
</html>
