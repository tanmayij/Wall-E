package pro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
 
/**
 *
 * @author RenownTechnologies
 */
public class NewClass {
    

 public  void send(String uid, String pwd, String phone, String msg) throws Exception {
        if ((uid == null) || (uid.length() == 0)) {
            throw new IllegalArgumentException("User ID should be present.");
        }
 
        uid = URLEncoder.encode(uid, "UTF-8");
 
        if ((pwd == null) || (pwd.length() == 0)) {
            throw new IllegalArgumentException("Password should be present.");
        }
        pwd = URLEncoder.encode(pwd, "UTF-8");
 
        if ((phone == null) || (phone.length() == 0)) {
            throw new IllegalArgumentException("At least one phone number should be present.");
        }
        if ((msg == null) || (msg.length() == 0)) {
            throw new IllegalArgumentException("SMS message should be present.");
        }
        msg = URLEncoder.encode(msg, "UTF-8");
 
        Vector numbers = new Vector();
 
        if (phone.indexOf(59) >= 0) {
            String[] pharr = phone.split(";");
            for (String t : pharr) {
                try {
                    numbers.add(Long.valueOf(t));
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Give proper phone numbers.");
                }
            }
        } else {
            try {
                numbers.add(Long.valueOf(phone));
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Give proper phone numbers.");
            }
        }
 
        if (numbers.size() == 0) {
            throw new IllegalArgumentException("At least one proper phone number should be present to send SMS.");
        }
        String temp = "";
        String content = "username=" + uid + "&password=" + pwd;
        URL u = new URL("http://www.vnssms.in/quicksms/api.php");
        HttpURLConnection uc = (HttpURLConnection) u.openConnection();
        uc.setDoOutput(true);
        uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
        uc.setRequestProperty("Content-Length", String.valueOf(content.length()));
        uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        uc.setRequestProperty("Accept", "*/*");
        uc.setRequestProperty("Referer", "http://www.vnssms.in/quicksms/index.php");
        uc.setRequestMethod("POST");
        uc.setInstanceFollowRedirects(false);
 
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
        pw.print(content);
        pw.flush();
        pw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
 
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }
 
        String cookie = uc.getHeaderField("Set-Cookie");
 
        u = null;
        uc = null;
        for (Iterator localIterator = numbers.iterator(); localIterator.hasNext();) {
            long num = ((Long) localIterator.next()).longValue();
 
            content = "custid=undefined&HiddenAction=instantsms&Action=custfrom450000&login=&pass=&MobNo=" + num + "&textArea=" + msg;
           u = new URL("http://www.vnssms.in/quicksms/api.php?username=maxbulksms&password=12345678&to="+num+"&from=AUCSNW&message="+msg);
            uc = (HttpURLConnection) u.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
            uc.setRequestProperty("Content-Length", String.valueOf(content.getBytes().length));
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uc.setRequestProperty("Accept", "*/*");
            uc.setRequestProperty("Cookie", cookie);
            uc.setRequestMethod("POST");
            uc.setInstanceFollowRedirects(false);
            pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
            pw.print(content);
            pw.flush();
            pw.close();
            br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            while ((temp = br.readLine()) != null);
            br.close();
            u = null;
            uc = null;
        }
 
        u = new URL("http://www.vnssms.in/quicksms/index.php");
        uc = (HttpURLConnection) u.openConnection();
        uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
        uc.setRequestProperty("Accept", "*/*");
        uc.setRequestProperty("Cookie", cookie);
        uc.setRequestMethod("GET");
        uc.setInstanceFollowRedirects(false);
        br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        while ((temp = br.readLine()) != null);
        br.close();
        u = null;
        uc = null;
    }
}
