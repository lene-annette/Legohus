/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.LegohusException;
import Function.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lene_
 */
public class OrderMapper {
    
    public static void createOrder(Order order) throws LegohusException{
        try{
            Connection con = DBConnector.connection();
            String SQL ="INSERT INTO orders(length,width,height,orderdate,u_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getLength());
            ps.setInt(2,order.getWidth());
            ps.setInt(3,order.getHeight());
            ps.setString(4, order.getOrderDate());
            ps.setInt(5, order.getUserId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static void updateDispatchDate(String date, int oId) throws LegohusException{
        try{
           Connection con = DBConnector.connection(); 
           String SQL = "UPDATE orders SET dispatchdate=? WHERE o_id=?";
           PreparedStatement ps = con.prepareStatement(SQL);
           ps.setString(1, date);
           ps.setInt(2,oId);
           ps.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static List<Order> getAllOrdersByUserId(int uId) throws LegohusException{
        try{
            List<Order> orders = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * from orders WHERE u_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,uId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("o_id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String oDate = rs.getString("orderdate");
                String dDate = rs.getString("dispatchdate");
                Order order = new Order(length, width, height, oDate, uId);
                order.setId(id);
                order.setDispatchDate(dDate);
                orders.add(order);
            }
            if(orders.isEmpty()){
                throw new LegohusException("the user has no orders");
            }
            return orders;
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static List<Order> getAllOrders() throws LegohusException{
        try{
            List<Order> orders = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("o_id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String oDate = rs.getString("orderdate");
                String dDate = rs.getString("dispatchdate");
                int uId = rs.getInt("u_id");
                Order order = new Order(length, width, height, oDate, uId);
                order.setId(id);
                order.setDispatchDate(dDate);
                orders.add(order);
            }
            if(orders.isEmpty()){
                throw new LegohusException("There are no orders in the system");
            }
            return orders;
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static Order getOrder(int id) throws LegohusException{
        try{
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM orders WHERE o_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String oDate = rs.getString("orderdate");
                String dDate = rs.getString("dispatchdate");
                int uId = rs.getInt("u_id");
                Order order = new Order(length, width, height, oDate, uId);
                order.setId(id);
                order.setDispatchDate(dDate);
                return order;
            }else{
                throw new LegohusException("Could not find order");
            }
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
   
    
}
