package edu.ccut.cn.controllerRoot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ccut.cn.po.ManagerRoot;
import edu.ccut.cn.servicesRoot.RootOperation;

/**
 * Servlet implementation class ControllerOperationRoot
 */
@WebServlet("/ControllerOperationRoot")
public class ControllerOperationRoot extends HttpServlet {
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
		String rootPassword = request.getParameter("rootPassword");
		String operation = request.getParameter("operation");
		
		System.out.println(rootName+rootPassword+operation);
		
		ManagerRoot managerRoot = new ManagerRoot();
		managerRoot.setRootName(rootName);
		managerRoot.setRootPassword(rootPassword);
		RootOperation rootOperation = new RootOperation();
		
		 if ("rootInsert".equals(operation)) {
						//插入管理员
						if (rootOperation.insertRoot(managerRoot)) {
							request.setAttribute("content", "管理员插入成功");
							request.getRequestDispatcher("/skipRoot.jsp?path=loginManager").forward(request, response);
						}
		}else if ("rootUpdate".equals(operation)) {
			       //更新管理员
					if (rootOperation.rootUpdate(managerRoot)) {
						request.setAttribute("content", "管理员更新成功");
						request.getRequestDispatcher("/skipUser.jsp?path=loginManager").forward(request, response);
					}
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
