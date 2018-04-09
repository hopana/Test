package json;

import com.alibaba.fastjson.JSONObject;

public class JsonDemo {
	public static void main(String[] args) {
		int[] codeArr = new int[] {1,1,1,1};
		int[] creditArr = new int[] {2,2,2};
		int[] debitArr = new int[] {3,3,3};
		
		JSONObject retJson = getLevelLimitJson(codeArr, creditArr, debitArr);
		
		System.out.println(retJson.toJSONString());
	}
	
	
	public static com.alibaba.fastjson.JSONObject getLevelLimitJson(int[] codeArr, int[] creditArr, int[] debitArr) {
		com.alibaba.fastjson.JSONObject levJson = new com.alibaba.fastjson.JSONObject();
		
		com.alibaba.fastjson.JSONArray codeLimitArr = new com.alibaba.fastjson.JSONArray();
		
		for (int i: codeArr) {
			codeLimitArr.add(i);
		}
		
		com.alibaba.fastjson.JSONObject cardJson = new com.alibaba.fastjson.JSONObject();
		com.alibaba.fastjson.JSONArray creditLimitArr = new com.alibaba.fastjson.JSONArray();
		com.alibaba.fastjson.JSONArray debitLimitArr = new com.alibaba.fastjson.JSONArray();
	
		for (int i : creditArr) {
			creditLimitArr.add(i);
		}
		
		for (int i : debitArr) {
			debitLimitArr.add(i);
		}
		
		cardJson.put("credit", creditLimitArr);
		cardJson.put("debit", debitLimitArr);
		
		levJson.put("card", cardJson);
		levJson.put("code", codeLimitArr);
		
		return levJson;
	}

}
