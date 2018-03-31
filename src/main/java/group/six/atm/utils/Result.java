package group.six.atm.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * 封装返回数据
 * 
 */
public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Result() {
		//code==0,数据正常
		put("code", 0);
	}
	
	/**
	 * 异常
	 * @return
	 */
	public static Result error() {
		return error(BusCode.ERR_UNKONWN, "未知异常，请联系管理员");
	}
	
	/**
	 * 异常
	 * @param msg 文本消息
	 * @return
	 */
	public static Result error(String msg) {
		return error(BusCode.ERR_UNKONWN, msg);
	}

	/**
	 * 指定异常code值，和异常描述
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}
	
	/**
	 * 正常
	 * @param msg 文本消息
	 * @return
	 */
	public static Result ok(String msg) {
		Result r = new Result();
		r.put("msg", msg);
		return r;
	}
	
	/**
	 * 正常
	 * @param map 需要返回的数据
	 * @return
	 */
	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}
	
	/**
	 * 正常
	 * @return
	 */
	public static Result ok() {
		return new Result();
	}

	/**
	 * 将需要返回的数据put入
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
