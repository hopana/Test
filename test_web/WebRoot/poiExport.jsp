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
		 /*表格*/ 
		 table{ font-size:12px;font-family:Verdana, Geneva, sans-serif;}
		.table-td tr {background-color:expression((this.sectionRowIndex%2==0)?"#e6f1fe":"#f7f8fa");}
		.table-td td{ height:24px;border-right-color:#afd1fc; border-bottom-color:#afd1fc;font#444 12px mormal;}
		.table-td td.blue{ background:#e6f1fe;height:24px;border-right-color:#afd1fc; border-bottom-color:#afd1fc;}
		.table-border { border-left:1px #afd1fc solid; border-top:1px #afd1fc solid;}
		.text-100 {width: 100px; border: 0px solid #777; background: url(images/text-100.gif) no-repeat;line-height:21px; height:21px; padding: 0 0 0 5px; }
		.text-100-focus {width: 100px; border: 0px solid #777; background: url(images/text-100.gif) no-repeat 0 -21px;line-height:21px; height:21px; padding: 0 0 0 5px; }
		/*button 150*/
		.button-150 {width: 150px; border: 0px; background: url(images/button-150.gif) no-repeat 0 -42px; line-height:21px; height:21px;}
		.button-150-o {width: 150px; border: 0px; background: url(images/button-150.gif) no-repeat 0 -21px; line-height:21px; height:21px;}
		.button-150-p {width: 150px; border: 0px; background: url(images/button-150.gif) no-repeat 0 0; line-height:21px; height:21px;}
	</style>
	<script type="text/javascript">
		function exportExcel(){
			document.write("export");
		}
	</script>
  </head>
  
  <body>
    <div style="padding:0 auto;margin:0 auto;text-align:center;">
    	<table width="90%" border="0" cellspacing="0" cellpadding="0" style="margin-bottom:5px;">
    		<tr>
    			<td>
    				<input type="button" value="导出EXCEL" class="button-150" style="float:right;" onmouseout="this.className='button-150'" onmouseover="this.className='button-150-o'" onmousedown="this.className='button-150-p'"  onclick="exportExcel()">
    			</td>
    		</tr>
    	</table>
    	<table style="width:90%;border-collapse:collapse;cellpadding:0;cellspacing:0;border:0;">
    		<tr >
				<td width="5px" align="left" valign="top" style='padding: 0;'><img src="images/11.gif" height="5" width="5" /></td>
				<td style='border-top: 1px solid #afd1fc'></td>
				<td width="5px" align="right" valign="top" style='padding: 0;'><img src="images/12.gif" height="5" width="5" /></td>
			</tr>
			<tr>
				<td width="5px" style='margin: 0; padding: 0; border-left: 1px solid #afd1fc'></td>
				<td  style="padding: 0; margin: 0; border: 0">
					<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#ffffff"  bordercolordark="#ffffff"  class="table-border table-td" id="teacherList">
			    		<thead style="display:table-header-group;font-weight:bold">
			    			<tr align="center" bgcolor="#78D3EC">
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">考试代码</td>
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">考试名称</td>
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">省</td>
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">市</td>
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">县区</td>
			    				<td class="jcolor4" width="10%" background="images/22.gif" bordercolorlight="#afd1fc" bordercolordark="#ffffff" class="left-pa2" style="padding: 0; text-align: center">状态</td>
			    			</tr>
			    		</thead>
			    		<tbody>
			    			<tr>
			    				<td class="alt" align="center" height="25">20140408102735</td>
			    				<td class="alt" align="center" height="25">自考通卡测试</td>
			    				<td class="alt" align="center" height="25">(440000)广东省</td>
			    				<td class="alt" align="center" height="25">(440300)深圳市</td>
			    				<td class="alt" align="center" height="25">
									<input type="text" name="fenshuduan" id="fenshuduan" class="text-100" onfocus="this.className='text-100-focus'" onblur="this.className='text-100'" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="width:100px" value="5"/>
								</td>
			    				<td class="alt" align="center" height="25">初始</td>
			    			</tr>
			    			<tr>
			    				<td class="alt" align="center" height="25">20140408102736</td>
			    				<td class="alt" align="center" height="25">深圳市高中第一次模拟考试</td>
			    				<td class="alt" align="center" height="25">(440000)广东省</td>
			    				<td class="alt" align="center" height="25">(440300)深圳市</td>
			    				<td class="alt" align="center" height="25">
									<input type="text" name="fenshuduan" id="fenshuduan" class="text-100" onfocus="this.className='text-100-focus'" onblur="this.className='text-100'" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="width:100px" value="5"/>
								</td>
			    				<td class="alt" align="center" height="25">初始</td>
			    			</tr>
			    			<tr>
			    				<td class="alt" align="center" height="25">20140408102737</td>
			    				<td class="alt" align="center" height="25">深圳市初中期末考试</td>
			    				<td class="alt" align="center" height="25">(440000)广东省</td>
			    				<td class="alt" align="center" height="25">(440300)深圳市</td>
			    				<td class="alt" align="center" height="25">
									<input type="text" name="fenshuduan" id="fenshuduan" class="text-100" onfocus="this.className='text-100-focus'" onblur="this.className='text-100'" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="width:100px" value="5"/>
								</td>
			    				<td class="alt" align="center" height="25">初始</td>
			    			</tr>
			    		</tbody>
			    	</table>
			    </td>
		    	<td width="5px" style='margin: 0; padding: 0; border-right: 1px solid #afd1fc'></td>
	    	</tr>
   		    <tr>
		    	<td align="left" valign="bottom" style='padding: 0;'><img src="images/13.gif" width="5" height="5" /></td>
			    <td style='border-bottom: 1px solid #afd1fc'></td>
			    <td align="right" valign="bottom" style='padding: 0;'><img src="images/14.gif" width="5" height="5" /></td>
		    </tr>
    	</table>
    </div>
  </body>
</html>
