<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'poiExport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
	<style type="text/css">
		table.myTable{
			font-size:14px;
			font-family:Verdana, Geneva, sans-serif;
			width:90%;
			border:0;
			border: #111 1px solid;
			border-collapse: collapse;
		}
		table.myTable thead{
			background-color: #D1D7DC;
		}
		table.myTable tr{
			border: red 1px solid;
		}
		table.myTable tr td{
			border: #111 1px solid;/*�Ḳ��tr�ı߿���ʽ*/
			padding: 3px 0;
		}
	</style>
	<script type="text/javascript">

	</script>
  </head>
  
  <body>
    <div style="padding:0 auto;margin:0 auto;text-align:center;">
    	<table class="myTable">
    		<thead>
	    		<tr>
	    			<td>����</td>
	    			<td>�Ա�</td>
	    			<td>����</td>
	    			<td>����</td>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<tr>
	    			<td>ë��</td>
	    			<td>��</td>
	    			<td>��ϯ</td>
	    			<td>��ɳ</td>
	    		</tr>
	    		<tr>
	    			<td>�ܶ���</td>
	    			<td>��</td>
	    			<td>����</td>
	    			<td>��ƽ</td>
	    		</tr>
	    		<tr>
	    			<td>���</td>
	    			<td>��</td>
	    			<td>Ԫ˧</td>
	    			<td>��ƽ</td>
	    		</tr>
	    		<tr>
	    			<td>������</td>
	    			<td>��</td>
	    			<td>����</td>
	    			<td>�Ϻ�</td>
	    		</tr>
	    	</tbody>
    	</table>
    </div>
  </body>
</html>
