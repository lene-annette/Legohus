/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

/**
 *
 * @author lene_
 */
public class LogicFacade {

    public static User login(String email, String password) throws LegohusException {
        return UserMapper.login(email,password);
    }

    public static User createUser(String name, String email, String password) throws LegohusException {
        User user = new User(name,email,password,"customer");
        UserMapper.createUser(user);
        return user;
    }
    
    //kunderkrav 2: Kunne se tidligere ordre:
    public static List<Order> getAllOrdersById(int userId) throws LegohusException {
        return OrderMapper.getAllOrdersByUserId(userId);
    }
    
    public static void createOrder(int length, int width, int height, int userId) throws LegohusException{
        Order order = new Order(length, width, height, "2017-10-12", userId);
        OrderMapper.createOrder(order);
        
    }
    
    //firmakrav 1: ansat skal kunne se alle ordre i systemet
    public static List<Order> getAllOrders() throws LegohusException{
        return OrderMapper.getAllOrders();
    }
    
    //Firmakrav 2: ansat skal kunne sætte afsendelsesdato
    public static void updateDispatchDate(String date,int oId) throws LegohusException{
        OrderMapper.updateDispatchDate(date, oId);
    }
    
    public static Order getOrderById(int id) throws LegohusException{
        return OrderMapper.getOrder(id);
    }
    
}
