/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import DBAccess.UserMapper;

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
    
}
