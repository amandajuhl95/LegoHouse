<%-- 
    Document   : shop
    Created on : 21-03-2019, 19:02:58
    Author     : aamandajuhl
--%>
<%@page import="logic.Order"%>
<%@page import="logic.User"%>
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
            <%
                User user = (User) session.getAttribute("user");
            %>
            <h1>Welcome to the LegoShop</h1>
            Length <input type ="number" name ="length" value="" minlength="5" required>
            Width <input type ="number" name ="width" value="" minlength="5" required>
            Height <input type ="number" name ="height" value="" minlength="1" required>
            <br><br>
            <button name="command" value="shoppingcart">Add to shoppingcart</button>
        </form>
    </center>
</body>
</html>
