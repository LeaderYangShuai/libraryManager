package edu.ccut.cn.controllerRoot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ccut.cn.servicesRoot.RootOperation;

/**
 * Servlet implementation class ControllerSelectRoot
 */
@WebServlet("/ControllerSelectRoot")
public class ControllerSelectRoot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//取值
		String content = request.getParameter("content");
		String selectRoot = request.getParameter("selectRoot");
		System.out.println("查询管理员的内容的值是"+content+"选西那个是"+selectRoot);
		
		RootOperation rootOperation = new RootOperation();
		
		if ("管理员名称".equals(selectRoot)) {
			    List list = rootOperation.rootSelect(content);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/skipRoot.jsp?path=rootSelect").forward(request, response);
		}else if ("全部".equals(selectRoot)) {
		    List list = rootOperation.rootAllSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/skipRoot.jsp?path=rootSelect").forward(request, response);
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
