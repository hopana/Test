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
		table{
			cellspacing:0;
			cellpadding:0;
			border:none;
			background: #444;
		}
		table tr{
			background: white;
		}
		table.peple td{
			color:green;
		}
		html>body table+ul {
			clolor:red;
			background: yellow;
		}
	</style>

  </head>
  
  <body>
  	<h2>���ѡ����������ѡ�������</h2>
  	html>body table+ul��ѡ������� table Ԫ�غ���ֵ������ֵ� ul Ԫ�أ��� table Ԫ�ذ�����һ�� body Ԫ���У�body Ԫ�ر����� html Ԫ�ص���Ԫ�ء�
	<br>
  	<hr/>
  	<br>
    <table class="peple">
    	<tr>
			<td>name</td>    	
			<td>gender</td>    	
			<td>job</td>    	
			<td>address</td>    	
    	</tr>
    	<tr>
    		<td>David</td>
    		<td>man</td>
    		<td>worker</td>
    		<td>Los Angeles</td>
    	</tr>
    	<tr>
    		<td>John</td>
    		<td>man</td>
    		<td>teacher</td>
    		<td>San Francisco</td>
    	</tr>
    	<tr>
    		<td>Sara</td>
    		<td>woman</td>
    		<td>nurse</td>
    		<td>California</td>    	
    	</tr>
	</table>
	<ul>
    	<li>List item 1</li>
    	<li>List item 2</li>
    	<li>List item 3</li>
    </ul>
    <ol>
    	<li>List item 1</li>
    	<li>List item 2</li>
    	<li>List item 3</li>
    </ol>
  </body>
</html>
