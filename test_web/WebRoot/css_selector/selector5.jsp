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
		h4{color:red;}
		a:link {color: red;}		/* 未访问的链接 */
		a:visited {color: green;}	/* 已访问的链接 */
		a:hover {color: orange;}	/* 鼠标移动到链接上 */
		a:active {color: blue;}	/* 选定的链接 */
		p:first-child {font-weight: bold;}
		li:first-child {text-transform:uppercase;}
	</style>
  </head>
  
  <body>
  	<h2>伪类</h2>
  	html>body table+ul：选择紧接在 table 元素后出现的所有兄弟 ul 元素，该 table 元素包含在一个 body 元素中，body 元素本身是 html 元素的子元素。
	<br>
  	<hr/>
  	<br>
    <h4>1、锚伪类</h4>
    <a href="#">这是一个链接</a>
    <h4>2、:first-child 伪类</h4>
    <div>
		<p>These are the necessary steps:</p>
		<ul>
		<li>Intert Key</li>
		<li>Turn key <strong>clockwise</strong></li>
		<li>Push accelerator</li>
		</ul>
		<p>Do <em>not</em> push the brake at the same time as the accelerator.</p>
	</div>
    
  </body>
</html>
