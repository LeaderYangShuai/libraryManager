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
	<form action="/course/ControllerSelectRoot" method="post">
		输入管理员姓名:<input type="text" name="content"  /> <br/>
		选 择 查 找 类型:<select name="selectRoot">
		<option value="管理员名称"  >管理员名称	</option>
		<option value="全部"  >全部</option></select>
		<input  type="submit" value="确认" />
	</form>
<a href="/course/skip.jsp?path=login">返回登陆页面</a>
<input type="button" value="返回" onclick="javascript:history.back();"><br>

	<%
				List  list = (List)request.getAttribute("list");
				//String updateConetnt = (String)request.getAttribute("updateContent");
				String conetnt = (String)request.getAttribute("content");
           	   
				if(list!=null && list.size()>0){
					out.println("	<table  border='1'>");
					out.println("<tr><th>管理员姓名</th>"+
					"<th>管理员密码</th><th>修改</th><th>删除</th></tr>");
				     Iterator iterator = list.iterator();
				     while(iterator.hasNext()){
				    	 ManagerRoot managerRoot = (ManagerRoot)iterator.next();
				  out.println("<tr><td>"+managerRoot.getRootName()+
						  "</td><td>"+managerRoot.getRootPassword()+
						  "<td><a href='/course/ControllerSelectRootAccordName?rootName="+managerRoot.getRootName()+"'>"+"更新"+
						  "</a></td><td><a href='/course/ControllerDeleteRoot?rootName="+managerRoot.getRootName()+"'>"+"删除"+
								  "</a></td></tr>");			
				     }
				}else{
					if(list!=null){
						out.println("<font  size='5' color='golden'>"+"没有管理员，请重新输入查找"+"</font>");
					}
					if(conetnt!=null &&conetnt!=""){
						out.println("<font  size='5' color='red'>"+conetnt+"</font>");
					}
				
				}
	%>
	

</table>
</body>
</html>