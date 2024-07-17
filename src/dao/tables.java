package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class tables {

    public static void main(String[] args) {
        try {
            String Usertable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),password varchar(200),status varchar(20))";

            String adminDetails = "insert into user(name,email,mobileNumber,password,status) values ('Admin','admin@gmail.com','7022589304','admin','true')";
            String managecardholder = "create table Cardholder(Holder_id int AUTO_INCREMENT primary key, Holder_Name varchar(20),Age int, Card_Type varchar(10),Family_members int)";
            
            String RationDealer = "CREATE TABLE RationDealer (" +
                      "Dealer_id int AUTO_INCREMENT PRIMARY KEY, " +
                      "Dealer_Name VARCHAR(20), " +
                      "DealerPhoneNumber VARCHAR(10), " +
                      "CHECK (LENGTH(DealerPhoneNumber) = 10 AND " +
                      "       DealerPhoneNumber REGEXP '^[0-9]{10}$'))";
            
            String RationItem = "CREATE TABLE RationItem (" +
                    "Item_Id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "Item_Name VARCHAR(200), " +
                    "Quantity INT, " +
                    "Price DECIMAL(10,2), " +
                    "Date DATE)";

       String RationShop = "CREATE TABLE RationShop (Shop_Id INT PRIMARY KEY, Shop_Name VARCHAR(20), ShopPhoneNumber VARCHAR(10), Address VARCHAR(200), Opening_Time TIME, Closing_Time TIME)";



            dbOperations.setDataOrDelete(Usertable, "user table created successfully");

            dbOperations.setDataOrDelete(adminDetails, "Admin details added succuessfully");
            dbOperations.setDataOrDelete(managecardholder, "Card Holder Table Created Successfully");
            
            dbOperations.setDataOrDelete(RationDealer, " Dealer Table Created Successfully");
             dbOperations.setDataOrDelete(RationItem, " RationItem Table Created Successfully");
            
            dbOperations.setDataOrDelete(RationShop, " RationShop Table Created Successfully");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
