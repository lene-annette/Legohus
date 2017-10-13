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
            <% Bricks bricks1 = (Bricks) request.getAttribute("bricks1");
                if (bricks1 != null) {%>
            Entered data: <br>
            Length: <%=bricks1.getLength()%>, width: <%=bricks1.getWidth()%>, height: <%=bricks1.getHeight()%><br>
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
                    <th><%=bricks1.getLengthFours()%></th>
                    <th><%=bricks1.getWidthFours()%></th>
                    <th><%=bricks1.getLengthFours()%></th>
                    <th><%=bricks1.getWidthFours()%></th>
                    <th><%=bricks1.getTotalFours()%></th>
                </tr>
                <tr>
                    <th>2x2</th>
                    <th><%=bricks1.getLengthTwos()%></th>
                    <th><%=bricks1.getWidthTwos()%></th>
                    <th><%=bricks1.getLengthTwos()%></th>
                    <th><%=bricks1.getWidthTwos()%></th>
                    <th><%=bricks1.getTotalTwos()%></th>
                </tr>
                <tr>
                    <th>1x2</th>
                    <th><%=bricks1.getLengthOnes()%></th>
                    <th><%=bricks1.getWidthOnes()%></th>
                    <th><%=bricks1.getLengthOnes()%></th>
                    <th><%=bricks1.getWidthOnes()%></th>
                    <th><%=bricks1.getTotalOnes()%></th>
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
                if (orders != null) {%>
            
                <table>
                    <tr>
                        <th>Order id</th>
                        <th>House length</th>
                        <th>House width</th>
                        <th>House height</th>
                        <th>Order date</th>
                        <th>Shipped</th>
                    </tr>
                    <% for (Order order : orders) {%>
                    <tr>
                        <th><%=order.getId()%></th>
                        <th><%=order.getLength()%></th>
                        <th><%=order.getWidth()%></th>
                        <th><%=order.getHeight()%></th>
                        <th><%=order.getOrderDate()%></th>
                        <th>
                            <%if (order.getDispatchDate() != null) {%>
                            <%=order.getDispatchDate()%>
                            <% }%>
                        </th>
                        <th>
                            <form name="getBill" action="FrontServlet" method="POST">
                            <input type="hidden" name="command" value="getBill">
                            <input type="hidden" name="orderId" value="<%=order.getId()%>">
                            <input type="submit" value="Get bill">
                            </form>
                        </th>
                    </tr>
                    <% } %>
                </table>
            
            <%   } %>
        </div>
        <div>
            <% Bricks bricks2 = (Bricks) request.getAttribute("bricks2");
                if (bricks2 != null) {%>
            Entered data: <br>
            Length: <%=bricks2.getLength()%>, width: <%=bricks2.getWidth()%>, height: <%=bricks2.getHeight()%><br>
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
                    <th><%=bricks2.getLengthFours()%></th>
                    <th><%=bricks2.getWidthFours()%></th>
                    <th><%=bricks2.getLengthFours()%></th>
                    <th><%=bricks2.getWidthFours()%></th>
                    <th><%=bricks2.getTotalFours()%></th>
                </tr>
                <tr>
                    <th>2x2</th>
                    <th><%=bricks2.getLengthTwos()%></th>
                    <th><%=bricks2.getWidthTwos()%></th>
                    <th><%=bricks2.getLengthTwos()%></th>
                    <th><%=bricks2.getWidthTwos()%></th>
                    <th><%=bricks2.getTotalTwos()%></th>
                </tr>
                <tr>
                    <th>1x2</th>
                    <th><%=bricks2.getLengthOnes()%></th>
                    <th><%=bricks2.getWidthOnes()%></th>
                    <th><%=bricks2.getLengthOnes()%></th>
                    <th><%=bricks2.getWidthOnes()%></th>
                    <th><%=bricks2.getTotalOnes()%></th>
                </tr>
            </table>
            <% }
            %>
        </div>

    </body>
</html>
