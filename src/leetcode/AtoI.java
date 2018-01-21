package leetcode;

public class AtoI {

	private static final int INT_MAX  = 2147483647;
	private static final int INT_MIN = -2147483648;
										
	
	public static int atoi(String str) {
		str = str.trim();
		if (str.length() < 1) {
			return 0;
		}
		int positive = 1;
		int i = 0;
		if (str.charAt(0) == '-') {
			positive = -1;
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		int result = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			int temp = result * 10 + str.charAt(i) - '0';
			// 同时考虑乘法溢出和加法溢出
			if (temp != 0 && (numDigits(temp) <= numDigits(result) || temp < result)) {
				return positive == 1 ?  INT_MAX : INT_MIN;
			}
			result = temp;
			i++;
			
		}
		return positive * result;
	}
	
	private static int numDigits(int n) {
		int result = 0;
		while (n != 0) {
			result++;
			n /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(atoi("2147483648"));
		System.out.println(1052254545 * 10 < 1052254545);
		System.out.println(numDigits(INT_MAX));
	}
}
//1932610867
//10522545459