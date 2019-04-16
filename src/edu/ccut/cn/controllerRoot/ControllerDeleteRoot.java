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
@WebServlet("/ControllerDeleteRoot")
public class ControllerDeleteRoot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//取值
		String rootName = request.getParameter("rootName");
		
		RootOperation rootOperation = new RootOperation();
		
			    if (rootOperation.rootDelete(rootName)) {
			    	request.setAttribute("content", "删除成功");
					request.getRequestDispatcher("/skipRoot.jsp?path=rootSelect").forward(request, response);
				}else {
					request.setAttribute("content", "没有删除成功，请重新查看");
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
