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
        List<Integer> noOfBricks = makeList(request,response,length,width,height);
        request.setAttribute("bricks", noOfBricks);
        return user.getType() + "page";
    }
    
    private List<Integer> makeList(HttpServletRequest request, HttpServletResponse response, int length, int width, int height) {
        Bricks bricks = new Bricks(length,width,height);
        List<Integer> noOfBricks = new ArrayList<>();
        int fours = bricks.getTotalFours();
        int twos = bricks.getTotalTwos();
        int ones = bricks.getTotalOnes();
        noOfBricks.add(fours); noOfBricks.add(twos); noOfBricks.add(ones);
        
        return noOfBricks;
    }
    
}
