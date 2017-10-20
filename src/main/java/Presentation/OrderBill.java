/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.Bricks;
import Function.LegohusException;
import Function.LogicFacade;
import Function.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lene_
 */
public class OrderBill extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = LogicFacade.getOrderById(orderId);
        Bricks bricks = new Bricks(order.getLength(),order.getWidth(),order.getHeight());
        request.setAttribute("bricks",bricks);
        return "customerpage";
    }

    
}
