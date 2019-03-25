<%-- 
    Document   : employeeOrder
    Created on : 22-03-2019, 20:40:23
    Author     : aamandajuhl
--%>

<%@page import="logic.Order"%>
<%@page import="logic.ItemList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LegoShop</title>
    </head>
    <center>
        <body>
            <form action="LegoHouse" method="POST">
                <%
                    ItemList list = (ItemList) session.getAttribute("previousL");
                    Order order = (Order) session.getAttribute("previousO");

                    out.println("<b>Ordernumber: " + order.getOrder_id() + ". Date: " + order.getDate() + "</b>");
                    out.println("<br><br>Email: " + order.getUser().getEmail() + " - id: " + order.getUser().getId());

                    out.println("<p> Order: " + order.getOrder_id() + ", Date: " + order.getDate() + "</p>");

                    if (list != null)
                    {
                        out.println("<p>" + order.getLength() + "x" + order.getWidth() + "x" + order.getHeight());
                        out.println("<p>Bricks of 4x2: " + list.getLegoHouse().get("4x2") + "</p>");
                        out.println("<p>Bricks of 2x2: " + list.getLegoHouse().get("2x2") + "</p>");
                        out.println("<p>Bricks of 1x2: " + list.getLegoHouse().get("1x2") + "</p>");
                    }

                %>
                <br><br><button name="command" value="shop">Go back to shop</button>
            </form>
        </body>
    </center>
</html>
