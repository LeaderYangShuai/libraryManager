<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/course/skip.jsp?path=inputAndShow"  method="post">
电脑品牌:<input  type="text"  name="brand" /><br/>
电脑型号:<input  type="text"  name="id" /><br/>
生产日期:<input  type="text"  name="date" /><br/>
<input type="submit"  value="提交">
<form/>
<%
String  brand= request.getParameter("brand");
String  id= request.getParameter("id");
String date= request.getParameter("date");

if(brand!=null){
%>
<table  border='2'>
<tr><td>电脑品牌</td><td>电脑型号</td><td>生产日期</td></tr>
<tr><td><%=brand  %></td><td><%=id  %></td><td><%=date  %></td></tr>
</table>
<%
}
%>
</body>
</html>