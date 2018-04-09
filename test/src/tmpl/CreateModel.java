package tmpl;

public class CreateModel {
	private static String[] DB_CULUMN = { "F_id", "F_applicant", "F_user_name", "F_merchant_name", "F_idcard", "F_mobile", "F_province", "F_city", "F_address", "F_trade", "F_trade_parent", "F_email",
			"F_remark", "F_comefrom", "F_type", "F_product_type", "F_status", "F_create_time", "F_claim_time" };

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(500);
		sb.append("public class CloudMerchantModel implements Serializable {\n");

		for (int i = 0; i < DB_CULUMN.length; i++) {
			sb.append("	private String " + getFieldName(DB_CULUMN[i]) + ";\n");
		}

		sb.append("\n");
		
		for (int i = 0; i < DB_CULUMN.length; i++) {
			sb.append("	public String get" + getFieldName(DB_CULUMN[i]) + "() {\n");
			sb.append("		return FId;\n");
			sb.append("	}\n");
			sb.append("	public String set" + getFieldName(DB_CULUMN[i]) + "(String " + getFieldParam(getFieldName(DB_CULUMN[i])) + ") {\n");
			sb.append("		" + getFieldName(DB_CULUMN[i]) + " = " + getFieldParam(getFieldName(DB_CULUMN[i])) + ";\n");
			sb.append("	}\n");
		}
		
		sb.append("}\n");
		
		System.out.println(sb.toString());
	}

	public static String getFieldName(String s) {
		if (s == null || "".equals(s) || s.trim() == "") {
			return "";
		}
		
		String[] arr = s.split("_");
        
        String attr = "";
        for (String str : arr) {
            attr += str.substring(0,1).toUpperCase() + str.substring(1, str.length());
        }
        
		return attr;
	}
	
	public static String getFieldParam(String s) {
		String attr = getFieldName(s);
		
		return attr.substring(0,1).toLowerCase() + attr.substring(1, attr.length());
	}
}
