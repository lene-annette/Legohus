/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lene_
 */
public class DBConnector {
    private static final String url = "jdbc:mysql://207.154.247.212:3306/legohus";
    private static final String username = "lsko";
    private static final String password = "LeneSkov";
    
    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if(singleton == null){
            Class.forName("com.mysql.jdbc.Driver");
            singleton = DriverManager.getConnection(url, username, password);
            
        }
        return singleton;
    }
}
