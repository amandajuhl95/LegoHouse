<%-- 
    Document   : index
    Created on : 21-03-2019, 18:28:10
    Author     : aamandajuhl
--%>
<%@page import="logic.LogicManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LegoShop</title>
    </head>
    <center>
        <body>
            <form action="LegoHouse" method="POST">
                <h1>Type in email and password</h1>
                Email <input type ="text" name ="email" value="">
                <br><br>
                Password <input type ="password" name ="password" value="">
                <br><br>
                <button name="command" value="create">Create</button>
                <br><br>
                <button name="command" value="login">Login</button>
            </form>
        </body>
    </center>
</html>

