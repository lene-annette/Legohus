/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.LegohusException;
import Function.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lene_
 */
public class UserMapper {

    public static void createUser(User user) throws LegohusException{
        try{
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO users (email,u_name,password,u_type) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getType());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        }catch(SQLException | ClassNotFoundException ex){
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static User login(String email, String password) throws LegohusException {
       try{
           Connection con = DBConnector.connection();
           String SQL = "SELECT u_id, u_name, u_type FROM users "
                   + "WHERE email=? AND password=?";
           PreparedStatement ps = con.prepareStatement(SQL);
           ps.setString(1, email);
           ps.setString(2, password);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               int id = rs.getInt("u_id");
               String name = rs.getString("u_name");
               String type = rs.getString("u_type");
               User user = new User(name, email, password, type);
               user.setId(id);
               return user;                       
           }else{
               throw new LegohusException("could not validate user");
           }
           
       } catch(ClassNotFoundException | SQLException ex){
           throw new LegohusException(ex.getMessage());
       }
    }
    
    
}
