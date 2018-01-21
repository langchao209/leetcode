package leetcode;

public class ShiftArray {
	
	// k < 0 shift right; k > 0 shift left
	public static void shiftArray(int[] array, int k) {
		if (array.length < 2) {
			return;
		}
		while (k < 0) {
			k += array.length;
		}
		k = k % array.length;
		if (k == 0) {
			return;
		}
		
		swap(array, 0, k);
		swap(array, k, array.length);
		swap(array, 0, array.length);

	}

	private static void swap(int[] array, int start, int end) {
		int left = start;
		int right = end - 1;
		while(left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}	
	}

	public static void main(String[] args) {
		int [] a = {1, 2, 3, 4};
		for (int e : a) {
			System.out.print(e + " ");
		}
		System.out.println();
//		System.out.println(-4 % 3); // -1
		shiftArray(a, 5);
		for (int e : a) {
			System.out.print(e + " ");
		}
	}
}
