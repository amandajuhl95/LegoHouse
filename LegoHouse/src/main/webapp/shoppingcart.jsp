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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LegoShop</title>
    </head>
    <body>
    <center>
        <form action="LegoHouse" method="POST">
            <h1>Welcome to the LegoShop</h1>
            Length <input type ="number" name ="length" value="" minlength="5" required="">
            Width <input type ="number" name ="width" value="" minlength="5" required="">
            Height <input type ="number" name ="height" value="" minlength="1" required="">
            <button name="command" value="shoppingcart">Add to shoppingcart</button>

            <%
                ItemList list = (ItemList) session.getAttribute("list");
                Order order = (Order) session.getAttribute("order");

                out.println("<p>Measure: " + order.getLength() + "x" + order.getWidth() + "x" + order.getHeight() + "</p>");
            %>
            <br><br>
            <%
                out.println("<p> Pieces of lego bricks </p>");
                out.println("<p>(4x2): " + list.getLegoHouse().get("4x2") + " pieces</p>");
                out.println("<p>(2x2): " + list.getLegoHouse().get("2x2") + " pieces</p>");
                out.println("<p>(1x2): " + list.getLegoHouse().get("1x2") + " pieces</p>");
            %>
        </form>
        <form action="LegoHouse" method="POST">  
            <button name="command" value="checkout">Place order</button>
        </form>
    </center>
</body>
</html>


