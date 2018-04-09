<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dwr.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="dwr/engine.js"></script> 
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type='text/javascript' src='dwr/interface/DwrTest.js'></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function test(){
			var s = document.getElementById("inputStr").value;
			DwrTest.test(s,function callBackFunc(returnData){
				alert("你输入的字符串是：" + returnData);
			});
		}		
	</script>

  </head>
  
  <body>
  	请输入测试字符串：<input id="inputStr" />
    <input type="button" value="测试dwr调用java方法" onclick="test()" />
  </body>
</html>
