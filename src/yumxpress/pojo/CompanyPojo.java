/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import yumxpress.dao.CompanyDAO;
import yumxpress.util.PassEncryption;

/**
 *
 * @author Smart computer
 */
public class CompanyPojo {

    public CompanyPojo(String companyId, String companyName, String owmerName, String password, String emailId, String securityKey) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.owmerName = owmerName;
        this.password = password;
        this.emailId = emailId;
        this.securityKey = securityKey;
    }
    public CompanyPojo(){
        
    }
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return owmerName;
    }

    public void setOwnerName(String owmerName) {
        this.owmerName = owmerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }
    private String companyId;
    private String companyName;
    private String owmerName;
    private String password;
    private String emailId;
    private String securityKey;
    
  /*public static void main(String arg[])throws SQLException{
            CompanyPojo cmp=new CompanyPojo(CompanyDAO.getNewId(),"burger king","nikita",PassEncryption.getEncryptedPass("admin"),"mohit9@gmail.com","1234");
            if(CompanyDAO.addSeller(cmp))
                JOptionPane.showMessageDialog(null,"Seller added succesfully");
            else
                JOptionPane.showMessageDialog(null,"Seller not added");
    }*/
}
