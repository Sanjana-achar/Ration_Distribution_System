/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rationdistribution;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class RationShopp extends javax.swing.JFrame {

    /**
     * Creates new form RationShopp
     */
    public RationShopp() {
        initComponents();
        Connect();
        AutoId();
        rationshop_table();
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
            rs = s.executeQuery("select MAX(Shop_Id) from rationshoptable");
            rs.next();
            rs.getString("MAX(Shop_Id)");
            if (rs.getString("MAX(Shop_Id)") == null) {
                jLabel9.setText("SH001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(Shop_Id)").substring(2, rs.getString("MAX(Shop_Id)").length()));
                id++;
                jLabel9.setText("SH" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RationShopp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void rationshop_table(){
        

        try {
            pat=con.prepareStatement("select * from rationshoptable");
            rs=pat.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("Shop_Id"));
                    v2.add(rs.getString("Shop_Name"));
                    v2.add(rs.getInt("Shop_Phone_Number"));
                     v2.add(rs.getString("Dealer_Id"));
                }
                df.addRow(v2);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RationShopp.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel9 = new javax.swing.JLabel();
        txtShopName = new javax.swing.JTextField();
        txtShopPhoneNumber = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtDealer_Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Shop Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Shop Phone Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Shop_Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Dealer_Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 70, -1));
        getContentPane().add(txtShopName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 210, -1));
        getContentPane().add(txtShopPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 210, -1));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addd.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-16.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 120, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-24.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 110, 40));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit small.png"))); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 120, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shop_Id", "Shop_Name", "Shop_Phone_Number", "Dealer_Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 510, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Ration Shop Details");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, 40));
        getContentPane().add(txtDealer_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 210, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                                      
    // TODO add your handling code here:
String Shop_Id = jLabel9.getText();
    String Shop_Name = txtShopName.getText();
    String Shop_Phone_Number = txtShopPhoneNumber.getText(); // Changed to String
    String Dealer_Id = txtDealer_Id.getText();

    // Validate phone number
   
        try {
            pat = con.prepareStatement("insert into rationshoptable(Shop_Id,Shop_Name,Shop_Phone_Number,Dealer_Id)values(?,?,?,?)");
            pat.setString(1, Shop_Id);
            pat.setString(2, Shop_Name);
            pat.setString(3, Shop_Phone_Number);
            pat.setString(4, Dealer_Id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ration Shop Deatails inserted successfully");
            AutoId();
            txtShopName.setText("");
            txtShopPhoneNumber.setText("");
            txtDealer_Id.setText("");
            txtShopName.requestFocus();
            rationshop_table();
        } catch (SQLException ex) {
            Logger.getLogger(RationShopp.class.getName()).log(Level.SEVERE, null, ex);
        }
    


    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        jLabel9.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtShopName.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtShopPhoneNumber.setText(d1.getValueAt(SelectIndex, 2).toString());
         txtDealer_Id.setText(d1.getValueAt(SelectIndex, 3).toString());
         btnAdd.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String Shop_Name = txtShopName.getText();
    String Shop_Phone_Number = txtShopPhoneNumber.getText(); // Changed to String
    String Dealer_Id = txtDealer_Id.getText();
    String Shop_Id = jLabel9.getText();

    try {
        // TODO add your handling code here:
        pat = con.prepareStatement("update rationshoptable set Shop_Name=?,Shop_Phone_Number=?,Dealer_Id=? where Shop_Id=?");

        pat.setString(1, Shop_Name);
        pat.setString(2, Shop_Phone_Number);
        pat.setString(3, Dealer_Id);
        pat.setString(4, Shop_Id);
        pat.executeUpdate();
        JOptionPane.showMessageDialog(this, "Ration Shop Details updated successfully");
        AutoId();
        txtShopName.setText("");
        txtShopPhoneNumber.setText("");
        txtDealer_Id.setText("");

        rationshop_table();
        btnAdd.setEnabled(true);

    } catch (SQLException ex) {
        Logger.getLogger(RationShopp.class.getName()).log(Level.SEVERE, null, ex);
    }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String Shop_Id = jLabel9.getText();

        try {
            // TODO add your handling code here:
            pat = con.prepareStatement("delete from rationshoptable where Shop_Id=?");
           
            
             pat.setString(1, Shop_Id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this,"Ration Shop Details deleted successfully");
            AutoId();
            txtShopName.setText("");
            txtShopPhoneNumber.setText("");
            txtDealer_Id.setText("");
           
            rationshop_table();
            btnAdd.setEnabled(true);
            

        } catch (SQLException ex) {
            Logger.getLogger(RationShopp.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(RationShopp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RationShopp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RationShopp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RationShopp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RationShopp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDealer_Id;
    private javax.swing.JTextField txtShopName;
    private javax.swing.JTextField txtShopPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
