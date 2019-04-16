<%@page import="edu.ccut.cn.po.Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/course/BookController" method="post">
		输入查询内容:<input type="text" name="content"  /> <select name="select">
		<option value="全部"  >全部</option>
		   <option value="图书名称"  >图书名称	</option>
			<option value="作者">作者</option>
			<option value="ISBN">ISBN</option>		
		</select><br /> <input type="radio" name="selectKey" value="前面一致" checked>前面一致
		<input type="radio" name="selectKey" value="后面一致">后面一致 <input
			type="radio" name="selectKey" value="包含">包含 <input
			type="submit" value="确认" /> <br />
	</form>
<a href="/course/skip.jsp?path=login">返回登陆页面</a>
<input type="button" value="返回" onclick="javascript:history.back();">

	<%
				List<Book>  list = (List<Book>)request.getAttribute("list");
				String updateConetnt = (String)request.getAttribute("updateContent");
           	   	System.out.println("list的是"+list);
           		 System.out.println("updateConetnt的是"+updateConetnt);
           	   if(updateConetnt!=null){
           		out.println("<font  size='5' color='red'>"+"更新成功"+"</font>");
           	   }
           	   
				if(list!=null && list.size()>0){
					out.println("	<table  border='1'>");
					out.println("<tr><th>ISBN</th>"+
					"<th>bookName</th><th>author</th><th>price</th><th>publishHouse</th><th>time</th>"+
					"<th>summary</th><th>修改</th></tr>");
				     Iterator iterator = list.iterator();
				     while(iterator.hasNext()){
				    	 Book book = (Book)iterator.next();
				  out.println("<tr><td>"+book.getIsbn()+"</td><td>"+book.getBookName()+
						  "</td><td>"+book.getAuthor()+"</td><td>"+book.getPrice()+
						  "</td><td>"+book.getPublishHouse()+"</td><td>"+book.getTime()+
						  "</td><td>"+book.getSummary()+"</td><td><a href='/course/GetBookController?bookName="+book.getBookName()+"'>"+"更新"+"</a></td></tr>");			
				     }
				}else{
					if(list!=null){
						out.println("<font  size='5' color='red'>"+"你输入的书没有，请重新输入查找"+"</font>");
					}
					
				}
	%>
	

</table>
</body>
</html>