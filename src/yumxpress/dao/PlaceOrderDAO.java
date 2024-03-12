/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.PlaceOrderPojo;

/**
 *
 * @author Smart computer
 */
public class PlaceOrderDAO {
    public static String getNewId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(order_Id) from orders");
        rs.next();
        String id=rs.getString(1);
        if(id!=null){
            String new_id=id.substring(4);
            int generated_newid=Integer.parseInt(new_id)+1;
            return "ORD-"+generated_newid;
        }
        else{
            return "ORD-101";
        }
    }
    public static String placeOrder(PlaceOrderPojo placeOrder) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        placeOrder.setOrderId(getNewId());
        ps.setString(1, placeOrder.getOrderId());
        ps.setString(2, placeOrder.getProductId());
        ps.setString(3, placeOrder.getCustomerId());
        ps.setString(4, placeOrder.getStaffId());
        ps.setString(5, "");
        ps.setString(6, "ORDERED");
        ps.setString(7, placeOrder.getCompanyId());
        Random rand = new Random();
        int otp = rand.nextInt(1000);
        ps.setInt(8, otp);
        if (ps.executeUpdate() == 1) {
            return placeOrder.getOrderId();
        }
        return null;
    }
    public static boolean placeOrderforCart(PlaceOrderPojo placeOrder) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        placeOrder.setOrderId(getNewId());
        ps.setString(1, placeOrder.getOrderId());
        ps.setString(2, placeOrder.getProductId());
        ps.setString(3, placeOrder.getCustomerId());
        ps.setString(4, placeOrder.getStaffId());
        ps.setString(5, "");
        ps.setString(6, "CART");
        ps.setString(7, placeOrder.getCompanyId());
        Random rand = new Random();
        int otp = rand.nextInt(1000);
        ps.setInt(8, otp);
        return ps.executeUpdate() == 1;
    }
    public static OrderPojo getOrderDetailsByOrderId(String orderId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT c.customer_name, c.address, s.staff_name,c.email_id, c.mobile_no, co.company_name, p.product_name, p.product_price, o.otp "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN companies co ON o.company_id = co.company_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "JOIN staff s ON o.staff_id = s.staff_id "
                + "WHERE o.order_id = ?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            OrderPojo order = new OrderPojo();
            order.setOrderId(orderId);
            order.setCustomerName(rs.getString("customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setCompanyName(rs.getString("company_name"));
            order.setCompanyEmailId(rs.getString("Email_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setOtp(rs.getInt("otp"));
            return order;

        }
        return null;
    }

    
    public static List<OrderPojo> getNewOrderForStaff(String staffId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql ="SELECT o.order_id, o.otp, p.product_name, p.product_price, c.customer_name,c.address, c.mobile_no "
                    + "FROM orders o "
                    + "JOIN products p ON o.product_id = p.product_id "
                    + "JOIN customers c ON o.customer_id = c.customer_id "
                    + "WHERE o.staff_id = ? "
                    + "AND o.status = 'ORDERED' "
                    + "ORDER BY o.order_id DESC";

        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,staffId);
        System.out.println("staff id set ho gyi");
        ResultSet rs=ps.executeQuery();
        System.out.println("execute query chl gyi");
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("Product_Name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setCustomerName(rs.getString("Customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setOtp(rs.getInt("otp"));
            orderList.add(order);
        }
        System.out.println("send ordelist");
        return orderList;
    }
    public static boolean confirmOrder(String orderId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update orders set status='DELIVERED' where order_id=?");
         ps.setString(1, orderId);
         return ps.executeUpdate()==1;
    }
    public static List<OrderPojo> getDeliveredOrderForStaff(String staffId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql ="SELECT o.order_id, p.product_name, p.product_price, c.customer_name,c.address,o.REVIEW "
                    + "FROM orders o "
                    + "JOIN products p ON o.product_id = p.product_id "
                    + "JOIN customers c ON o.customer_id = c.customer_id "
                    + "WHERE o.staff_id = ? "
                    + "AND o.status = 'DELIVERED' "
                    + "ORDER BY o.order_id DESC";

        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,staffId);
        System.out.println("staff id set ho gyi");
        ResultSet rs=ps.executeQuery();
        System.out.println("execute query chl gyi");
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("Product_Name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setCustomerName(rs.getString("Customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setReview(rs.getString("REVIEW"));
            orderList.add(order);
        }
        System.out.println("send ordelist");
        return orderList;
    }
    
    public static List<OrderPojo> getDeliveredOrderForCompany(String companyId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql ="SELECT " +
             "    p.PRODUCT_NAME, " +
             "    p.PRODUCT_PRICE, " +
             "    c.CUSTOMER_NAME, " +
             "    s.STAFF_NAME, " +
             "    c.ADDRESS, " +
             "    o.REVIEW " +
             "FROM " +
             "    products p " +
             "JOIN " +
             "    staff s ON p.COMPANY_ID = s.COMPANY_ID " +
             "JOIN " +
             "    orders o ON o.STAFF_ID = s.STAFF_ID AND o.PRODUCT_ID = p.PRODUCT_ID " +
             "JOIN " +
             "    customers c ON c.CUSTOMER_ID = o.CUSTOMER_ID " +
             "WHERE " +
             "    p.COMPANY_ID = ? AND " +
             "    o.STATUS = 'DELIVERED'";


        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,companyId);
        ResultSet rs=ps.executeQuery();
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setProductName(rs.getString(1));
            order.setProductPrice(rs.getDouble(2));
            order.setCustomerName(rs.getString(3));
            order.setDeliveryStaffName(rs.getString(4));
            order.setCustomerAddress(rs.getString(5));
            order.setReview(rs.getString(6));
            orderList.add(order);
        }
        return orderList;
    }
    
    
    public static List<OrderPojo> getCartOrderForCustomer(String customerId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         String sql= "SELECT o.ORDER_ID, p.PRODUCT_NAME, p.PRODUCT_PRICE " +
                         "FROM orders o " +
                         "JOIN products p ON o.PRODUCT_ID = p.PRODUCT_ID " +
                         "WHERE o.CUSTOMER_ID = ? AND o.STATUS = 'CART'";
        /*"SELECT " +
             "    p.PRODUCT_NAME, " +
             "    p.PRODUCT_PRICE " +
             "FROM " +
             "    products p " +
             "JOIN " +
             "    orders o ON o.PRODUCT_ID = p.PRODUCT_ID " +
             "JOIN " +
             "    customers c ON c.CUSTOMER_ID = o.CUSTOMER_ID " +
             "WHERE " +
             "    c.CUSTOMER_ID = ? AND " +
             "    o.STATUS = 'CART'";*/



        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,customerId);
        ResultSet rs=ps.executeQuery();
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setProductName(rs.getString(2));
            order.setProductPrice(rs.getDouble(3));
            order.setOrderId(rs.getString(1));
            orderList.add(order);
        }
        return orderList;
    }
    
    public static List<OrderPojo> getDeliveredOrderForCustomer(String customerId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql = "SELECT o.ORDER_ID, p.PRODUCT_NAME, p.PRODUCT_PRICE, s.STAFF_NAME ," +
                         "c.COMPANY_NAME, cu.ADDRESS, o.REVIEW " +
                         "FROM orders o " +
                         "JOIN products p ON o.PRODUCT_ID = p.PRODUCT_ID " +
                         "JOIN staff s ON o.STAFF_ID = s.STAFF_ID " +
                         "JOIN companies c ON o.COMPANY_ID = c.COMPANY_ID " +
                         "JOIN customers cu ON o.CUSTOMER_ID = cu.CUSTOMER_ID " +
                         "WHERE o.STATUS = 'DELIVERED' AND o.CUSTOMER_ID = ?";
    

        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,customerId);
        ResultSet rs=ps.executeQuery();
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setOrderId(rs.getString(1));
            order.setProductName(rs.getString(2));
            order.setProductPrice(rs.getDouble(3));
            order.setDeliveryStaffName(rs.getString(4));
            order.setCompanyName(rs.getString(5));
            order.setCustomerAddress(rs.getString(6));
            order.setReview(rs.getString(7));
            orderList.add(order);
        }
        return orderList;
    }
    
    public static List<OrderPojo> getCancelledOrderForCustomer(String customerId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql = "SELECT o.ORDER_ID, p.PRODUCT_NAME, p.PRODUCT_PRICE, s.STAFF_NAME ," +
             "cu.ADDRESS " +  
             "FROM orders o " +
             "JOIN products p ON o.PRODUCT_ID = p.PRODUCT_ID " +
             "JOIN staff s ON o.STAFF_ID = s.STAFF_ID " +
             "JOIN companies c ON o.COMPANY_ID = c.COMPANY_ID " +
             "JOIN customers cu ON o.CUSTOMER_ID = cu.CUSTOMER_ID " +
             "WHERE o.STATUS = 'CANCELLED' AND o.CUSTOMER_ID = ?";


        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,customerId);
        ResultSet rs=ps.executeQuery();
        List<OrderPojo>orderList=new ArrayList<>();
        while(rs.next()){
            OrderPojo order=new OrderPojo();
            order.setOrderId(rs.getString(1));
            order.setProductName(rs.getString(2));
            order.setProductPrice(rs.getDouble(3));
            order.setDeliveryStaffName(rs.getString(4));
            order.setCustomerAddress(rs.getString(5));
            orderList.add(order);
        }
        return orderList;
    }
    
    /*public static boolean updateOrderStatusCart(String productId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update orders set status='CART' where product_id=?");
         ps.setString(1, productId);
         return ps.executeUpdate()==1;
    }*/
    public static boolean updateOrderStatusOrdered(String orderId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update orders set status='ORDERED' where order_id=?");
         ps.setString(1, orderId);
         return ps.executeUpdate()==1;
    }
    public static boolean updateOrderStatusCancelled(String orderId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update orders set status='CANCELLED' where order_id=?");
         ps.setString(1, orderId);
         return ps.executeUpdate()==1;
    }
    
    public static boolean setReviewForOrderId(String OrderId,String review)throws SQLException{
        Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update orders set Review=? where Order_Id=?");
         ps.setString(1,review );
         ps.setString(2, OrderId);
         return ps.executeUpdate()==1;
    }
   /*public static List<OrderPojo> getDeliveredOrderForCustomer(String customerId)throws SQLException{
       
   }*/
}
