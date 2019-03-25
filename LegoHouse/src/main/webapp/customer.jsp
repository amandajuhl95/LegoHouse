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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LegoShop</title>
    </head>
    <center>
        <body>
            <form action="LegoHouse" method="POST">
                <h1>Your orders</h1>
                <%
                    List<Order> orders = (List<Order>) session.getAttribute("orders");
                    for (Order o : orders)
                    {
                        out.println("<li><a href=\"LegoHouse?command=customerOrder&selected=" + o.getOrder_id() + "\">" + o + "</a></li>");
                    }
                %>
                <br><br><button name="command" value="shop">Go back to shop</button>
                <br><br><button name="command" value="logout">Log out</button>
            </form>
        </body>
    </center>
</html>
