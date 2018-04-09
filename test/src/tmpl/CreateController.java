package tmpl;

public class CreateController {
	private static String REQUEST_MAPPING = "/receipt_activity";
	private static String CONTROLLER_NAME = "receiptActivityRecord";
	private static String JSP_PAGE_PATH = "merchantmanager/receipt_activity";
	private static String MODEL_NAME = "CloudMerchantModel";
	private static String SERVICE_NAME = "CloudMerchantService";
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(500);
		
		sb.append("	@RequestMapping(value = " + REQUEST_MAPPING + ", method = RequestMethod.GET)\n");
		sb.append("	public ModelAndView " + CONTROLLER_NAME + "(ModelAndView modelAndView, HttpServletRequest request) {\n");
		sb.append("		modelAndView.setViewName(" + JSP_PAGE_PATH + ");\n");
		sb.append("		return modelAndView;\n");
		sb.append("	}\n");
		sb.append("\n");
		sb.append("	@RequestMapping(value = " + REQUEST_MAPPING + ", method = RequestMethod.POST)\n");
		sb.append("	@ResponseBody\n");
		sb.append("	public String " + CONTROLLER_NAME + "(HttpServletRequest request, " + MODEL_NAME +" model, PageResult pageResult) {\n");
		sb.append("		String startTime = request.getParameter(\"startTime\");\n");
		sb.append("		String endTime = request.getParameter(\"endTime\");\n");
		sb.append("		Map<String, Object> map = new HashMap<String, Object>();\n");
		sb.append("		try {\n");
		sb.append("			map.putAll(" + SERVICE_NAME + ".queryTotal(model, startTime, endTime, pageResult));\n");
		sb.append("			List<" + MODEL_NAME + "> list = " + SERVICE_NAME + ".queryList(model, startTime, endTime, pageResult);\n");
		sb.append("\n");
		sb.append("			map.put(\"list\", list);\n");
		sb.append("			map.put(\"result\", \"0\");\n");
		sb.append("		} catch (Exception e) {\n");
		sb.append("			map.put(\"result\", \"1\");\n");
		sb.append("			log.error(\"异常\", e);\n");
		sb.append("			e.printStackTrace();\n");
		sb.append("		}\n");
		sb.append("		return JsonUtil.toJson(map);\n");
		sb.append("	}\n");

		System.out.println(sb.toString());
	}
}
