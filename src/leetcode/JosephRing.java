package leetcode;

public class JosephRing {
	
	public static int lastIndex(int n, int k) {
		if (n < 1 || k < 1) {
			return 0;
		}
		int f = 0;
		for (int i = 2; i <= n; i++) {
			f = (f + k) % i;
		}
		return f + 1;
	}
	

	public static void main(String[] args) {
		System.out.println(lastIndex(4, 3));
	}

}
