package tmpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CreatePage {
	private static String TITILE = "测试测试";
	private static String[] column = {"编号", "申请类型", "申请时间", "商户编号", "商户名称", "所属代理商编号", "所属代理商名称", "上级代理商编号", "手机号", "机具布放地址", "状态", "来源", "备注"};
	private static String[] params = {"i", "FType", "FCreateTime", "FMerchantId", "FMerchantName", "FAgentId", "FTitle", "FTopAgentId", "FMobile", "FAddress", "FState", "FSource", "FRemark"};
	
	public static void main(String[] args) {
		File tmpl = new File("D:\\tmpl\\page.jsp");
		StringBuilder sb = new StringBuilder(500);
		
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		sb.append("<head>\n");
		sb.append("<%=new com.yeahka.posadmin.common.Head(request, '" + TITILE + "').addDate().addPage().addMessageBox()%>\n");
		sb.append("\n");
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("$(document).ready(function() {\n");
		sb.append("	init();");
		sb.append("	doViewFormLoad_tmp(\"infocheck_list.do\");\n");
		sb.append("})\n");
		sb.append("\n");
		sb.append("function init() {\n");
		sb.append("	$(\"#query\").click(function() {\n");
		sb.append("		doViewFormLoad();\n");
		sb.append("		return false;\n");
		sb.append("	});\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("function doViewFormLoad() {\n");
		sb.append("	var queryStr = $(\"#form1\").serialize()+ \"&${queryString}\";\n");
		sb.append("	$(\"#pagination\").myPagination({\n");
		sb.append("     currPage: 1,\n");
		sb.append("     pageCount: 1\n");
		sb.append("		info: {msg_on: true},\n");
		sb.append("		ajax: {\n");
		sb.append("			on: true,\n");
		sb.append("			callback: 'doCallBack',\n");
		sb.append("			url: \"infocheck_list.do\",\n");
		sb.append("			dataType: 'json',\n");
		sb.append("			ajaxStart: function() {\n");
		sb.append("				ZENG.msgbox.show(\" 正在加载中，请稍后...\", 6);\n");
		sb.append("				$(\"#dataContainer tr:not(:first)\").remove();\n");
		sb.append("			},\n");
		sb.append("			param: {\n");
		sb.append("				on: true,\n");
		sb.append("				page: 1,\n");
		sb.append("				form: true,\n");
		sb.append("				formData: queryStr\n");
		sb.append("			} \n");
		sb.append("	    }\n");
		sb.append("	});\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("function doCallBack(data) {\n");
		sb.append("	console.log(data.list);\n");
		sb.append("	ZENG.msgbox.hide();\n");
		sb.append("	$(\"#pagination\").hide();\n");
		sb.append("	var records = data.list; \n");
		sb.append("	var result = data.result;\n");
		sb.append("	var jtotal = data.DATA_SUM;\n");
		sb.append("	var checktotal = data.checktotal;\n");
		sb.append("	var waitchecktotal = data.waitchecktotal;\n");
		sb.append("	var notchecktotal = data.notchecktotal;\n");
		sb.append("	if( result!=0 ){\n");
		sb.append("		if (!(typeof(data.errorMsg) == \"undefined\" || data.errorMsg==\"\")) { \n");
		sb.append("			ZENG.msgbox.show(data.errorMsg, 1, 1000);\n");
		sb.append("		}\n");
		sb.append("		return false;\n");
		sb.append("	}\n");
		sb.append("\n");
		sb.append("	if( typeof records == null || records.length<=0 ){\n");
		sb.append("		var tdCount = $(\"#dataContainer tr\").eq(0).find(\"td\").length;\n");
		sb.append("		$(\"#dataContainer\").append(\"<tr><td COLSPAN=\"+tdCount+\">查不到相应的记录</td></tr>\");\n");
		sb.append("		return false;\n");
		sb.append("	}\n");
		sb.append("\n");
		sb.append("$(\"#jtotal\").html(jtotal);\n");
		sb.append("$(\"#checktotal\").html(checktotal);\n");
		sb.append("$(\"#waitchecktotal\").html(waitchecktotal);\n");
		sb.append("$(\"#notchecktotal\").html(notchecktotal);\n");
		sb.append("$(\"#pagination\").show();\n");
		sb.append("$(\"#template\").tmpl( records ).appendTo(\"#dataContainer\");\n");
		sb.append("return;\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("function jumpPage_1(){\n");
		sb.append("	jumpPage_z(\"infocheck_list.do\");\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("function output() {\n");
		sb.append("	var queryStr = $(\"#form1\").serialize();\n");
		sb.append("	var url = \"infocheckExcel.do?\" + queryStr;\n");
		sb.append("	location.href = url;\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("</script>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<input type=\"hidden\" name=\"page_no_ago\" id=\"page_no_ago\"/>\n");
		sb.append("<c:if test=\"${page != null}\"><input type=\"hidden\" name=\"page\" id=\"page\" value=\"${page}\"/></c:if>\n");
		sb.append("\n");
		sb.append("<div class=\"gray_wrap\" style=\"min-width:1200px;\">\n");
		sb.append("	<form name=\"form1\" id=\"form1\"  method=\"post\" style=\"margin:0;\">\n");
		sb.append("		<input type=\"hidden\" name=\"page_no_ago\" id=\"page_no_ago\"/>\n");
		sb.append("     <table width=\"99%\">\n");
		sb.append("		   <tr>\n");
		sb.append("			   <td height=\"30\">\n");
		sb.append("				   <div style=\"height:auto;min-height:40px;max-height:300px;\">\n");
		sb.append("						<span style=\"display:inline-block;width:60px;\">开始日期</span>\n");
		sb.append("						<input name=\"startTime\" id=\"startTime\" onclick=\"WdatePicker()\" class=\"act_free_ipt\" style=\"color:#999999;width:150px;\" />\n");
		sb.append("						<span style=\"display:inline-block;width:60px;margin-left:10px;\">结束日期</span>\n");
		sb.append("						<input name=\"endTime\" id=\"endTime\" onclick=\"WdatePicker()\" class=\"act_free_ipt\" style=\"color:#999999;width:150px;\" />\n");
		sb.append("						<span style=\"margin-left:10px;display:inline-block;width:65px;\">申请人姓名</span>\n");
		sb.append("						<input  class=\"act_free_ipt\" name=\"FApplicant\" style=\"margin-left:10px;width:150px;\"/>\n");
		sb.append("				   </div>\n");
		sb.append("				   <div style=\"height:auto;min-height:40px;max-height:300px;\">\n");
		sb.append("						<span style=\"display:inline-block;width:60px;\">手机号码</span>	\n");
		sb.append("						<input class=\"act_free_ipt\" name=\"FMobile\" style=\"width:150px;\"/>\n");
		sb.append("						<span style=\"display:inline-block;width:60px;margin-left:10px;\">省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份</span>\n");
		sb.append("						<select name=\"FProvince\" id=\"FProvince\" style=\"width:160px;height:30px;border:1px solid #CCC;\"><option value=\"-1\">全部</option></select>\n");
		sb.append("						<span style=\"margin-left:10px;display:inline-block;width:65px;\">城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市</span>\n");
		sb.append("						<select name=\"FCity\" id=\"FCity\" style=\"width:160px;margin-left:10px;height:30px;border:1px solid #CCC;\"><option value=\"-1\">全部</option></select>\n");
		sb.append("				   </div>\n");
		sb.append("				   <div style=\"height:auto;min-height:40px;max-height:300px;\">\n");
		sb.append("						<span style=\"display:inline-block;width:60px;\">商户类型</span\n");
		sb.append("						<select id=\"FType\" name=\"FType\" style=\"width:160px;height:30px;border:1px solid #CCC;\">\n");
		sb.append("							<option value=\"\">全部</option>\n");
		sb.append("							<option value=\"1\" ${FType == 1?'selected':''} >意向商户</option>\n");
		sb.append("							<option value=\"2\" ${FType == 2?'selected':''} >试用商户</option>\n");
		sb.append("						</select>\n");
		sb.append("						<span style=\"display:inline-block;width:60px;margin-left:10px;\">产品类型</span>\n");
		sb.append("						<select id=\"FProductType\" name=\"FProductType\" style=\"width:160px;height:30px;border:1px solid #CCC;\">\n");
		sb.append("							<option value=\"\">全部</option>\n");
		sb.append("							<option value=\"1\" ${FProductType == 1?'selected':''} >智掌柜</option>\n");
		sb.append("							<option value=\"2\" ${FProductType == 2?'selected':''} >乐售</option>\n");
		sb.append("							<option value=\"3\" ${FProductType == 3?'selected':''} >乐外卖</option>\n");
		sb.append("						</select>\n");
		sb.append("						<span style=\"display:inline-block;width:65px;margin-left:10px;\">申&nbsp;请&nbsp;状&nbsp;态</span>\n");
		sb.append("						<select id=\"FStatus\" name=\"FStatus\" style=\"width:160px;margin-left:10px;height:30px;border:1px solid #CCC;\">\n");
		sb.append("							<option value=\"\">全部</option>\n");
		sb.append("							<option value=\"0\" ${FStatus == 0?'selected':''} >未领取</option>\n");
		sb.append("							<option value=\"1\" ${FStatus == 1?'selected':''} >已领取</option>\n");
		sb.append("						</select>\n");
		sb.append("				   </div>\n");
		sb.append("			   </td>\n");
		sb.append("			   <td>\n");
		sb.append("				   <div style=\"min-width:280px;\">\n");
		sb.append("						<input type=\"submit\" style=\"width:80px;height:30px;\" value=\"查询\" id=\"query\"/> &nbsp;&nbsp;\n");
		sb.append("						<input type=\"button\" style=\"width:80px;height:30px;\" value=\"导出\" id=\"exportExcel\" onclick=\"output()\"/>\n");
		sb.append("						<input type=\"button\" style=\"width:80px;height:30px;margin-left:10px;\" value=\"增加\" onclick=\"add()\"/>\n");
		sb.append("				   </div>\n");
		sb.append("			    </td>\n");
		sb.append("		    </tr>\n");
		sb.append("        </table>\n");
		sb.append("    </form>\n");
		sb.append("</div>\n");
		sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"padding: 0 2px;min-width:1200px;\">\n");
		sb.append("  <tr>\n");
		sb.append("    <td>\n");
		sb.append("      <table id=\"subtree1\" style=\"DISPLAY: \" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		sb.append("        <tr>\n");
		sb.append("          <td>\n");
		sb.append("            <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n");
		sb.append("              <tr>\n");
		sb.append("                <td height=\"40\" class=\"font42\">\n");
		sb.append("                  <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"1\" bgcolor=\"#cccccc\" class=\"newfont03\" align=\"center\">\n");
		sb.append("	                <tr>\n");
		sb.append("					  <td class=\"font42\" colspan=\"14\">\n");
		sb.append("						<table width=\"100%\" cellspacing=\"1\" cellpadding=\"4\" border=\"0\" bgcolor=\"#FFF\" class=\"tablestyle_title\">\n");
		sb.append("						  <tbody>\n");
		sb.append("						  	<tr>\n");
		sb.append("								<td style=\"text-align:left\">\n");
		sb.append("									统计：共有<span id=\"jtotal\">0</span>家商户申请，其中<span id=\"checktotal\">0</span>家审核通过，<span id=\"waitchecktotal\">0</span>家未审核，<span id=\"notchecktotal\">0</span>家未通过。\n");
		sb.append("								</td>\n");
		sb.append("							</tr>\n");
		sb.append("						  </tbody>\n");
		sb.append("						</table>\n");
		sb.append("					  </td>\n");
		sb.append("					</tr>\n");
		sb.append("					<tbody id='dataContainer'>\n");
		sb.append("	                  <tr>\n");
		
		for (int i = 0; i < column.length; i++) {
			sb.append("						<td align=\"center\" bgcolor=\"#ECECEC\" height=\"30\" style=\"font-weight:bold;\">" + column[i] + "</td>\n");
		}
		
		sb.append("	                    <td align=\"center\" bgcolor=\"#ECECEC\" height=\"30\" style=\"font-weight:bold;\">操作</td>\n");
		sb.append("	                  </tr>\n");
		sb.append("	               </tbody>\n");
		sb.append("                   <script id=\"template\" type=\"text/x-jquery-tmpl\">\n");
		sb.append("					<tr bgcolor=\"#FFFFFF\">\n");
		
		for (int i = 0; i < params.length; i++) {
			sb.append("						<td height=\"30\">{{= " + params[i] + "}}</td>\n");
		}		

		sb.append("                        <td><a href=\"${path}/merchant/infocheck_detail.do?FId={{= FId}}&FMerchantId={{= FMerchantId}}\">查看</a></td>\n");
		sb.append("					</tr>\n");
		sb.append("				   </script>\n");
		sb.append("                  </table>\n");
		sb.append("				 </td>\n");
		sb.append("             </tr>\n");
		sb.append("          </table>\n");
		sb.append("		  </td>\n");
		sb.append("      </tr>\n");
		sb.append("     </table>\n");
		sb.append("  </td>\n");
		sb.append("  </tr>\n");
		sb.append("</table>\n");
		sb.append("\n");
		sb.append("<table class=\"table2\" border=\"0\" cellspacing=\"0\" style=\"border:0px solid #ccc;width:100%; _width:100px; margin:5px 0;padding:0 2px;min-width:1200px;\">\n");
		sb.append("  <tr>\n");
		sb.append("    <td colspan=\"5\" style=\"text-align:center;\">\n");
		sb.append("      <div id=\"pagination\" style=\"display:none\"></div>\n");
		sb.append("    </td>\n");
		sb.append("  </tr>\n");
		sb.append("</table>\n");
		sb.append("\n");
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		FileOutputStream fos = null;
		FileChannel channel = null;
		try {
			fos = new FileOutputStream(tmpl);
			channel = fos.getChannel();
			ByteBuffer bb = ByteBuffer.allocate(10240);

		    byte[] message = sb.toString().getBytes();
		    bb.put(message);
		    bb.flip();

		    channel.write(bb); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
