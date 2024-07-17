
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.User;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author hp
 */
public class UserDao {
    public static void save(User user){
        
       String query="insert into user(name,email,mobileNumber,password,status)values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getPassword()+"','false')";
        
       dbOperations.setDataOrDelete(query,"Registered Successfully!Wait for the admin approval");
    
    }
    
   public static User login(String email,String password) {
    User user = null;
     try{
         ResultSet rs = dbOperations.getData("select * from user where email ='"+email+"' and password='"+password+"'");
         while(rs.next()) {
           user=new User();
           user.setStatus(rs.getString("status"));
         }
    }
        
    catch(Exception e ){
    JOptionPane.showMessageDialog(null,e);
   }
    return user;
}
}


    

