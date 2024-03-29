/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.gui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import yumxpress.dao.CompanyDAO;
import yumxpress.dao.CustomerDAO;
import yumxpress.pojo.CustomerPojo;
import yumxpress.util.Mailer;
import yumxpress.util.OwnerProfile;
import yumxpress.util.PassEncryption;
import yumxpress.util.Validator;

/**
 *
 * @author Smart computer
 */
public class CustomerRegistrationFrame extends javax.swing.JFrame {

    /**
     * Creates new form CustomerRegistration
     */
    public CustomerRegistrationFrame() {
        initComponents();
        this.setTitle("CustomerRegistrationFrame");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pwd = new javax.swing.JCheckBox();
        txtEmailId = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtMobileNo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnCustomerRegester = new javax.swing.JButton();
        btnCustomerBack = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 138, 255));
        jLabel7.setText("Enter Email Id");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 140, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 138, 255));
        jLabel8.setText("Enter Name:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 140, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 138, 255));
        jLabel9.setText("Password: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 102, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 138, 255));
        jLabel10.setText("Enter Mobile No:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 138, 255));
        jLabel11.setText("Enter Address:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 158, 30));

        pwd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pwd.setForeground(new java.awt.Color(0, 138, 255));
        pwd.setText("Show");
        pwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdMouseClicked(evt);
            }
        });
        jPanel2.add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, -1, -1));

        txtEmailId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 138, 278, 40));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 196, 278, 33));

        txtMobileNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 316, 278, 29));

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 375, 278, 32));

        btnCustomerRegester.setBackground(new java.awt.Color(0, 138, 255));
        btnCustomerRegester.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCustomerRegester.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomerRegester.setText("Register");
        btnCustomerRegester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerRegesterActionPerformed(evt);
            }
        });
        jPanel2.add(btnCustomerRegester, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 496, 165, 40));

        btnCustomerBack.setBackground(new java.awt.Color(0, 138, 255));
        btnCustomerBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCustomerBack.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomerBack.setText("Back");
        btnCustomerBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerBackActionPerformed(evt);
            }
        });
        jPanel2.add(btnCustomerBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 495, 168, 40));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 247, 200, 34));

        jPanel7.setBackground(new java.awt.Color(0, 138, 255));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/login.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Customer");

        jLabel20.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Registration");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel20))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel19)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(31, 31, 31)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIdActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnCustomerBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerBackActionPerformed
        // TODO add your handling code here:
        CustomerLoginFrame customerLoginFrame=new CustomerLoginFrame();
        customerLoginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomerBackActionPerformed

    private void btnCustomerRegesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerRegesterActionPerformed
        // TODO add your handling code here:
        if(!validateInputs()){
            JOptionPane.showMessageDialog(null,"Please Fill All The Details!");
            return;
        }
        if(!Validator.isValidEmail(txtEmailId.getText().trim())){
            JOptionPane.showMessageDialog(null,"Please Enter Valid Email Id");
            return;
        }
        if(!Validator.isValidMobileNo(txtMobileNo.getText().trim())){
            JOptionPane.showMessageDialog(null,"Please Enter Valid MobileNo");
            return;
        }

        try{
            CustomerPojo custmor=new CustomerPojo(CustomerDAO.getNewId(),txtCustomerName.getText().trim(),txtEmailId.getText().trim(),PassEncryption.getEncryptedPass(String.valueOf(txtPassword.getPassword()).trim()),txtAddress.getText().trim(),txtMobileNo.getText().trim());
            if(CustomerDAO.addCustomer(custmor)){
                JOptionPane.showMessageDialog(null,"Customer Added Succesfully");
                Mailer.sendMailToCustomer(custmor);
                JOptionPane.showMessageDialog(null,"Mail Sent To "+txtCustomerName.getText().trim());
                clearAll();
                return;
            }
            JOptionPane.showMessageDialog(null,"Can't Add Customer");
            return;
        }
        catch(SQLException sq){
            JOptionPane.showMessageDialog(null,"DB Error in Customer Regestration Frame");
            return;
        }
        catch(MessagingException msg){
            JOptionPane.showMessageDialog(null,"Mail Error in Customer Regestration Frame");
            return;
        }

    }//GEN-LAST:event_btnCustomerRegesterActionPerformed

    private void pwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdMouseClicked
        // TODO add your handling code here:
        if (pwd.isSelected()) {
            txtPassword.setEchoChar((char) 0);

            pwd.setText("Hide");
        } else {
            txtPassword.setEchoChar('*');
            pwd.setText("Show");

        }
    }//GEN-LAST:event_pwdMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerBack;
    private javax.swing.JButton btnCustomerRegester;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JCheckBox pwd;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private boolean validateInputs(){
        if(txtEmailId.getText().trim().isEmpty()||String.valueOf(txtPassword.getPassword()).trim().isEmpty()||txtCustomerName.getText().trim().isEmpty()||txtMobileNo.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()){
            return false;
        }
        return true;
    }
    private void clearAll() {
        this.txtEmailId.setText("");
        this.txtAddress.setText("");
        this.txtMobileNo.setText("");
        this.txtCustomerName.setText("");
        this.txtPassword.setText("");
        this.txtEmailId.requestFocus();
        
    }
}
