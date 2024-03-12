/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author Smart computer
 */
public class ProductDAO {
    public static String getNewId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(product_Id) from products");
        rs.next();
        String id=rs.getString(1);
        if(id!=null){
            String new_id=id.substring(4);
            int generated_newid=Integer.parseInt(new_id)+1;
            return "PRD-"+generated_newid;
        }
        else{
            return "PRD-101";
        }
    }
    //ImageObserverinterface for width,height end graphics "NULL";
    //spoonacular API
    public static boolean addProduct(ProductPojo product)throws SQLException, IOException{
        
        /* STEPS==
         1. We first convert the Image Object we received from API into bufferimageobject because b ufferimage uses RAM buffers
           so is much faster compared to raw image object.
         
         2. We Than Draw the image Object inside BufferImageobject using the class Graphics by calling Graphics method called draw image
         
         3. Since we Cannot write BufferImage in the DB so we convert it into a byte array. This is done by 2 classes
           which are ByteArrayOutputStream and ImageIO.
            Since we get ByteArrayOutputStream object, the next task is to convert it into byte[] and this is done using
            the method toByteArray() of  ByteArrayOutputStream class.
        
        4.This byte[] into objectofbytearrayinput stram class bcs the method setBinaryStream() of PrepareStatment  object does not 
         directly accept a byte[]. Rather it wants an inputStream object.Since byteArrayInputStream is child class of InputStram we
        can pass its objects asargument to setBinaryStream.
        
        */
        
        
        //Convert Image to BUffer image
        BufferedImage bufferedImage = new BufferedImage(product.getProductImage().getWidth(null),product.getProductImage().getHeight(null),BufferedImage.TYPE_INT_RGB);
        
        //Draw the BufferImage      
        Graphics gf=bufferedImage.getGraphics();
        gf.drawImage(product.getProductImage(),0,0,null);
        
        //Convert BufferImage into byte[] array 
        ByteArrayOutputStream baos=new ByteArrayOutputStream();//Byte ke array ka objest oriented representation hai
        ImageIO.write( bufferedImage,product.getProductImageType(),baos);
        byte[] imageData = baos.toByteArray();
        ByteArrayInputStream bais=new ByteArrayInputStream(imageData);
        
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?)");
        ps.setString(1, getNewId());
        ps.setString(2, product.getCompanyId());
        ps.setString(3,product.getProductName());
        ps.setDouble(4, product.getProductPrice());
        ps.setBinaryStream(5,bais,imageData.length);
        return ps.executeUpdate()>0;
    }    
   public static Map<String,ProductPojo> getProductDetailsByCompanyId(String companyId)throws SQLException,IOException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Products where company_Id=?");
        ps.setString(1,companyId);
        ResultSet rs=ps.executeQuery();
        Map<String,ProductPojo> productDetails=new HashMap<>();
        while(rs.next()){
            ProductPojo pro=new ProductPojo();
            pro.setProductName(rs.getString(3));
            pro.setProductPrice(rs.getDouble(4));
            pro.setCompanyId(rs.getString(2));
            InputStream inputStream = rs.getBinaryStream(5);
            
            //Convert InputStream to buffer image
            BufferedImage bufferedImage=ImageIO.read(inputStream);
            
            //Convert BufferedImage to Image
            Image image =bufferedImage;
            pro.setProductImage(image);
            
            productDetails.put(pro.getProductName(), pro);
        }
        return productDetails;
    }
    
    public static List<ProductPojo> getAllProducts(String companyId)throws SQLException,IOException{
         Connection conn=DBConnection.getConnection();
         List<ProductPojo> productDetails=new ArrayList<>();
         PreparedStatement ps;
         if(companyId.equalsIgnoreCase("ALL")){
           ps=conn.prepareStatement("Select * from products");   
         }
         else{
             ps=conn.prepareStatement("Select * from products where company_id=?");
             ps.setString(1, companyId);
         }
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
         ProductPojo pro=new ProductPojo();
         pro.setProductId(rs.getString(1));
         pro.setCompanyId(rs.getString(2));
         pro.setProductName(rs.getString(3));
         pro.setProductPrice(rs.getDouble(4));
         InputStream inputStream = rs.getBinaryStream(5);
            
            //Convert InputStream to buffer image
         BufferedImage bufferedImage=ImageIO.read(inputStream);
            
            //Convert BufferedImage to Image
         Image image =bufferedImage;
         pro.setProductImage(image);
            
         productDetails.add(pro);
       }
         return productDetails;
    }
    
}
