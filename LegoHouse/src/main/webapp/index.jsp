<%-- 
    Document   : index
    Created on : 22-03-2019, 20:47:12
    Author     : aamandajuhl
--%>
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
            <%
                String message = (String) session.getAttribute("message");
            %>

            <h1>Type in email and password</h1>
            Email <input type ="text" name ="email" value=""><br><br>
            Password <input type ="password" name ="password" value=""><br><br>
            <button name="command" value="login">Login</button><br><br>
            <select name="role">
                <option disabled selected>Choose role</option>
                <%
                    out.println("<option>" + "customer" + "</option>");
                    out.println("<option>" + "employee" + "</option>");
                %>
            </select>
            <br><br>
            <button name="command" value="create">Create</button><br><br>
            <%                
                if (message != null)
                {
                    out.println(message);
                    session.removeAttribute("message");
                }
            %>
        </form>
    </center>
</body>
</html>
