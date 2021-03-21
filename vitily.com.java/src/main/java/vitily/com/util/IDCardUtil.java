package vitily.com.util;

/**
 * 身份证位数转换工具类
 * 鹏华提供
 */
public class IDCardUtil {
	/**
	 * 15位身份证转换为18身份证
	 * @param id15 15位数的身份证号码
	 * @return 2
	 */
	public static  String get18IDNumber(String id15) {
		final int[] W = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
		final String[] A = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		int i, j, s = 0;
		String newId;
		newId = id15;
		newId = newId.substring(0, 6) + "19" + newId.substring(6, id15.length());
		for (i = 0; i < newId.length(); i++) {
			j = Integer.parseInt(newId.substring(i, i + 1)) * W[i];
			s = s + j;
		}
		s = s % 11;
		newId = newId + A[s];
		return newId;
	}
	/**
	 * 15位身份证转换为18身份证
	 * @param id18 18位数的身份证号码
	 * @return 1
	 */
	public static String get15IDNumber(String id18) {
		StringBuilder  newId = new StringBuilder("");
		if(null != id18 && id18.length() == 18){
			for (int i = 0; i < id18.length(); i++) {
				if(i != 6 && i != 7 && i != 17){
					newId.append(id18.substring(i, i + 1));
				}
			}
		}
		return newId.toString();
	}
}

