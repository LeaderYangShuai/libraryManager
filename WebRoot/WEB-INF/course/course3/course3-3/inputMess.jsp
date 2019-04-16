<%@page import="javax.swing.border.Border"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.HashMap"%>
<%@page import="edu.ccut.cn.po.MessBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
</head>
<body>
<%!
HashMap<UUID,MessBoard> hashMap=new HashMap<UUID,MessBoard>();
%>

	<form action="/course/skip.jsp?path=inputMess" method="post">
		输入你的名字:<br>
		<input type="text" name="name" /><br /> 输入你的留言标题:<br>
	
		<input type="text" name="title" /><br /> 输入你的留言:<br />
		<textarea rows="8" cols="50" name="textArea"></textarea>
		<br> <input type="reset" value="重置" /> <input type="submit"
			value="确认" /> <br />
	</form>
	<a href="/course/skip.jsp?path=show3-3jsp">查看留言板</a>
	
	
<%
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String textArea = request.getParameter("textArea");

		MessBoard board = new MessBoard();
		UUID uuid =UUID.randomUUID();
		board.setUuid(uuid);
		board.setName(name);
		board.setTitle(title);
		board.setTextArea(textArea);
		board.setDate(new Date()+"");
		
		hashMap.put(uuid, board);
	//	MessBoard.setAllMessage(hashMap);
		application.setAttribute("hash", hashMap);
	%>
</body>
</html>