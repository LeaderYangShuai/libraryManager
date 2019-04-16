package edu.ccut.cn.controllerStudents;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ccut.cn.servicesRoot.RootOperation;
import edu.ccut.cn.servicesStudents.UserOperation;

/**
 * Servlet implementation class ControllerSelectRoot
 */
@WebServlet("/ControllerSelectUser")
public class ControllerSelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//取值
//
		String selectContent = request.getParameter("selectContent");
		String selectUser = request.getParameter("selectUser");
		System.out.println("查询xuesheng的内容的值是"+selectContent+"选西那个是"+selectUser);
		
		UserOperation userOperation = new UserOperation();
		
		if ("学生名称".equals(selectUser)) {
			if (selectContent!=null &&selectContent!="") {
				  List list = userOperation.userSelect(selectContent);
					request.setAttribute("list", list);
					request.getRequestDispatcher("/skipUser.jsp?path=userSelect").forward(request, response);
			}else {
				request.setAttribute("content", "不要输入空内容");
				request.getRequestDispatcher("/skipUser.jsp?path=userSelect").forward(request, response);
			}
			  
		}else if ("全部".equals(selectUser)) {
		    List list = userOperation.userAllSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/skipUser.jsp?path=userSelect").forward(request, response);
	}else if  ("update".equals(selectUser)) {
	    List list = userOperation.userSelect(selectContent);
	    System.out.println("ok不ok");
		request.setAttribute("list", list);
		request.getRequestDispatcher("/skipUser.jsp?path=userUpdate").forward(request, response);
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
