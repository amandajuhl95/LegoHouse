<%-- 
    Document   : index
    Created on : 21-03-2019, 18:28:10
    Author     : aamandajuhl
--%>
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
                String user = (String) session.getAttribute("user");
            %>
            
            <h1>Type in email and password</h1>
            Email <input type ="text" name ="email" value=""><br><br>
            Password <input type ="password" name ="password" value=""><br><br>
            <button name="command" value="create">Create</button><br><br>
            <button name="command" value="login">Login</button><br><br>
            
            <%    
                if (user != null)
                {
                    out.println(user);
                    session.removeAttribute("user");
                }
            %>
        </form>
    </center>
</body>

</html>

