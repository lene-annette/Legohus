<%-- 
    Document   : employee
    Created on : 10-10-2017, 10:17:31
    Author     : lene_
--%>

<%@page import="Function.Order"%>
<%@page import="java.util.List"%>
<%@page import="Function.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getName()%></h1>
        You are now logged in as an employee!
        <div>
            <p>Click the botton to see all orders in the system</p>
            <form name="seeOrders" action="FrontController" method="POST">
                <input type="hidden" name="command" value="seeOrders">
                <input type="submit" value="See all orders">
            </form>
        </div>
        <div>
            <% List<Order> orders = (List<Order>) session.getAttribute("orders");
                if (orders != null) {%>

            <table>
                <tr>
                    <th>Order id</th>
                    <th>Customer id</th>
                    <th>House length</th>
                    <th>House width</th>
                    <th>House height</th>
                    <th>Order date</th>
                    <th>Shipped</th>
                </tr>
                <% for (Order order : orders) {
                            int orderId = order.getId();%>
                <tr>
                    <th><%=order.getId()%></th>
                    <th><%=order.getUserId()%></th>
                    <th><%=order.getLength()%></th>
                    <th><%=order.getWidth()%></th>
                    <th><%=order.getHeight()%></th>
                    <th><%=order.getOrderDate()%></th>
                    
                        <%if (order.getDispatchDate() != null) {%>
                        <th>
                        <%=order.getDispatchDate()%>
                        </th>
                        <% } else {%>
                        <form name="updateDispatch" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="updateDispatch">
                            <input type="hidden" name="orderId" value="<%=order.getId()%>">
                            <th>
                            <input type="text" name="dDate" >
                            </th>
                            <th>
                            <input type="submit" value="Update Shippingdate">
                            </th>
                        </form>
                    

                    <% } %> 

                </tr>
                <% } %>
            </table>
            <%--
                 <p>Enter id for the order where you want to update shippingdate</p>
                 <input type="hidden" name="command" value="updateDispatch">
                 <input type="text" name="orderId">
                 <input type="submit" value="Update Shippingdate">
                 <%    --%>


            <% }%>
        </div>
        <a href="index.jsp">home</a>
    </body>
</html>
