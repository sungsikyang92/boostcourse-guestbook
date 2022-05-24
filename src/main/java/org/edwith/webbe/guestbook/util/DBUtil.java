package org.edwith.webbe.guestbook.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection(){
        // 본인 database에 맞게끔 수정해주세요.
        return getConnection("jdbc:mysql://localhost:3306/private?useUnicode=true&characterEncoding=utf8&useSSL=false","ssy","1234");
    }

    public static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
