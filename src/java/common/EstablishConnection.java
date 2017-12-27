/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ashwani
 */
public class EstablishConnection {
    static{
        try{
            Class.forName(Config.DRIVER);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
        return con;
    }
}
