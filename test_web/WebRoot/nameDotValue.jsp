<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'nameDotValue.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		    
		String.prototype.trim = function() {     
		   return this.replace(/(^\s*)|(\s*$)/g, "");     
		} 
		
		function checkData(){
		   //var name = name.value.trim(); 错误1:前后名字不能一样;错误2：name是关键字
		   var xm2 = xm.value.trim(); 
		   var gender2 = gender.value.trim();
		   var age2 = age.value.trim();
		   alert("姓名：" + xm2 + " 性别：" + gender2 + " 年龄：" + age2);  
		}
		
	</script>

  </head>
  
  <body>
    姓名：<input name="xm" />
    性别：<input name="gender" />
    年龄：<input name="age" />
    <input type="button" onclick="checkData()" value="测试" />
  </body>
</html>
