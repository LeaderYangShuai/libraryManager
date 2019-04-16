<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>

</head>
<body>
			<form action="/course/StudentsController"  method="post">
学生号:<input  type="text"  name="userId" /><br/>
姓&nbsp;&nbsp;&nbsp;名:<input type="text"  name="userName" /><br>
<input type="reset"  value="重置"/> 
<input  type="submit"  value="确认"/> 
<input type="button" value="返回" onclick="javascript:history.back();"><br/>
</form>
</body>
</html>