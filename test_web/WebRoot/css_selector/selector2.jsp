<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selector.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
		body{
			font-family: Verdana, Geneva, sans-serif;
		}
		form>label{
			color:red;
		}
		div>input{
			color:orange;
		}
	</style>

  </head>
  
  <body>
  	<h2>父子选择器</h2>
  	form>label：选取form的子元素label<br>
  	div>input：选取div的子元素input
  	<hr>
    <form>
	  <label>Name:Mike</label>
	  <div>
	      <label>Newsletter:</label>
	      <input name="newsletter" value="this is the value"/>
	 </div>
	</form>
	<label>address:NewYork</label>
  </body>
</html>
