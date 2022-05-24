package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
	DBUtil db = new DBUtil();
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

        // 코드를 작성하세요.
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String sql = "SELECT id, name, content, regdate from guestbook order by id";
    	
    	try (Connection conn = db.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql);){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					String content = rs.getString(3);
					Date regdate = rs.getDate(4);
					
					Guestbook guestbook = new Guestbook(id, name, content, regdate);
					list.add(guestbook);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return list;
    }

    public void addGuestbook(Guestbook guestbook){
        // 코드를 작성하세요.
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String sql = "INSERT INTO guestbook (id, name, content, regdate) VALUES (id, ?, ?, now())";
 
    	try (Connection conn = db.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, guestbook.getName());
			ps.setString(2, guestbook.getContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
