<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h1>欢迎来到管理员系统</h1>
</head>
<body>
<table  border='1'   width="350">
		<tr><td><a  href="/course/skipRoot.jsp?path=addRoot"><font color='black'><b>添加管理员</b></font></a></td>
		<td><a  href="/course/skipUser.jsp?path=addUser">添加学生</a></td></tr>
		<tr><td><a  href="/course/skipRoot.jsp?path=rootSelect"><font color='black'><b>更新管理员</b></font></a></td>
		<td><a  href="/course/skipUser.jsp?path=userSelect">修改学生</a></td></tr>
		<tr><td><a  href="/course/skipRoot.jsp?path=rootSelect"><font color='black'><b>删除管理员</b></font></a></td>
		<td><a  href="/course/skipUser.jsp?path=userSelect">删除学生</a></td></tr>
		<tr><td><a  href="/course/skipRoot.jsp?path=rootSelect"><font color='black'><b>查询管理员</b></font></a></td>
		<td><a  href="/course/skipUser.jsp?path=userSelect">查询学生</a></td></tr>
</table>
<a href="/course/skipRoot.jsp?path=loginRoot"><font color='red'>返回管理员登陆页面</font></a>
<input type="button" value="返回前页" onclick="javascript:history.back();"><br/>
<a href="/course/skip.jsp?path=login"><font color='red'>返回登陆首页面</font></a>

<%
         String content= (String)request.getAttribute("content");
        if(content!=null){
        	   out.println("<font size='5'  color='golden'>"+content+"!"+"</font>");
        }
%>

</body>
</html>