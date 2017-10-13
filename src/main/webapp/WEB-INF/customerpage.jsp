<%-- 
    Document   : customer
    Created on : 10-10-2017, 10:17:05
    Author     : lene_
--%>

<%@page import="Function.Order"%>
<%@page import="java.util.List"%>
<%@page import="Function.Bricks"%>
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
                <h2>Please enter data to order</h2><br>
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
                <input type="submit" value="Order"><br>
                
            </form>
        </div>
        <div>
            <% Bricks bricks = (Bricks) request.getAttribute("bricks");
                if(bricks != null){ %>
                Entered data: <br>
                Length: <%=bricks.getLength()%>, width: <%=bricks.getWidth()%>, height: <%=bricks.getHeight()%><br>
                <table>
                    <tr>
                        <th>Type</th>
                        <th>Side 1</th>
                        <th>Side 2</th>
                        <th>Side 3</th>
                        <th>Side 4</th>
                        <th>total * height</th>
                    </tr>
                    <tr>
                        <th>4x2</th>
                        <th><%=bricks.getLengthFours()%></th>
                        <th><%=bricks.getWidthFours()%></th>
                        <th><%=bricks.getLengthFours()%></th>
                        <th><%=bricks.getWidthFours()%></th>
                        <th><%=bricks.getTotalFours()%></th>
                    </tr>
                    <tr>
                        <th>2x2</th>
                        <th><%=bricks.getLengthTwos()%></th>
                        <th><%=bricks.getWidthTwos()%></th>
                        <th><%=bricks.getLengthTwos()%></th>
                        <th><%=bricks.getWidthTwos()%></th>
                        <th><%=bricks.getTotalTwos()%></th>
                    </tr>
                    <tr>
                        <th>1x2</th>
                         <th><%=bricks.getLengthOnes()%></th>
                        <th><%=bricks.getWidthOnes()%></th>
                        <th><%=bricks.getLengthOnes()%></th>
                        <th><%=bricks.getWidthOnes()%></th>
                        <th><%=bricks.getTotalOnes()%></th>
                    </tr>
                </table>
               <% }
            %>
        </div>
        <div>
            <p>Click the bottom to see all your orders</p>
            <form name="seeOrders" action="FrontController" method="POST">
                <input type="hidden" name="command" value="seeOrders">
                <input type="submit" value="See orders">
            </form>
        </div>
        
        <div>
            <% List<Order> orders = (List<Order>) session.getAttribute("orders"); 
                if(orders != null){
                    for(Order order : orders){ %>
                    <%=order%><br>
                   <% }
                }%>
        </div>
        
    </body>
</html>
