package utils;

/**
 * 返回消息封装类
 * 
 * @author Mickey
 */
public class Result {

	/** 错误代码 */
	public Integer code;

	/** 错误信息 */
	public String msg;

	/** 返回数据 */
	public Object data;
	
	public Result() {
		this.code = -1;
		this.msg = "";
	}

	public Result(Integer errCode, String errMsg) {
		this.code = errCode;
		this.msg = errMsg;
	}

	public Result(Integer errCode, String errMsg, Object data) {
		this.code = errCode;
		this.msg = errMsg;
		this.data = data;
	}

	public Result setResult(Integer errCode, String errMsg) {
		this.code = errCode;
		this.msg = errMsg;

		return this;
	}

	public Result setResult(Integer errCode, String errMsg, Object data) {
		this.code = errCode;
		this.msg = errMsg;
		this.data = data;

		return this;
	}

	public Result clear() {
		this.code = -1;
		this.msg = "";
		this.data = null;

		return this;
	}
	
	@Override
	public String toString() {
		String data = JsonUtils.objectToJson(this.data);

		return "{\"code\":" + this.code + ",\"msg\":\"" + this.msg + "\",\"data\":" + data.toString() + "}";
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
