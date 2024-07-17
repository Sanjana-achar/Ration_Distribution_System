/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rationdistribution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rationdistribution.user11;

/**
 *
 * @author hp
 */
public class rationitem extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    public rationitem() {
        initComponents();
        Connect();
        AutoId();
        rationitem_table();
    }
    Connection con;
    PreparedStatement pat;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user11.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rationsystem", "root", "Sanju@0830");
        } catch (SQLException ex) {
            Logger.getLogger(user11.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AutoId() {
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("select MAX(Item_Id) from rationitem");
            rs.next();
            rs.getString("MAX(Item_Id)");
            if (rs.getString("MAX(Item_Id)") == null) {
                jLabel6.setText("ID001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(Item_Id)").substring(2, rs.getString("MAX(Item_Id)").length()));
                id++;
                jLabel6.setText("ID" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(rationitem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void rationitem_table() {
    try {
        pat = con.prepareStatement("SELECT * FROM rationitem");
        rs = pat.executeQuery();

        DefaultTableModel df = (DefaultTableModel) jTable2.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            // Create a Vector to hold the column values for each row
            Vector<Object> rowData = new Vector<>();
            
            // Add each column value to the Vector
            rowData.add(rs.getString("Item_Id"));
            rowData.add(rs.getString("Item_Name"));
            rowData.add(rs.getInt("Quantity"));
            rowData.add(rs.getFloat("Price"));
            rowData.add(rs.getString("Holder_Id"));
            rowData.add(rs.getDate("Date_of_Purchase")); // Add Date_of_Purchase column
            
            // Add the Vector containing row data to the table model
            df.addRow(rowData);
        }

    } catch (SQLException ex) {
        Logger.getLogger(rationitem.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtItemName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHolder_Id = new javax.swing.JTextField();
        txtDate_of_Purchase = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("New Ration Item");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 37));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Item_Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 139, 77, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Item_Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 88, 97, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 179, 65, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Price");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 226, 54, -1));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 30));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view edit delete product.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, 30));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit small.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, 30));
        getContentPane().add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 212, -1));

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 212, -1));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 210, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 80, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_Id", "Item_Name", "Quantity", "Price", "Holder_Id", "Date_of_Purchase"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 660, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Holder_Id");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Date_of_Purchase");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));
        getContentPane().add(txtHolder_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 210, -1));
        getContentPane().add(txtDate_of_Purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
       String Item_Id = jLabel6.getText();
    String Item_Name = txtItemName.getText();
    String Holder_Id = txtHolder_Id.getText(); // Assuming Holder_Id is retrieved from a text field
    java.util.Date date = txtDate_of_Purchase.getDate(); // Assuming txtDate_of_Purchase is a JDateChooser
    java.sql.Date Date_of_Purchase = new java.sql.Date(date.getTime()); // Convert to java.sql.Date

    try {
        int Quantity = Integer.parseInt(txtQuantity.getText());
        float Price = Float.parseFloat(txtPrice.getText());

        // Prepare and execute SQL insert statement
        pat = con.prepareStatement("INSERT INTO rationitem (Item_Id, Item_Name, Quantity, Price, Holder_Id, Date_of_Purchase) VALUES (?, ?, ?, ?, ?, ?)");
        pat.setString(1, Item_Id);
        pat.setString(2, Item_Name);
        pat.setInt(3, Quantity);
        pat.setFloat(4, Price);
        pat.setString(5, Holder_Id);
        pat.setDate(6, Date_of_Purchase);
        pat.executeUpdate();

        // Display success message
        JOptionPane.showMessageDialog(this, "Item inserted successfully");

        // Reset UI components
        AutoId();
        txtItemName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtHolder_Id.setText("");
        txtDate_of_Purchase.setDate(null);
        txtItemName.requestFocus();
        rationitem_table();
        btnAdd.setEnabled(true);
    } catch (SQLException ex) {
        Logger.getLogger(rationitem.class.getName()).log(Level.SEVERE, null, ex);
    }
         

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddKeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
                                          
    // TODO add your handling code here:
                                       
    DefaultTableModel d1 = (DefaultTableModel) jTable2.getModel();
    int selectIndex = jTable2.getSelectedRow();
    if (selectIndex != -1) { // Check if a row is selected
        jLabel6.setText(d1.getValueAt(selectIndex, 0).toString());
        txtItemName.setText(d1.getValueAt(selectIndex, 1).toString());
        txtQuantity.setText(d1.getValueAt(selectIndex, 2).toString());
        txtPrice.setText(d1.getValueAt(selectIndex, 3).toString());
        txtHolder_Id.setText(d1.getValueAt(selectIndex, 4).toString());

        // Check if the value is null before parsing
        if (d1.getValueAt(selectIndex, 5) != null) {
            String dateString = d1.getValueAt(selectIndex, 5).toString();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = dateFormat.parse(dateString);
                txtDate_of_Purchase.setDate(date);
            } catch (ParseException ex) {
                // Handle parsing exception
                ex.printStackTrace();
            }
        }
        
        btnAdd.setEnabled(false);
    
}


    }//GEN-LAST:event_jTable2MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        
    String Item_Name = txtItemName.getText();
    String Item_Id = jLabel6.getText();
    String Holder_Id = txtHolder_Id.getText(); // Assuming Holder_Id is retrieved from a text field
    java.util.Date date = txtDate_of_Purchase.getDate(); // Assuming txtDate_of_Purchase is a JDateChooser
    java.sql.Date Date_of_Purchase = new java.sql.Date(date.getTime()); // Convert to java.sql.Date

    try {
        int Quantity = Integer.parseInt(txtQuantity.getText());
        float Price = Float.parseFloat(txtPrice.getText());

        // Prepare and execute SQL update statement
        pat = con.prepareStatement("UPDATE rationitem SET Item_Name=?, Quantity=?, Price=?, Holder_Id=?, Date_of_Purchase=? WHERE Item_Id=?");
        pat.setString(1, Item_Name);
        pat.setInt(2, Quantity);
        pat.setFloat(3, Price);
        pat.setString(4, Holder_Id);
        pat.setDate(5, Date_of_Purchase);
        pat.setString(6, Item_Id);
        pat.executeUpdate();

        // Display success message
        JOptionPane.showMessageDialog(this, "Item details updated successfully");

        // Reset UI components
        AutoId();
        txtItemName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtHolder_Id.setText("");
        txtDate_of_Purchase.setDate(null);
        txtItemName.requestFocus();
        rationitem_table();
        btnAdd.setEnabled(true);
    } catch (SQLException ex) {
        Logger.getLogger(rationitem.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        String Item_Id = jLabel6.getText();
        try {

            // Now you can use 'quantity' and 'price' variables for further processing
        } catch (NumberFormatException e) {
            // Handle the case where input is not a valid integer or float
            // For example, display an error message to the user or log the error
            e.printStackTrace(); // or logger.error("Invalid input", e);
        }

        try {

            pat = con.prepareStatement("delete from  rationitem where Item_Id=?");

            pat.setString(1, Item_Id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Item deleted successfully");
            AutoId();
            txtItemName.setText("");
            txtQuantity.setText("");
            txtPrice.setText("");
            txtHolder_Id.setText("");
            txtDate_of_Purchase.setDate(null);
            txtItemName.requestFocus();
            rationitem_table();
            btnAdd.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(rationitem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(rationitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rationitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rationitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rationitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rationitem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser txtDate_of_Purchase;
    private javax.swing.JTextField txtHolder_Id;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}