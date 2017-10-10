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
public class LegoMain {
      public static void main(String[] args) {
        UserMapper um = new UserMapper();
        try{
            User user = um.login("lene@mail.dk","1234");
            System.out.println(user);
        }catch(LegohusException ex){
            System.out.println("message: " + ex.getMessage() );
        }
    }
    
}
