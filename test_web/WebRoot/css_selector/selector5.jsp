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
		a:link {color: red;}		/* δ���ʵ����� */
		a:visited {color: green;}	/* �ѷ��ʵ����� */
		a:hover {color: orange;}	/* ����ƶ��������� */
		a:active {color: blue;}	/* ѡ�������� */
		p:first-child {font-weight: bold;}
		li:first-child {text-transform:uppercase;}
	</style>
  </head>
  
  <body>
  	<h2>α��</h2>
  	html>body table+ul��ѡ������� table Ԫ�غ���ֵ������ֵ� ul Ԫ�أ��� table Ԫ�ذ�����һ�� body Ԫ���У�body Ԫ�ر����� html Ԫ�ص���Ԫ�ء�
	<br>
  	<hr/>
  	<br>
    <h4>1��êα��</h4>
    <a href="#">����һ������</a>
    <h4>2��:first-child α��</h4>
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
