package edu.ccut.cn.controllerBook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ccut.cn.po.Book;
import edu.ccut.cn.servicesBook.BookOperation;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Book book = new Book();
		book.setIsbn(request.getParameter("isbn"));
		book.setBookName(request.getParameter("nameBook"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(request.getParameter("price"));
		book.setPublishHouse(request.getParameter("publishHouse"));
		book.setTime(request.getParameter("time"));
		book.setSummary(request.getParameter("summary"));		
	  System.out.println(request.getParameter("isbn")+request.getParameter("nameBook")+request.getParameter("summary"));
		BookOperation bookOperation  = new BookOperation();
		if (bookOperation.updateBook(book)) {
			String ss = "更新成功";
			request.setAttribute("updateContent", ss);
			request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
	
		}else {
			String ss = "没有更新成功";
			request.setAttribute("updateContent", ss);
			request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
