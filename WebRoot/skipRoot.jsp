<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		if (path == null) {
			out.println();
		} else if ("addUser".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/addUser.jsp").forward(request, response);
		}else if("loginManager".equals(path)){
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/loginManager.jsp").forward(request, response);
		}else if("loginRoot".equals(path)){
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/loginRoot.jsp").forward(request, response);
		} else if ("addRoot".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/addRoot.jsp").forward(request, response);
		}else if ("rootSelect".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/selectRoot.jsp").forward(request, response);
		}else if ("rootUpdate".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-root/updateRoot.jsp").forward(request, response);
		}
	%>

</body>
</html>