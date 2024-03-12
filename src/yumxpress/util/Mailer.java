/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import yumxpress.pojo.CustomerPojo;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.StaffPojo;

class MyAuthenticator extends Authenticator {

    private String username, password;

    public MyAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pwdAuth = new PasswordAuthentication(this.username, this.password);
        return pwdAuth;
    }

}

public class Mailer {

    private static Properties prop;

    static {
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    }

    public static void sendMail(StaffPojo staff) throws MessagingException {
        final String username = "yumxpress113@gmail.com";
        final String password = "dbmn ukzv tdka swny";
        MyAuthenticator myAuth = new MyAuthenticator(username, password);
        Session session = Session.getInstance(prop, myAuth);
        Message message = new MimeMessage(session);
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(staff.getEmailId())
        );
        String emailSubject = "Staff Details";

        String emailBody = "Dear " + staff.getStaffName() + ",\n"
                + "\n"
                + "I hope this email finds you well. I am writing to provide you with the necessary staff details as requested. Please find the information below:\n"
                + "\n"
                + "Staff ID: " + staff.getStaffId() + "\n"
                + "Company Name: " + OwnerProfile.getCompanyName() + "\n"
                + "Email ID: " + staff.getEmailId() + "\n"
                + "Staff password: " + PassEncryption.getDecryptedPass(staff.getPassword()) + "\n"
                + "\n"
                + "These details are crucial for internal record-keeping and ensuring efficient communication within the organization.\n"
                + "Best regards,\n"
                + "\n"
                + OwnerProfile.getOwnerName();

        message.setSubject(emailSubject);
        message.setText(emailBody);
        Transport.send(message);
    }
    
    public static void sendMailToCustomer(CustomerPojo customer) throws MessagingException {
        final String username = "yumxpress113@gmail.com"; //emailCredentials.get("emailId");
        final String password = "dbmn ukzv tdka swny";//emailCredentials.get("securityKey");
        MyAuthenticator myAuth = new MyAuthenticator(username, password);
        Session session = Session.getInstance(prop, myAuth);
        Message message = new MimeMessage(session);
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(customer.getEmailId())
        );
        String emailSubject = "Welcome to YumXpress - Your Ultimate Food Ordering Companion!";

        String emailBody = "Dear " + customer.getCustomerName() + ",\n"
                + "\n"
                + "We are happy to have as our esteemed customer. Please find your account details:-\n"
                + "\n"
                + "Customer ID: " + customer.getCustomerId() + "\n"
                + "Your Name: " + customer.getCustomerName() + "\n"
                + "Email ID: " + customer.getEmailId() + "\n"
                + "Customer password: " + PassEncryption.getDecryptedPass(customer.getPassword()) + "\n"
                + "\n"
                + "Thank you for choosing YumXpress. We look forward to serving you delicious meals and making your food ordering experience truly memorable.\n"
                + "Happy Hunger!!\n"
                + "Best regards,\n"
                + "\n"
                + "YumXpress!";

        message.setSubject(emailSubject);
        message.setText(emailBody);
        Transport.send(message);
    }
    
    public static void sendMail(OrderPojo order)throws MessagingException{
        final String username = "yumxpress113@gmail.com";
        final String password = "dbmn ukzv tdka swny";
        MyAuthenticator myAuth = new MyAuthenticator(username, password);
        Session session = Session.getInstance(prop, myAuth);
        Message message = new MimeMessage(session);
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(UserProfile.getEmailId())
        );
        double tax=0.075;
        double taxAmt=order.getProductPrice()*tax;
        double billAmt=order.getProductPrice()+taxAmt;
        Date todayDate=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-mmmm-yyy");
        String orderDate=sdf.format(todayDate);
        String emailSubject = "Order Confirmation Mail";

        String emailBody = "Dear Valued Customer, "+order.getCustomerName()+"Sir/MaM \n\n"
                + "We are delighted to inform you that your order has been successfully placed with us. Please find below the details of your order:\n\n"
                + "Order ID: " + order.getOrderId() + "\n"
                + "Product Name: " + order.getProductName() + "\n"
                + "Company: " + order.getCompanyName() + "\n"
                + "Product Price: " + order.getProductPrice() + "\n"
                + "Tax Amount: " + taxAmt + "\n"
                + "Bill Amount: " + billAmt + "\n"
                + "Delivery Staff Name: " + order.getDeliveryStaffName() + "\n"
                + "OTP: " + order.getOtp() + "\n"
                + "Order Date: " + orderDate + "\n\n"
                + "As Anthony Bourdain once said, 'Good food is very often, even most often, simple food.' We hope you enjoy your delicious meal!\n\n"
                + "Thank you for choosing us.\n\n"
                + "Best regards,\n"+order.getCompanyName();

        message.setSubject(emailSubject);
        message.setText(emailBody);
        Transport.send(message);
    }
}


    