package group.six.atm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 通用方法工具类
 * 
 */
public class CommonUtil {
	
	/**
	 * 日志工具
	 */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	/**
	 * 将数组转换为{@link List}，空数组返回空的{@link ArrayList}（非null）
	 * @param <T>
	 * @param array
	 * @return
	 */
	@SafeVarargs
	public static <T> List<T> toList(T... array) {
		return array == null || array.length == 0 ? new ArrayList<>() : new ArrayList<>(Arrays.asList(array));
	}
	
	/**
	 * 将集合{@link Collection}转换为{@link List}，空集合返回空的{@link ArrayList}（非null）
	 * @param <T>
	 * @param col
	 * @return
	 */
	public static <T> List<T> toList(Collection<T> col) {
		return isBlank(col) ? new ArrayList<>() : new ArrayList<>(col);
	}
	
	/**
     * <p>Checks if a String is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * CommonUtil.isBlank(null)      = true
     * CommonUtil.isBlank("")        = true
     * CommonUtil.isBlank(" ")       = true
     * CommonUtil.isBlank("bob")     = false
     * CommonUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str  the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     */
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	/**
	 * <p>Check if a Collection is null or empty (0 element)</p>
	 * 
	 * @param col
	 * @return
	 */
	public static boolean isBlank(Collection<?> col) {
		return col == null || col.isEmpty();
	}


	
	/**
	 * 取交集
	 * @param <T>
	 * @param a
	 * @param b
	 */
	public static <T> List<T> ins(List<T> a, List<T> b) {
		if(isBlank(a) || isBlank(b)){
			return new ArrayList<>();
		}
		List<T> c = new ArrayList<>();
		for(T o : a) {
			if(b.contains(o)) {
				c.add(o);
			}
		}
		return c;
	}
	
	/**
	 * 取并集
	 * @param <T>
	 * @param a
	 * @param b
	 */
	public static <T> List<T> uni(List<T> a, List<T> b) {
		if(isBlank(a)){
			return b;
		}
		if(isBlank(b)){
			return a;
		}
		List<T> c = new ArrayList<>();
		c.addAll(a);
		for(T o : b) {
			if(!c.contains(o)){
				c.add(o);
			}
		}
		return c;
	}
	
	/**
	 * 将对象集合按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空集合，返回emptyValue，可指定空串或null）
	 * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
	 * @param collection
	 * @param notation
	 * @param emptyValue
	 * @return
	 */
	public static <T> String join(Collection<T> collection, String notation, String emptyValue) {
		if(isBlank(collection)){
			return emptyValue;
		}
		StringBuilder sb = new StringBuilder();
		for(T o : collection) {
			sb.append(notation).append(o);
		}
		return sb.substring(notation.length());
	}
	
	/**
	 * 将对象集合按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空集合，返回null）
	 * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
	 * @param collection
	 * @param notation
	 * @return
	 */
	public static <T> String join(Collection<T> collection, String notation) {
		return join(collection, notation, null);
	}


	/**
	 * 生成uuid
	 * @return uuid
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 生成6位随机整数
	 * @return
	 */
	public static int randomNumber() {
		return new Random().nextInt(900000) + 100000;
	}


	/**
	 * 模糊遮盖手机号码
	 * @param mobile
	 * @return
	 */
	public static String fuzzyPhoneNumber(String mobile) {
		if(mobile.length() != 11){
			return "***********";
		}
		return mobile.substring(0, 3) + "****" + mobile.substring(7);
	}
	
	/**
	 * 模糊遮盖银行卡号
	 * @param number
	 * @return
	 */
	public static String fuzzyCardNumber(String number) {
		if(number.length() != 19){
			return "*******************";
		}
		return number.substring(0, 3) + "************" + number.substring(15);
	}

	/**
	 * 获取系统所在的IP:port
	 */
	public static String getLocalAddrAndPort(HttpServletRequest request){
		return request.getLocalAddr()+":"+request.getLocalPort();
	}



	/**
	 * 生成随机字符串(数字)
	 * @param len 字符串的位数
	 * @return 可插入数据库的字符串
	 */
	public static String getRandomString(int len) {
		StringBuilder rndStr = new StringBuilder();
		Random rnd = new Random();
		for (int i = 0; i < len; i++) {
			rndStr.append(rnd.nextInt(10));
		}
		return rndStr.toString();
	}


}
