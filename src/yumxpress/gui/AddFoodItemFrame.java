/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.gui;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import yumxpress.dao.ProductDAO;
import yumxpress.pojo.ProductPojo;
import yumxpress.util.OwnerProfile;
import yumxpress.util.SpoonacularAPI;

/**
 *
 * @author Smart computer
 */
public class AddFoodItemFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddFoodItem
     */private int foodIndex;
     //cnM6&g$#
       private List<ProductPojo> foodList;
    public AddFoodItemFrame() {
        initComponents();
        this.setTitle("Add Food Item Frame");
        this.setLocationRelativeTo(null);
        userNameHii.setText("Hello "+OwnerProfile.getOwnerName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchFood = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblfoodimg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtenterPrice = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        lblleftarrow = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameHii = new javax.swing.JLabel();
        addStaff = new javax.swing.JButton();
        viewFood = new javax.swing.JButton();
        viewStaff = new javax.swing.JButton();
        orderList = new javax.swing.JButton();
        back = new javax.swing.JButton();
        lblRightArrow = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(129, 120, 177));
        jLabel2.setText("ADD FOOD ITEMS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 336, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(129, 120, 177));
        jLabel3.setText("Search Food");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 110, 30));

        txtSearchFood.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(txtSearchFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 310, 35));

        btnsearch.setBackground(new java.awt.Color(102, 255, 102));
        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(129, 120, 177));
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 132, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(129, 120, 177));
        jLabel4.setText("Food Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, 32));

        txtFoodName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 310, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(129, 120, 177));
        jLabel5.setText("Food Image");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 122, 23));
        jPanel3.add(lblfoodimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 310, 210));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(129, 120, 177));
        jLabel7.setText("Enter Price");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, -1));

        txtenterPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtenterPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenterPriceActionPerformed(evt);
            }
        });
        jPanel3.add(txtenterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 501, 310, 40));

        btnAddItem.setBackground(new java.awt.Color(102, 255, 102));
        btnAddItem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddItem.setForeground(new java.awt.Color(129, 120, 177));
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 576, 170, 40));

        lblleftarrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-left-arrow-64.png"))); // NOI18N
        lblleftarrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblleftarrowMouseClicked(evt);
            }
        });
        jPanel3.add(lblleftarrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 66, 60));

        jPanel1.setBackground(new java.awt.Color(129, 120, 177));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N

        userNameHii.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userNameHii.setForeground(new java.awt.Color(255, 255, 255));
        userNameHii.setText("@NULL");

        addStaff.setBackground(new java.awt.Color(153, 255, 102));
        addStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addStaff.setText("Add Staff");
        addStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffActionPerformed(evt);
            }
        });

        viewFood.setBackground(new java.awt.Color(153, 255, 102));
        viewFood.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewFood.setText("View Food");
        viewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFoodActionPerformed(evt);
            }
        });

        viewStaff.setBackground(new java.awt.Color(153, 255, 102));
        viewStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewStaff.setText("View Staff");
        viewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStaffActionPerformed(evt);
            }
        });

        orderList.setBackground(new java.awt.Color(153, 255, 102));
        orderList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        orderList.setText("Order List");
        orderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderListActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(153, 255, 102));
        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(orderList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewFood, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)))
                    .addComponent(userNameHii, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(userNameHii, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(addStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(viewFood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(viewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(orderList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        lblRightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-right-arrow-64.png"))); // NOI18N
        lblRightArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRightArrowMouseClicked(evt);
            }
        });
        jPanel3.add(lblRightArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 330, 70, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffActionPerformed
        // TODO add your handling code here:
        AddDeliveryStaffFrame addStaffFrame=new AddDeliveryStaffFrame();
        addStaffFrame.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_addStaffActionPerformed

    private void viewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStaffActionPerformed
        // TODO add your handling code here\:
        ViewDeliveryStaffFrame vdsf=new ViewDeliveryStaffFrame();
        vdsf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewStaffActionPerformed

    private void orderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderListActionPerformed
        // TODO add your handling code here:
        SellerOrderListFrame olf=new SellerOrderListFrame();
        olf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orderListActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here
     String searchFood=txtSearchFood.getText().trim();
     if(searchFood.isEmpty()){         
         JOptionPane.showMessageDialog(null, "Please type a food name");
         return;     
     }
     try{ 
         searchFood=searchFood.replaceAll(" ", "-");
         foodList=SpoonacularAPI.getAllItemDetailsByName(searchFood);         
         if(foodList.isEmpty()){
              JOptionPane.showMessageDialog(null, "No food details for "+searchFood+" found");              return;
         }          
         foodIndex=0;
         showFoodDetailsByIndex(foodIndex);
         lblleftarrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-left-arrow-64 (1).png")));
         lblRightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-right-arrow-64 (1).png")));
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, "Exception while using API");         
         ex.printStackTrace();
     }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        SellerOptionsFrame sellerOptionFrame=new SellerOptionsFrame();
        sellerOptionFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void lblleftarrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblleftarrowMouseClicked
        // TODO add your handling code here:
        foodIndex--;
        if(foodIndex==-1)
            foodIndex=foodList.size()-1;
        showFoodDetailsByIndex(foodIndex);
    }//GEN-LAST:event_lblleftarrowMouseClicked

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        //double price=Double.parseDouble(txtenterPrice.getText().trim());
        if(txtFoodName.getText().trim().isEmpty()||txtenterPrice.getText().trim().isEmpty()||lblfoodimg.getIcon()==null){
            JOptionPane.showMessageDialog(null,"Please fill All the data");
            return;
        }
        ProductPojo product=foodList.get(foodIndex);
        try{
           double price=Double.parseDouble(txtenterPrice.getText().trim());
           product.setProductPrice(price);
           product.setCompanyId(OwnerProfile.getCompanyId());
           if(ProductDAO.addProduct(product)){
               JOptionPane.showMessageDialog(null, "Product added succesfully");
               foodList.remove(foodIndex);
               if(foodList.isEmpty()){
                   JOptionPane.showMessageDialog(null, "All varities of"+txtFoodName.getText().trim()+" Added");
                   clearAll();
               }
               foodIndex=0;
               return;
           }
            JOptionPane.showMessageDialog(null, " Cant Add Product");
            return;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Exception in DB in AddFoodItem");
            ex.printStackTrace();
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "please insert correct product price");
            ex.printStackTrace();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Error for add Product");
            ex.printStackTrace();
        }
            
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtenterPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenterPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtenterPriceActionPerformed

    private void viewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFoodActionPerformed
        // TODO add your handling code here:
        ViewFoodFrame viewFoodFrame=new ViewFoodFrame();
        viewFoodFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewFoodActionPerformed

    private void lblRightArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRightArrowMouseClicked
        // TODO add your handling code here:
        foodIndex++;
        if (foodIndex >= foodList.size()) {
            foodIndex = 0;
        }
        showFoodDetailsByIndex(foodIndex);
    }//GEN-LAST:event_lblRightArrowMouseClicked

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
            java.util.logging.Logger.getLogger(AddFoodItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFoodItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFoodItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFoodItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFoodItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStaff;
    private javax.swing.JButton back;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblRightArrow;
    private javax.swing.JLabel lblfoodimg;
    private javax.swing.JLabel lblleftarrow;
    private javax.swing.JButton orderList;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtSearchFood;
    private javax.swing.JTextField txtenterPrice;
    private javax.swing.JLabel userNameHii;
    private javax.swing.JButton viewFood;
    private javax.swing.JButton viewStaff;
    // End of variables declaration//GEN-END:variables

private void showFoodDetailsByIndex(int foodIndex) 
{        
        ProductPojo product=foodList.get(foodIndex);
        String foodName=product.getProductName();        
        if(foodName.length()>=50){
        foodName=foodName.substring(0,45)+"...";        
        }
        txtFoodName.setText(foodName);        
        Image img=product.getProductImage();
        img=img.getScaledInstance(lblfoodimg.getWidth(),lblfoodimg.getHeight(),Image.SCALE_SMOOTH);        
        ImageIcon icon=new ImageIcon(img);
        lblfoodimg.setIcon(icon);    
}
private void clearAll(){
    txtFoodName.setText("");
    txtSearchFood.setText("");
    txtenterPrice.setText("");
    lblfoodimg.setIcon(null);
    lblleftarrow.setIcon(null);
    lblRightArrow.setIcon(null);
    txtSearchFood.requestFocus();
}
}

