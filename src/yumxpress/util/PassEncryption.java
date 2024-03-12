/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

import java.util.Base64;

/**
 *
 * @author Smart computer
 */
public class PassEncryption {
    public static String getEncryptedPass(String pwd){
        Base64.Encoder en=Base64.getEncoder();
        return en.encodeToString(pwd.getBytes());
    }
    public static String getDecryptedPass(String pwd){
        Base64.Decoder dc=Base64.getDecoder();
        byte arr[]=dc.decode(pwd.getBytes());
        return new String(arr);
    }
//    Farzi$scam@172003
}
