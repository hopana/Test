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
		.important {color:red;}
		label.sample{
			background: yellow;
		}
		a.link1:link {color: blue;}
		a.link1:hover {color: red;}
		a.link1:active {color: green;}
		a.link1:visited {color: gray;}
		a[name]{color:cyan;}
	</style>

  </head>
  
  <body>
  	<h2>类选择器、ID选择器、属性选择器</h2>
  	form label：选择form元素的所有后代元素label<br>
  	form>div>label：选择form元素的子元素div下面的子元素label
  	<hr>
    <h1 class="important">
	This heading is very important.
	</h1>
	
	<p class="important">
	This paragraph is very important.
	</p>
	
	<label class="sample">this is a label</label>
	<br>
	<label>this is an other label</label><br><br>
	<a class="link1" href="#">一个标准的链接</a><br>
	<a>一个没有href的链接</a><br>
	<a name="name" href="#">一个有name属性的链接</a>
  </body>
</html>
