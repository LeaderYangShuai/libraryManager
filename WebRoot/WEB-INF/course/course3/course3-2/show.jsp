<%@page import="java.util.Iterator"%>
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

<table  border='2'>
<tr><td>电脑品牌</td><td>电脑型号</td><td>生产日期</td></tr>
<%
List  list =(List) session.getAttribute("list");
Iterator iterator = list.iterator();
while(iterator.hasNext()){
	       PC computer  = (PC)iterator.next();
	       String  brand= computer.getBrand();
	       String  id= computer.getId();
	       String date= computer.getDate();
if(brand!=null){
%>

<tr><td><%=brand  %></td><td><%=id  %></td><td><%=date  %></td></tr>

<%
}
}

%>
</table>
<a href="/course/skip.jsp?path=inputjsp&&clear=clear">清空值</a>
<a href="/course/skip.jsp?path=inputjsp">返回</a>
</body>
</html>