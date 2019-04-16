<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
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
				String fileName= (String) request.getAttribute("fileName");
				if("/home/yanghongbing/NewTest/a.txt".equals(fileName)){
					BufferedReader  bufferedReader = new BufferedReader(new FileReader(fileName));
					String tempString=null;
					while((tempString = bufferedReader.readLine())!= null) {
					out.println(tempString);
					}
					bufferedReader.close();
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			
				
		
%>
</body>
</html>