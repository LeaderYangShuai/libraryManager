<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="/course/skip.jsp?path=requestParameter"  method="post">
用户名:<input  type="text"  name="username" /><br/>
密    码:<input type="password"  name="password" /><br>
年龄<select name="age">
					   <option value="19">19</option>
					   <option value="20">20</option>
					   <option value="21">21</option>
</select><br/>
性别:<input type="radio" name="radio" value="男" checked>男
<input type="radio" name="radio" value="女">女<br/>
兴趣爱好:
<input type="checkbox" name="hobbies" value="打篮球">打篮球
<input type="checkbox" name="hobbies" value="睡觉">睡觉
<input type="checkbox" name="hobbies" value="学习">学习
<input type="checkbox" name="hobbies" value="看美女">看小说<br/>
自我介绍:<br/><textarea rows="8" cols="50" name="textArea"></textarea><br>
<input type="reset"  value="重置"/> 
<input  type="submit"  value="确认"/> <br/>
</form>

</body>
</html>