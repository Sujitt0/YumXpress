/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

import java.util.Random;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Smart computer
 */
public class Validator {

    public static boolean isValidEmail(String emailId) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.getInstance().isValid(emailId);
    }
    public static boolean isValidMobileNo(String mobileNo) {
        if(mobileNo.length()!=10){
            return false;
        }
        for(int i=0;i<mobileNo.length();i++){
            if(!Character.isDigit(mobileNo.charAt(i)))
                return false;
        }
        return true;
    }

    public static String getOtp(){
        Random random=new Random();
        StringBuffer OTP=new StringBuffer("");
        for(int i=0;i<6;i++){
            OTP.append(random.nextInt(10));
        }
        return OTP.toString();
    }
}
