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

/**
 *
 * @author lene_
 */
public class OrderMapper {
    
    //Order getOrder(id)
    
    //List getAllOrders()
    
    //List getAllOrdersByUser(id)
    
    //create Order()
    
    public static void createOrder(Order order,int uId) throws LegohusException{
        try{
            Connection con = DBConnector.connection();
            String SQL ="INSERT INTO orders(length,width,height,orderdate,u_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getLength());
            ps.setInt(2,order.getWidth());
            ps.setInt(3,order.getHeight());
            ps.setString(4, order.getOrderDate());
            ps.setInt(5, uId);
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
        
    }
    
}
