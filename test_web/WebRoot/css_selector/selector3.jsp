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
		table.fruit td>p{
			background: #C2D5FC;
		}
	</style>

  </head>
  
  <body>
  	<h2>后代选择器、父子选择器结合</h2>
  	table.peple td：选取class为people的table元素的所有后代元素td<br>
  	table.fruit td>p：选取class为fruit的table元素的所有后代元素td的子元素p<br>
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
	<br>
	<table class="fruit">
    	<tr>
			<td>name</td>    	
			<td>color</td>    	
			<td>price</td>    	
			<td>describe</td>    	
    	</tr>
    	<tr>
    		<td>Apple</td>
    		<td>red</td>
    		<td>9.8</td>
    		<td>
    			<p>
    			Apple has been a driver in some things<br>
    			and they have been a faithful adopter of<br>
    			good ideas in others.
    		</td>
    	</tr>
    	<tr>
    		<td>Grape</td>
    		<td>purple</td>
    		<td>6.5</td>
    		<td>    			
    			<p>
    			This is spraying the top of the fermenting<br>
    			red wine (the grape skins) with juice from<br>
    			the bottom of the tank.
    		</td>
    	</tr>
    	<tr>
    		<td>pear</td>
    		<td>yellow</td>
    		<td>4.8</td>
    		<td>
				<p>
				The cities that have been selected as the<br>
				national central city which express the<br>
				adjustment of state strategy on the region<br>
				development in our country. Among the five<br>
				central cities , Shanghai is the center of<br>
				east region. Beijing & Tianjin are center<br>
				of north area and bo sea coastal region.<br>
				Guangzhou is the center of pear rever region.
			</td>    	
    	</tr>
	</table>
  </body>
</html>
