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
public class LegoMain {
      public static void main(String[] args) {
          
//          List<Integer> bricks = BuildingBricks.simpleBuilder(13, 9);
//          
//          System.out.println("Længde 4x2: " + bricks.get(0));
//          System.out.println("Længde 2x2: " + bricks.get(1));
//          System.out.println("Længde 1x2: " + bricks.get(2));
//          System.out.println("\nBredde 4x2: " +bricks.get(3));
//          System.out.println("Bredde 2x2: " + bricks.get(4));
//          System.out.println("Bredde 1x2: " + bricks.get(5));
//          
//          List<Integer> result = BuildingBricks.totalBricks(bricks, 4);
//          System.out.println("\nAntal 4x2 i alt: " + (result.get(0) + result.get(3)));
//          System.out.println("Antal 2x2 i alt: " + (result.get(1)+result.get(4)));
//          System.out.println("Antal 1x2 i alt: " + (result.get(2)+result.get(5)));
          
          
        UserMapper um = new UserMapper();
        OrderMapper om = new OrderMapper();
        try{
            
            User user = um.login("john@gmail.com","password");
//            List<Order> orders = om.getAllOrdersByUserId(3);
              List<Order> orders = om.getAllOrders();
            
            for(Order order : orders){
                System.out.println(order);
            }
        }catch(LegohusException ex){
            System.out.println("message: " + ex.getMessage() );
        }

        
    }
    
}
