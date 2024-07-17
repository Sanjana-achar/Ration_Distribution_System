/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author hp
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rationsystem?useSLL=false","root","Sanju@0830");
            
            if(con!=null){
                System.out.println("successfully connected");
            }
            return con;
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("not successfully connected");
            return null;
        }
    }
}
