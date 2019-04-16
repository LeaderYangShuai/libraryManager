<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edu.ccut.cn.po.PC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/course/skip.jsp?path=inputjsp"  method="post">
电脑品牌:<input  type="text"  name="brand" /><br/>
电脑型号:<input  type="text"  name="id" /><br/>
生产日期:<input  type="text"  name="date" /><br/>
<input type="submit"  value="提交">
<form/>
<%!
			List<PC> list = new ArrayList<PC>();
%>

<%
String  brand= request.getParameter("brand");
String  id= request.getParameter("id");
String date= request.getParameter("date");
String clear = request.getParameter("clear");

PC computer = new PC();
computer.setBrand(brand);
computer.setId(id);
computer.setDate(date);
list.add(computer);
session.setAttribute("list", list);

if("clear".equals(clear)){
	list = new ArrayList<PC>();
	System.out.println(clear);
	out.println("清空成功");
	//session.removeAttribute("list");
	//request.getRequestDispatcher("/skip.jsp?path=inputjsp").forward(request, response);
}
%>
<a href="/course/skip.jsp?path=showjsp">访问show.jsp页面，查看有关信息</a>
</body>
</html>