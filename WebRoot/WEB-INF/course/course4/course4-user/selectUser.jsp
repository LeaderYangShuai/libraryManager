<%@page import="edu.ccut.cn.po.User"%>
<%@page import="edu.ccut.cn.po.ManagerRoot"%>
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
	<form action="/course/ControllerSelectUser" method="post">
		输入学生姓名:<input type="text" name="selectContent"  /> <br/>
		选 择 查 找 类型:<select name="selectUser">
		<option value="学生名称"  >学生名称	</option>
		<option value="全部"  >全部</option></select>
		<input  type="submit" value="确认" />
	</form>
<a href="/course/skip.jsp?path=login">返回登陆页面</a>
<input type="button" value="返回" onclick="javascript:history.back();"><br>

	<%
				List  list = (List)request.getAttribute("list");
				//String updateConetnt = (String)request.getAttribute("updateContent");
				String content = (String)request.getAttribute("content");
           	   
				if(list!=null && list.size()>0){
					out.println("	<table  border='1'>");
					out.println("<tr><th>学生号</th>"+
					"<th>学生姓名</th><th>修改</th><th>删除</th></tr>");
				     Iterator iterator = list.iterator();
				     while(iterator.hasNext()){
				    	 User user = (User)iterator.next();
				  out.println("<tr><td>"+user.getId()+
						  "</td><td>"+user.getName()+
						  "<td><a href='/course/ControllerSelectUser?selectContent="+user.getId()+"&&selectUser=update'>"+"更新"+
						  "</a></td><td><a href='/course/ControllerDeleteUser?userId="+user.getId()+"'>"+"删除"+
								  "</a></td></tr>");			
				     }
				}else{
					if(list!=null){
						out.println("<font  size='5' color='golden'>"+"没有管理员，请重新输入查找"+"</font>");
					}
					if(content!=null &&content!=""){
						out.println("<font  size='5' color='red'>"+content+"</font>");
					}
				
				}
	%>
	

</table>
</body>
</html>