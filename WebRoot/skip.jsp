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
		} else if ("test1".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course1/course1-1/test.jsp").forward(request, response);
		} else if ("test2".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course1/course1-2/inputWord.jsp").forward(request,
					response);
		} else if ("str_inputWord".equals(path)) {
			//request.getRequestDispatcher("WEB-INF/course2/showDictionary.jsp").forward(request, response);
			request.getRequestDispatcher("/WEB-INF/course/course1/course1-2/showDictionary.jsp").forward(request,
					response);
		} else if ("test3".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course1/course1-3/giveFileName.jsp").forward(request,
					response);
		}

		if ("registerInformation".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course2/course2-1/registerInformation.jsp")
					.forward(request, response);
		} else if ("requestParameter".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course2/course2-1/requestParameter.jsp").forward(request,
					response);
		} else if ("RefreshFile".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course2/course2-2/RefreshFile.jsp").forward(request,
					response);
		}

		if ("inputAndShow".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course3/course3-1/inputAndShow.jsp").forward(request,
					response);
		} else if ("inputjsp".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course3/course3-2/input.jsp").forward(request, response);
		} else if ("showjsp".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course3/course3-2/show.jsp").forward(request, response);
		} else if ("inputMess".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course3/course3-3/inputMess.jsp").forward(request,
					response);
		} else if ("show3-3jsp".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course3/course3-3/show.jsp").forward(request, response);
		}
		
		
		if ("inputMess4-1".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-1/inputMess.jsp").forward(request,
					response);
		} else if ("updateRecord".equals(path)) {
			request.getRequestDispatcher("/WEB-INF/course/course4/course4-2/updateRecord.jsp").forward(request, response);
		} else if("login".equals(path)){
			request.getRequestDispatcher("/WEB-INF/course/course4/login.jsp").forward(request, response);
		}
	%>

</body>
</html>