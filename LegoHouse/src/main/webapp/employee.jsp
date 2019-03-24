<%-- 
    Document   : employee
    Created on : 22-03-2019, 20:40:15
    Author     : aamandajuhl
--%>

<%@page import="java.util.List"%>
<%@page import="logic.Order"%>
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
                <h1>All orders</h1>
                <%
                    List<Order> allOrders = (List<Order>) session.getAttribute("allOrders");
                    for (Order o : allOrders)
                    {
                        out.println("<li><a href=\"command=customerOrder&selected=" + o.getOrder_id() + "\">" + o + "</a></li>");
                    }
                %>
            </form>
        </body>
    </center>
</html>
