/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class CustomerController {
    
    
    public static boolean  addCustomer(Customer cus) throws ClassNotFoundException, SQLException{
    
            String sql = "Insert Into Customer Values(?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, cus.getId());
            stm.setObject(2, cus.getName());
            stm.setObject(3, cus.getAddress());
            stm.setObject(4, cus.getSalary());
            int update = stm.executeUpdate();
            
            return update>0;
    }
    public static ResultSet  searchCustomer(String id) throws ClassNotFoundException, SQLException {
    
            String sql = "Select * From Customer Where id='"+id+"'";
            ResultSet rst = DBConnection.getInstance().getConnection().prepareStatement(sql).executeQuery();
  
            return rst;
         
    }
    
    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{

        String sql ="Delete From Customer Where id='"+id+"'";
        int update = DBConnection.getInstance().getConnection().prepareStatement(sql).executeUpdate();
        return update>0;
    }
    
    public static boolean updateCustomer(Customer cus) throws ClassNotFoundException, SQLException{
        
        String sql = "Update Customer Set name=?,address=?,salary=? Where id = '"+cus.getId()+"'";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        //stm.setObject(1, cus.getId());
        stm.setObject(1, cus.getName());
        stm.setObject(2, cus.getAddress());
        stm.setObject(3, cus.getSalary());
        int update = stm.executeUpdate();
        return update>0;
    
    }
     public static ArrayList<Customer> viewCustomer() throws ClassNotFoundException, SQLException{
         
        ResultSet rst = DBConnection.getInstance().getConnection().prepareStatement("Select * From Customer").executeQuery();
        
        ArrayList<Customer> loadCus = new ArrayList<>();
        
        while(rst.next()){
         loadCus.add(new Customer(rst.getString("id"),rst.getString("name"),rst.getString("Address"),rst.getDouble("salary")));
         }
        
         return loadCus;
     }
}
