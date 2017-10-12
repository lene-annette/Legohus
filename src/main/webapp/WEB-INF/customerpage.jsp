<%-- 
    Document   : customer
    Created on : 10-10-2017, 10:17:05
    Author     : lene_
--%>

<%@page import="java.lang.Integer"%>
<%@page import="java.util.List"%>
<%@page import="Function.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer page</title>
    </head>
    <body>
        <%User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getName()%></h1>
        
        <div>
            <form name="placeOrder" action="FrontController" method="POST">
                <h2>Please enter data to calculate a bill</h2><br>
                <input type="hidden" name="command" value="placeOrder">
                Length of house in dots:<br>
                <input type="text" name="length" value="0">
                <br>
                Width of house in dots:<br>
                <input type="text" name="width" value="0">
                <br>
                Height in bricks:<br>
                <input type="text" name="height" value="0">
                <br>
                <input type="submit" value="Calculate">
                
            </form>
        </div>
        <div>
            <% List<Integer> bricks = (List<Integer>)request.getAttribute("bricks");
                if(bricks != null){ 
                    int fours = bricks.get(0);
                    int twos = bricks.get(1);
                    int ones = bricks.get(2); %>
                    <p>No of 4x2: <%=fours %></p>
                    <p>No of 2x2: <%=twos %></p>
                    <p>No of 1x2: <%=ones %></p>
               <% }
            %>
            
            
        </div>
        
    </body>
</html>
