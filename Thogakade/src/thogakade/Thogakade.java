/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Thogakade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sql = "Select * From Customer Where salary =  820000.00";//Step1 SQL Query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","1234");
            Statement stm = connection.createStatement();
            //int i = stm.executeUpdate(sql);
            ResultSet rst = stm.executeQuery(sql);
            rst.next();
            System.out.println(rst.getString("id")+" "+rst.getString("name")+""+rst.getString("address")+""+rst.getString("salary"));
            
            /*if(i>0){
            System.out.println("Deleted ");
            }*/
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not Found");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
