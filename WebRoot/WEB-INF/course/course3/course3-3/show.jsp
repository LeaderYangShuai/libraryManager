<%@page import="java.util.Iterator"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.HashMap"%>
<%@page import="edu.ccut.cn.po.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="2">
<tr><th>姓名</th><th>留言标题</th><th>留言内容</th><th>留言时间</th></tr>
<%
HashMap<UUID, MessBoard> hashMap  =(HashMap) application.getAttribute("hash");
System.out.println(hashMap.keySet().size());
System.out.println(hashMap.values().size());
Iterator iterator = hashMap.values().iterator();
while(iterator.hasNext()){
	            MessBoard board2 = (MessBoard)iterator.next();
	            System.out.println(board2.getName());
	            System.out.println(board2.getTitle());
	            System.out.println(board2.getTextArea());
               if(board2.getName()!=null){
	            out.println("<tr><td>"+board2.getName()+"</td><td>"+board2.getTitle()+"</td><td>"+board2.getTextArea()+"</td><td>"+board2.getDate()+"</td></tr>");
               }
}

%>
</table>
<a href="/course/skip.jsp?path=inputMess">返回再次留言</a>
</body>
</html>