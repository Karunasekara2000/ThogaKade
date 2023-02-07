/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class DBConnection {
    
    private static DBConnection dBconnection;
    private Connection connection;
    private DBConnection() throws ClassNotFoundException, SQLException{
    
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade","root","1234");
    }
    
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBconnection==null){
               dBconnection =  new DBConnection();
        }
        return dBconnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
}
