<%-- 
    Document   : shoppingcart
    Created on : 22-03-2019, 10:54:48
    Author     : aamandajuhl
--%>
<%@page import="logic.Order"%>
<%@page import="logic.ItemList"%>
<%@page import="logic.LogicManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LegoShop</title>
    </head>
    <body>
        <form action="LegoHouse" method="POST">
            <h1>Welcome to the LegoShop</h1>
            Length <input type ="number" name ="length" value="" minlength="5" required="">
            Width <input type ="number" name ="width" value="" minlength="5" required="">
            Height <input type ="number" name ="height" value="" minlength="1" required="">
            <br>
            <button name="command" value="shoppingcart">Add to shoppingcart</button>

            <%
                ItemList list = (ItemList) session.getAttribute("list");

                    out.println("<p>" + list.getLegoHouse().get("4x2") + "</p>");
             
            %>

            <button name="command" value="checkout">Place order</button>
        </form>
    </body>
</html>


