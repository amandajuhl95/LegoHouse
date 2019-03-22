<%-- 
    Document   : customer
    Created on : 22-03-2019, 20:23:18
    Author     : aamandajuhl
--%>

<%@page import="java.util.List"%>
<%@page import="logic.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LegoShop</title>
    </head>
    <body>
        <form action="LegoHouse" method="POST">
            <h1>Your orders</h1>
            <%
                List<Order> orders = (List<Order>) session.getAttribute("orders");
                for (Order o : orders)
                {
                    out.println("<li><a href=\"command=customerOrder&selected=" + o.getOrder_id() + "\">" + o + "</a></li>");
                }
            %>
        </form>
    </body>
</html>
