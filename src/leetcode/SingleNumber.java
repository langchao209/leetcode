package leetcode;

public class SingleNumber {
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	public static void main(String[] args) {
		int[] A = {2,2,2,4};
		System.out.println(singleNumber(A));
	}
}
