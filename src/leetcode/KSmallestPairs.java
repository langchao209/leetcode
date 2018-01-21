package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import scala.Tuple3;

public class KSmallestPairs {

	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		if (nums1.length <= 0 || nums2.length <= 0)
			return new ArrayList<int[]>();
		PriorityQueue<Tuple3<Integer, Integer, Integer>> queue = new PriorityQueue<>(k,
				new Comparator<Tuple3<Integer, Integer, Integer>>() {
					public int compare(Tuple3<Integer, Integer, Integer> o1, Tuple3<Integer, Integer, Integer> o2) {
						if (o1._1() + o1._2() > o2._1() + o2._2())
							return 1;
						else if (o1._1() + o1._2() < o2._1() + o2._2())
							return -1;
						else
							return 0;
					}
				});
		for (int i = 0; i < k && i < nums1.length; i++) {
			queue.add(new Tuple3<Integer, Integer, Integer>(nums1[i], nums2[0], 0));
		}
		ArrayList<int[]> result = new ArrayList<>(k);
		while (k-- > 0 && !queue.isEmpty()) {
			Tuple3<Integer, Integer, Integer> temp = queue.poll();
			result.add(new int[] { temp._1(), temp._2() });
			if (temp._3() < nums2.length - 1) {
				queue.add(new Tuple3<Integer, Integer, Integer>(temp._1(), nums2[temp._3() + 1], temp._3() + 1));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2 };
		int[] nums2 = { 1, 2, 3 };
		int k = 3;
		List<int[]> result = kSmallestPairs(nums1, nums2, 10);
		for (int[] r : result) {
			System.out.println(r[0] + " " + r[1]);
		}
	}
}
