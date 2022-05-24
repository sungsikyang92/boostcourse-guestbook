package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 코드를 작성하세요.
    	response.setContentType("text/html;charset=UTF-8");
    	
    	GuestbookDao guestbookDao = new GuestbookDao();
    	System.out.println("dao 만들어지나요?" + guestbookDao);
    	List<Guestbook> booklist = guestbookDao.getGuestbooks();

    	System.out.println("방명록 가져오나");
    	for(int i = 0; i<booklist.size(); i++) {
    		for(Guestbook gb : booklist) {
    			System.out.println(gb);
    		}
    	}
    	request.setAttribute("booklist", booklist);
    	
    	request.getRequestDispatcher("guestbooks.jsp").forward(request, response);
    	
    }

}
