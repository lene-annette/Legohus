/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LegohusException;
import Function.LogicFacade;
import Function.Order;
import Function.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lene_
 */
public class SeeOrdes extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String type = user.getType();
        if(type.equals("employee")){
            List<Order> orders = LogicFacade.getAllOrders();
            session.setAttribute("orders", orders);
        }else{
            int userId = user.getId();
            List<Order> orders = LogicFacade.getAllOrdersById(userId);
            session.setAttribute("orders",orders);
        }
        return type + "page";
    }

    
    
}
