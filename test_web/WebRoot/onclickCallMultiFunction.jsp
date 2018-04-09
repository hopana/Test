<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'onclickCallMultiFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function func1(){
			alert("这是方法1");
		}
		function func2(){
			alert("这是方法2");
		}
		function func3(){
			alert("这是方法3");
		}
	
	</script>

  </head>
  
  <body>
    <h3>测试一个按钮的onclick事件触发多个js方法.</h3> <hr>
    <input type="button" value="测试" onclick="func1();func2();func3()" />
  </body>
</html>
