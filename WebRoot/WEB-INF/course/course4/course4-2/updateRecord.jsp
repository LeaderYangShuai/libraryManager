<%@page import="java.util.Iterator"%>
<%@page import="edu.ccut.cn.po.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新图书操作</title>
<h1>欢迎来到更新系统</h1>
</head>
<body>
	<form action="/course/UpdateBook"  method="post">
	<%
	List list =(List) request.getAttribute("list");
	//System.out.println("isbn的值是"+isbn);
	
	if(list!=null && list.size()>0){
	     Iterator iterator = list.iterator();
	     while(iterator.hasNext()){
	    	 Book book = (Book)iterator.next();
	%>
			
	  <input type="hidden"  name="isbn"   value="<%=book.getIsbn() %>"/>  		
		       书 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="nameBook"  value="<%=book.getBookName() %>" /> <br/>
		           作 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:<input type="text" name="author" 	value="<%=book.getAuthor() %>"/> <br/>
		               价 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格:<input type="text" name="price"  value="<%=book.getPrice() %>" /> <br/>
		                   出&nbsp;&nbsp;版&nbsp;&nbsp;社:<input type="text" name="publishHouse" value="<%=book.getPublishHouse() %>" /> <br/>
		                       出版时间:<input type="text" name="time"   value="<%=book.getTime() %>"/> <br/>
		                           内容摘要:<br><textarea rows="8" cols="28" name="summary"><%=book.getSummary() %> </textarea><br/>	

<%
	     }
	}
%>
     <input type="submit" value="确认" /> <br />
	</form>
</body>
</html>