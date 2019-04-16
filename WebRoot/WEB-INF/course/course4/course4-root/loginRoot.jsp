<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统首页面</title>
<h1><font color='red'>欢迎来到管理员登陆系统</font></h1>
</head>
<body>
<form action="/course/LoginRootController"  method="post">
用户名:<input  type="text"  name="rootName" /><br/>
密&nbsp;&nbsp;&nbsp;码:<input type="password"  name="rootPassword" /><br>

<input type="submit"  value="进入"/>
<input type="button" value="返回" onclick="javascript:history.back();">
</form>
<% 
					if(request.getAttribute("content")!=null){					
						out.println("<font size='5' color='golden'>"+"不要非法登陆！"+"</font>");
					}

%>

</body>
</html>