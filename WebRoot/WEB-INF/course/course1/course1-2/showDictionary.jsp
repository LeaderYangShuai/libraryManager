
<%@ page language="java" import ="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!   		private TreeSet  dictionary ;
				public TreeSet addWord(String s){
					dictionary=new TreeSet();
							String [] word = s.split(" ");
	
							System.out.println("分割后是"+Arrays.toString(word));
						//	System.out.println(Arrays.toString(word));
							for(int j=0;j<word.length;j++){
									dictionary.add(word[j]);
							}
			 
							return dictionary;
				}

%>

<%
			request.setCharacterEncoding("utf-8");
				String  str = request.getParameter("str");		
				System.out.println("str是"+str);
				
				out.println("输出的结果是");
				Iterator  i = this.addWord(str).iterator();
				  while(i.hasNext()) {
				   String  s = (String)i.next();
				   out.println(s);
				  }
	
%>
<br><a  href="/course/skip.jsp?path=test2">返回重新输入</a><br>
			<a  href="/course/index.jsp">返回首页面</a><br>

</body>
</html>