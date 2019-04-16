<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>

</head>
<body>
			<form action="/course/ControllerOperationRoot?operation=rootInsert"  method="post">
姓&nbsp;名:<input  type="text"  name="rootName" /><br/>
密&nbsp;码:<input type="password"  name="rootPassword" /><br>
<input type="reset"  value="重置"/> 
<input  type="submit"  value="确认"/> <br/>
<input type="button" value="返回" onclick="javascript:history.back();">
</form>
</body>
</html>