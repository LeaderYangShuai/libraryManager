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
<title>更新管理员</title>
<h1>欢迎来到更新管理员系统</h1>
</head>
<body>
	<form action="/course/ControllerOperationRoot?operation=rootUpdate"  method="post">
	<%
	List list =(List) request.getAttribute("list");
	//System.out.println("isbn的值是"+isbn);
	
	if(list!=null && list.size()>0){
	     Iterator iterator = list.iterator();
	     while(iterator.hasNext()){
	    	 ManagerRoot managerRoot = (ManagerRoot)iterator.next();
	%>
		       管理员姓名:<input type="text" name="rootName"  readonly value="<%=managerRoot.getRootName() %>" /> <br/>
		       管理员密码:<input type="text" name="rootPassword" 	value="<%=managerRoot.getRootPassword() %>"/> <br/>		               
<%
	     }
	}
%>
     <input type="submit" value="确认" />
      <input type="button" value="返回" onclick="javascript:history.back();"><br />
	</form>
</body>
</html>