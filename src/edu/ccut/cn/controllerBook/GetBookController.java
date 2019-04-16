package edu.ccut.cn.controllerBook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ccut.cn.servicesBook.BookOperation;

/**
 * Servlet implementation class GetBookController
 */
@WebServlet("/GetBookController")
public class GetBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("bookName");
		
	    System.out.println("控制器中的bookName"+bookName);
	    BookOperation bookOperation = new BookOperation();
	    List  list = bookOperation.getBook(bookName);
	    if (list!=null) {
	    	request.setAttribute("list", list);
	    	request.getRequestDispatcher("/skip.jsp?path=updateRecord").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
