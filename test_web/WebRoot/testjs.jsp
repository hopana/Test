<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'testJS.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
		function test1(f){
			alert("这是方法1，返回值传给方法2:" + f);
			return 999;
		}
		function test2(f){
			alert("这是从方法1穿过来的参数：" + f);
		}

		function Aclass(){
			this.Property = 1;
			this.Method = function(){
			    alert(1);
			}
		}
		Aclass.prototype.Property2 = 2;
		Aclass.prototype.Method2 = function(){
		    alert(2);
		}
		function test3(){
			var obj = new Aclass();
			alert(obj.Property2);
			obj.Method2();
		}

		function test4(){
			for(var i=0;i<10;i++){
				if(i%2==0){
					debugger; 
					alert(i);
				}
			}
		}

		function test5(){
			console.log("这是log");
			console.info("这是info");
		　　console.debug("这是debug");
		　　console.warn("这是warn");
		　　console.error("这是error");
						
		}
		
	</script>
	</head>

	<body>
		<input type="button" value="点击测试参数传递" onclick="test1(999,test2)" />
		<input type="button" value="点击测试原型方法 " onclick="test3()" />
		<input type="button" value="点击测试JS debugger调试 " onclick="test4()" />
		<input type="button" value="点击测试JS console调试 " onclick="test5()" />
	</body>
</html>
