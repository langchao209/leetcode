package leetcode;

/**
 * @author hjg
 *
 */
public class BinarySearch {
	
	public static int binarySearch(int[] a, int key) {
		assert(a.length > 0);
		int left = 0;
		int right = a.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		System.out.println(binarySearch(a, 3));
	}

}
