/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

/**
 *
 * @author Smart computer
 */

public class UserProfile {
    
    private static String userName;
    private static String userId;
    private static String EmailId;
    private static String password;
    private static String address;
    private static String mobileno;
    
    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserProfile.userId = userId;
    }

    public static String getEmailId() {
        return EmailId;
    }

    public static void setEmailId(String EmailIs) {
        UserProfile.EmailId = EmailIs;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserProfile.password = password;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        UserProfile.address = address;
    }

    public static String getMobileno() {
        return mobileno;
    }

    public static void setMobileno(String mobileno) {
        UserProfile.mobileno = mobileno;
    }
}
