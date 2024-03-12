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
import javax.swing.JOptionPane;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.CustomerPojo;
import yumxpress.pojo.StaffPojo;

/**
 *
 * @author Smart computer
 */
public class StaffDAO {
    public static String getNewId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(staff_Id) from staff");
        rs.next();
        String id=rs.getString(1);
        if(id!=null){
            String new_id=id.substring(4);
            int generated_newid=Integer.parseInt(new_id)+1;
            return "STF-"+generated_newid;
        }
        else{
            return "STF-101";
        }
    }
    
    public static String addStaff(StaffPojo staff) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql="insert into staff values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        staff.setStaffId(getNewId());
        ps.setString(1,staff.getStaffId());
        ps.setString(2,staff.getCompanyId());
        ps.setString(3,staff.getEmailId());
        ps.setString(4,staff.getPassword());
        ps.setString(5,staff.getStaffName());
        if(ps.executeUpdate()==1){
            JOptionPane.showMessageDialog(null,"Staff Added Succesfully");
            return staff.getStaffId();
        }
        else{
           JOptionPane.showMessageDialog(null,"Cant Add Staff Add");
            return null;
        }
    }
    public static List<String> getAllStaffIdByCompanyId(String companyId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select Staff_id from staff where company_id=?");
        ps.setString(1,companyId);
        ResultSet rs=ps.executeQuery();
        List<String> staffList=new ArrayList<>();
        while(rs.next()){
            staffList.add(rs.getString(1));
        }
        return staffList;
    }
    public static StaffPojo getStaffDetailsById(String StaffId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from staff where Staff_id=?");
        ps.setString(1, StaffId);
        ResultSet rs=ps.executeQuery();
        StaffPojo staff=new StaffPojo();
        rs.next();
            staff.setEmailId(rs.getString(3));
            staff.setStaffName(rs.getString(5));
        return staff;
    }
    public static String getRandomStaffId(String companyId)throws SQLException{
        List<String> staffId=getAllStaffIdByCompanyId(companyId);
        if(!staffId.isEmpty()){
        Random random=new Random();
        int i=random.nextInt(staffId.size());
        return staffId.get(i);
        }
        return null;
    }
    public static StaffPojo validate(String emailId,String psw)throws SQLException{
        Connection conn=DBConnection.getConnection();
        StaffPojo staff=null;
        PreparedStatement ps=conn.prepareStatement("Select * from staff where email_id=? and Password=?");
        ps.setString(1,emailId);
        ps.setString(2,psw);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            staff=new StaffPojo();
            staff.setStaffId(rs.getString(1));
            staff.setCompanyId(rs.getString(2));
            staff.setEmailId(rs.getString(3));
            staff.setStaffName(rs.getString(5));
        }
        return staff;
    }
}
