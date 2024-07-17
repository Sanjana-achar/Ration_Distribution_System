/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hp
 */
public class dbOperations {

    
    public static void setDataOrDelete(String Query,String msg){
        
        try{
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.ERROR_MESSAGE);
        }
        // TODO code application logic here
    }
    public static ResultSet getData(String query){
    try {
    Connection con = ConnectionProvider.getCon();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);
    return rs;
   }
    catch(Exception e ) {
     JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.ERROR_MESSAGE);
     return null;
}
   
}

    static void updateData(String update_Transportation_SET_Source_location, String source_location, String destination_location, String delivery_status, int rationshop_id, int shipment_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}


    

   