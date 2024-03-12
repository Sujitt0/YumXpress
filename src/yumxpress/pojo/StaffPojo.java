/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

/**
 *
 * @author Smart computer
 */
public class StaffPojo {
     private String staffId;
    private String CompanyId;
    private String emailId;
    private String password;
    private String staffName;
    
    
    public StaffPojo(String staffId, String CompanyId, String emailId, String password, String staffName) {
        this.staffId=staffId;
        this.CompanyId = CompanyId;
        this.emailId = emailId;
        this.password = password;
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "StaffPojo{" + "staffId=" + staffId + ", CompanyId=" + CompanyId + ", emailId=" + emailId + ", password=" + password + ", staffName=" + staffName + '}';
    }

    
    public StaffPojo(){
        
    }
    
    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
}
