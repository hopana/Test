package tmpl;

public class CreateService {
	private static String MODEL_NAME = "CloudMerchantModel";
	private static String[] db_culumn = {""};
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(500);
		sb.append("	public static Map<String, Object> queryTotal(" + MODEL_NAME + " model, String startTime, String endTime, PageResult pageResult) {");
		sb.append("		StringBuilder sql = new StringBuilder(300);");
		sb.append("		List<Object> params = new ArrayList<Object>();");
		sb.append("		sql.append(\"SELECT COUNT(*) AS DATA_SUM FROM lepos_business.t_cloud_merchant_intention WHERE 1=1 \");");
		sb.append("		getCondition(sql, model, startTime, endTime, params);");
		sb.append("		return baseDaoBusinessSlave.executeQueryMap(sql.toString(), pageResult, params.toArray(new Object[params.size()]));");
		sb.append("	}");
		sb.append("");
		sb.append("	public static List<CloudMerchantModel> queryCloudMerchantIntention(" + MODEL_NAME + " model, String startTime, String endTime, PageResult pageResult) {");
		sb.append("		StringBuilder sql = new StringBuilder(300);");
		sb.append("		List<Object> params = new ArrayList<Object>();");
		sb.append("		List<" + MODEL_NAME + "> list = new ArrayList<" + MODEL_NAME + ">();");
		sb.append("");
		sb.append("		sql.append(\"SELECT F_id,F_applicant,F_user_name,F_idcard,F_mobile,F_province,F_city,F_create_time,F_status,F_type,F_product_type,F_remark FROM lepos_business.t_cloud_merchant_intention WHERE 1=1 \");");
		sb.append("		getCondition(sql, model, startTime, endTime, params);");
		sb.append("		sql.append(\" ORDER BY F_create_time DESC\");");
		sb.append("");
		sb.append("		baseDaoBusinessSlave.executeQueryModelList(sql.toString(), list, " + MODEL_NAME + ".class, pageResult, params.toArray(new Object[params.size()]));");
		sb.append("");
		sb.append("		return list;");
		sb.append("");
		sb.append("	}");
		sb.append("");
		sb.append("	public static void getCondition(StringBuilder sql, " + MODEL_NAME + " model, String startTime, String endTime, List<Object> list) {");
		sb.append("		StringBuilder condition = new StringBuilder(200);");
		sb.append("		String mobile = model.getFMerchantMobile();");
		sb.append("		if (StringUtil.isNotEmpty(mobile)) {");
		sb.append("			condition.append(\" AND F_merchant_mobile = ? \");");
		sb.append("			params.add(mobile);");
		sb.append("		}");
		sb.append("		return condition.toString();");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");

	}
}
