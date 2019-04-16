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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String radio = request.getParameter("radio");
		String hobbies = request.getParameter("hobbies");
		String textArea = request.getParameter("textArea");
		String age = request.getParameter("age");
		
		if(username==null || username.equals("")){
			response.sendRedirect("/course/skip.jsp?path=registerInformation");
			session.setAttribute("warn", "你输入的用户名是空");
			return;
		}
		System.out.println("姓名是"+username);
		System.out.println("密码是"+password);
		System.out.println("年龄是"+age+radio+hobbies+textArea);
		out.println("姓名是"+username);
		out.println("密码是"+password);
		out.println("年龄是"+age);  
		out.println("性别是"+radio);
		out.println("兴趣爱好是"+hobbies);
		out.println("自我介绍是"+textArea);  


	
%>


</body>
</html>