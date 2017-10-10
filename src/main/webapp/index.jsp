<%-- 
    Document   : index
    Created on : 10-10-2017, 09:48:52
    Author     : lene_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <div>
            <form name="login" action="FrontController" method="POST">
                <h2>Login</h2> <br>
                <input type="hidden" name="command" value="login">
                Email:<br>
                <input type="text" name="email" value="some@email.com">
                <br>
                password:<br>
                <input type="password" name="password" value="password">
                <br>
                <input type="submit" value="Login">
            </form>
            <br><br>
            <h2>Or register</h2>
            <br>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                Name:<br>
                <input type="text" name="name" value="John Doe">
                <br>
                Email:<br>
                <input type="text" name="email" value="some@email.com">
                <br>
                Password:<br>
                <input type="password" name="password1" value="password">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="password">
                <br>
                <input type="submit" value="Register">
                
            </form>
            
        </div>
    </body>
</html>
