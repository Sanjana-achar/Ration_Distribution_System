/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rationdistribution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class RationShopDealer extends javax.swing.JFrame {

    /**
     * Creates new form RationShopDealer
     */
    public RationShopDealer() {
        initComponents();
        Connect();
        AutoId();
        rationdealer_table();
        
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
            rs = s.executeQuery("select MAX(Dealer_Id) from rationdealer");
            rs.next();
            rs.getString("MAX(Dealer_Id)");
            if (rs.getString("MAX(Dealer_Id)") == null) {
                jLabel6.setText("DL101");
                
            } else {
                long id = Long.parseLong(rs.getString("MAX(Dealer_Id)").substring(2, rs.getString("MAX(Dealer_Id)").length()));
                id++;
                jLabel6.setText("ID" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RationShopDealer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void rationdealer_table() {
        try {
            pat = con.prepareStatement("select * from rationdealer");
            rs = pat.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("Dealer_Id"));
                    v2.add(rs.getString("Dealer_Name"));
                    v2.add(rs.getString("Dealer_Phone_Number"));
                }
                df.addRow(v2);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RationShopDealer.class.getName()).log(Level.SEVERE, null, ex);
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
        txtDealer_Name = new javax.swing.JTextField();
        txtDealerPhoneNumber = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Ration Dealer Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 330, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Dealer_Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Dealer_Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("Dealer PhoneNumber");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 160, -1));
        getContentPane().add(txtDealer_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 290, -1));

        txtDealerPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDealerPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtDealerPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 290, -1));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addd.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-24.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, 30));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit small.png"))); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dealer_Id", "Dealer_Name", "Dealer_PhoneNumber"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("View of Ration Dealer Details");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 280, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDealerPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDealerPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDealerPhoneNumberActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        // TODO add your handling code here:
                                              
    // TODO add your handling code here:
    // TODO add your handling code here:
    String Dealer_Id = jLabel6.getText();
    String Dealer_Name = txtDealer_Name.getText();
    String Dealer_Phone_Number = txtDealerPhoneNumber.getText();
    
    if (Dealer_Phone_Number.length() != 10) {
        JOptionPane.showMessageDialog(this, "Please enter a valid phone number (10 digits).");
        return; // Stop further execution of the method
    }
    
    try {
        pat = con.prepareStatement("insert into rationdealer(Dealer_Id,Dealer_Name,Dealer_Phone_Number)values(?,?,?)");
        pat.setString(1, Dealer_Id);
        pat.setString(2, Dealer_Name);
        pat.setString(3, Dealer_Phone_Number);
        pat.executeUpdate();
        JOptionPane.showMessageDialog(this, "Dealer details inserted successfully");
        AutoId();
        txtDealer_Name.setText("");
        txtDealerPhoneNumber.setText("");
        txtDealer_Name.requestFocus();
        rationdealer_table();
        
    } catch (SQLException ex) {
        Logger.getLogger(RationShopDealer.class.getName()).log(Level.SEVERE, null, ex);
    }



    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        jLabel6.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtDealer_Name.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtDealerPhoneNumber.setText(d1.getValueAt(SelectIndex, 2).toString());
        btnAdd.setEnabled(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        String Dealer_Name = txtDealer_Name.getText();
        String Dealer_Phone_Number = txtDealerPhoneNumber.getText();
        
        String Dealer_Id = jLabel6.getText();
        
        try {
    pat = con.prepareStatement("UPDATE rationdealer SET Dealer_Name=?, Dealer_Phone_Number=? WHERE Dealer_Id=?");
    pat.setString(1, Dealer_Name);
    pat.setString(2, Dealer_Phone_Number); // Assuming Dealer_Phone_Number is a string
    pat.setString(3, Dealer_Id);
    
    int rowsAffected = pat.executeUpdate();
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(this, "Dealer details updated successfully");
        AutoId();
        txtDealer_Name.setText("");
        txtDealerPhoneNumber.setText("");
        txtDealer_Name.requestFocus();
        rationdealer_table();
        btnAdd.setEnabled(true);
    } else {
        JOptionPane.showMessageDialog(this, "No records updated. Dealer Id not found.");
    }
} catch (SQLException ex) {
    Logger.getLogger(RationShopDealer.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Error updating dealer details: " + ex.getMessage());
    ex.printStackTrace(); // Print the stack trace for detailed error information
}

        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        String Dealer_Id = jLabel6.getText();
        
        try {
    pat = con.prepareStatement("delete from rationdealer where Dealer_Id=?");
     // Assuming Dealer_Phone_Number is a string
    pat.setString(1, Dealer_Id);
    
    int rowsAffected = pat.executeUpdate();
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(this, "Dealer details updated successfully");
        AutoId();
        txtDealer_Name.setText("");
        txtDealerPhoneNumber.setText("");
        txtDealer_Name.requestFocus();
        rationdealer_table();
        btnAdd.setEnabled(true);
    } else {
        JOptionPane.showMessageDialog(this, "No records updated. Dealer Id not found.");
    }
} catch (SQLException ex) {
    Logger.getLogger(RationShopDealer.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Error updating dealer details: " + ex.getMessage());
    ex.printStackTrace(); // Print the stack trace for detailed error information
}

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(RationShopDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RationShopDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RationShopDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RationShopDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RationShopDealer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDealerPhoneNumber;
    private javax.swing.JTextField txtDealer_Name;
    // End of variables declaration//GEN-END:variables
}