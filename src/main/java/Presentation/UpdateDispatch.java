/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LegohusException;
import Function.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lene_
 */
public class UpdateDispatch extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int OId = Integer.parseInt(request.getParameter("orderId"));
        String date = "2017-10-13";
        
        HttpSession session = request.getSession();
        String update = "The shippingdate has been updated";
        session.setAttribute("updateMessage",update);
        
        LogicFacade.updateDispatchDate(date, OId);
        
        return "employeepage";
    }

    
    
}
