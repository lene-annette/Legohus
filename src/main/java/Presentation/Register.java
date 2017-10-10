/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LegohusException;
import Function.LogicFacade;
import Function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lene_
 */
public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if(password1.equals(password2)){
            User user = LogicFacade.createUser(name,email,password1);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("type",user.getType());
            return user.getType() + "page";
        }else{
            throw new LegohusException("the two passwords did not match");
        }
        
    }
    
}
