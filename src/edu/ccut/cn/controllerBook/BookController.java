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
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String content = request.getParameter("content");
		System.out.println("全部的时候的content的值"+content );
		String select = request.getParameter("select");
		String selectKey = request.getParameter("selectKey");
		
	    System.out.println(content+select+selectKey);
	    		if ("图书名称".equals(select)) {
								    	BookOperation bookOperation = new BookOperation();
									    List  list = bookOperation.getBook(content);
									    if(list!=null) {
									    	//response.sendRedirect("skip.jsp?path=inputMess4");
									    	request.setAttribute("list", list);
									    	System.out.println(list.size());
									    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
									    }else {
							
									    	//response.sendRedirect("skip.jsp?path=inputMess4");
									    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
									    }
	    			}else if ("作者".equals(select)) {
			    				BookOperation bookOperation = new BookOperation();
							    List  list = bookOperation.getBookAccordAuthor(content);
							    if(list!=null) {
							    	//response.sendRedirect("skip.jsp?path=inputMess4");
							    	request.setAttribute("list", list);
							    	System.out.println(list.size());
							    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
							    }else {
					
							    	//response.sendRedirect("skip.jsp?path=inputMess4");
							    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
							    }
					}else if ("ISBN".equals(select)) {
	    				BookOperation bookOperation = new BookOperation();
					    List  list = bookOperation.getBookAccordISBN(content);
					    if(list!=null) {
					    	//response.sendRedirect("skip.jsp?path=inputMess4");
					    	request.setAttribute("list", list);
					    	System.out.println(list.size());
					    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
					    }else {
			
					    	//response.sendRedirect("skip.jsp?path=inputMess4");
					    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
					    }
			}else if ("全部".equals(select)) {
				BookOperation bookOperation = new BookOperation();
			    List  list = bookOperation.getAllBook(content);
			    if(list!=null) {
			    	//response.sendRedirect("skip.jsp?path=inputMess4");
			    	request.setAttribute("list", list);
			    	System.out.println(list.size());
			    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
			    }else {
	
			    	//response.sendRedirect("skip.jsp?path=inputMess4");
			    	request.getRequestDispatcher("/skip.jsp?path=inputMess4-1").forward(request, response);
			    }
	}
		}
	    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
