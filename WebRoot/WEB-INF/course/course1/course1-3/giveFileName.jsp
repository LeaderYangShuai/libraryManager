<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
			/* File  file = new File("/home/yanghongbing/NewTest/a.txt");
			String  filePath1= file.getPath();
			String  file1 = file.getName();
			String  filePath2= file.getAbsolutePath();*/
		//	request.getRequestDispatcher("/WEB-INF/course3/readFile.jsp").forward(request, response);
		//	request.setAttribute("fileName", filePath2);
		String file="/home/yanghongbing/NewTest/b.txt";
		request.setAttribute("fileName", file);
%>
<jsp:include page="readFile.jsp"></jsp:include>
</body>
</html>