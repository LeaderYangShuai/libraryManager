<%@page import="edu.ccut.cn.po.User"%>
<%@page import="edu.ccut.cn.po.ManagerRoot"%>
<%@page import="java.util.Iterator"%>
<%@page import="edu.ccut.cn.po.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生</title>
<h1>欢迎来到更新学生系统</h1>
</head>
<body>
	<form action="/course/ControllerUpdateUser"  method="post">
	<%
	List list =(List) request.getAttribute("list");
	System.out.println("我爱你"+list);
	if(list!=null && list.size()>0){
	     Iterator iterator = list.iterator();
	     while(iterator.hasNext()){
	    	 User user = (User)iterator.next();
	%>
		       学&nbsp;生&nbsp; 号:<input type="text" name="userId"  readonly value="<%=user.getId() %>" /> <br/>
		       学生姓名:<input type="text" name="userName" 	value="<%=user.getName() %>"/> <br/>		               
<%
	     }
	}
%>
     <input type="submit" value="确认" />
      <input type="button" value="返回" onclick="javascript:history.back();"><br />
	</form>
</body>
</html>