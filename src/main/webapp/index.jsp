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
                <input type="text" name="email" value="lene@mail.dk"> 
                <br>
                password:<br>
                <input type="password" name="password" value="1234">
                <br>
                <input type="submit" value="Login">
            </form>
            <br><br>
            <h2>Or register</h2>
            <br>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                Name:<br>
                <input type="text" name="name" >
                <br>
                Email:<br>
                <input type="text" name="email" >
                <br>
                Password:<br>
                <input type="password" name="password1" >
                <br>
                Retype Password:<br>
                <input type="password" name="password2" >
                <br>
                <input type="submit" value="Register">
                
            </form>
            
        </div>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>
