<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统首页面</title>
<h1>欢迎来到长春工业大学图书馆</h1>
</head>
<body>
<form action="/course/ControllerLogin"  method="post">
学号:<input  type="text"  name="id" /><br/>
姓名:<input type="text"  name="userName" /><br>
<a href="/course/skipUser.jsp?path=loginRoot"><font color='red'>管理员进入</font></a>
<input type="submit"  value="确认"/> 
</form>
<% 
					if(request.getParameter("content")!=null){					
						out.println("<font size='5' color='red'>"+"你输入的账户有误！"+"</font>");
					}

%>

</body>
</html>