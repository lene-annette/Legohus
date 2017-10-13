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
import Function.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lene_
 */
public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        LogicFacade.createOrder(length, width, height, user.getId());
        Bricks bricks = new Bricks(length,width,height);
        request.setAttribute("bricks1", bricks);
        return user.getType() + "page";
    }
    

    
}
