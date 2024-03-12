/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.CompanyPojo;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author Smart computer
 */
public class CompanyDAO {
    public static String getNewId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(company_Id) from Companies");
        rs.next();
        String id=rs.getString(1);
        if(id!=null){
            String new_id=id.substring(4);
            int generated_newid=Integer.parseInt(new_id)+1;
            return "CMP-"+generated_newid;
        }
        else{
            return "CMP-101";
        }
    }
    public static boolean addSeller(CompanyPojo e)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql="insert into Companies(COMPANY_ID,COMPANY_NAME,OWNER_NAME,PASSWORD,STATUS,EMAIL_ID,SECURITY_KEY)values(?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,e.getCompanyId());
        ps.setString(2,e.getCompanyName());
        ps.setString(3,e.getOwnerName());
        ps.setString(4,e.getPassword());
        ps.setString(5,"ACTIVE");
        ps.setString(6,e.getEmailId());
        ps.setString(7,e.getSecurityKey());
        return ps.executeUpdate()==1;
    }
    public static CompanyPojo validate(String comp_name,String psw)throws SQLException{
        Connection conn=DBConnection.getConnection();
        CompanyPojo cmp_pojo=null;
        PreparedStatement ps=conn.prepareStatement("Select * from companies where company_name=? and Password=?");
        ps.setString(1,comp_name);
        ps.setString(2,psw);
        //ps.setString(3,st);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            cmp_pojo=new CompanyPojo();
            cmp_pojo.setCompanyId(rs.getString(1));
            cmp_pojo.setOwnerName(rs.getString(3));
            cmp_pojo.setCompanyName(rs.getString(2));
        }
        return cmp_pojo;
    }
    
    public static Map<String, String> getEmailCredentialsByCompanyId(String CompanyID)throws SQLException{
        System.out.println("yha companyDao me enter hua");
        HashMap<String,String> map=new HashMap<>();
        Connection conn=DBConnection.getConnection();
        System.out.println("yha companyDao me hu connection opn hua");
        PreparedStatement ps=conn.prepareStatement("Select email_id,security_key from companies where company_id=?");
        System.out.println("yha companyDao me hu");
        ps.setString(1,CompanyID);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            map.put("emailId",rs.getString(1));
            System.out.println("1 par ye he="+rs.getString(1));
            map.put("securityKey",rs.getString(2));//email securitykey
        }
        System.out.println("return hone ke phle"+map);
        return map;
    }
     public static Map<String, String> getAllSellerDetails()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select company_id,company_name from companies where company_id in(select company_id from products)");
        HashMap<String,String> sellerDetails=new HashMap<>();
        while(rs.next()){
            sellerDetails.put(rs.getString(2),rs.getString(1));
        }
        return sellerDetails;
    }
    
}

    // factory method are those static method which returns its object.