package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjg
 *
 */
public class SubPlalindrome {

	public static List<String> findAllSubPlalindrome(String input) {
		if (input.length() == 0) {
			return new ArrayList<String>(0);
		}
		List<String> result = new ArrayList<>();
		for (int center = 0; center < 2 * input.length() - 1; center++) {
			int left = center / 2;
			int right = left + center % 2;
			while (left >= 0 && right < input.length()) {
				if (input.charAt(left) != input.charAt(right)) {
					break;
				} else {
					result.add(input.substring(left, right + 1));
					left--;
					right++;
				}
			}
		}

		return result;
	}

	/**
	 * @param input
	 * @return Find all the plalindrome substring by Manacher's Theory
	 */
	public static ArrayList<ArrayList<String>> findAllSubPlalindromeByManacher(String input) {
		if (input.length() == 0) {
			return new ArrayList<ArrayList<String>>(0);
		}
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		int[] p = new int[2 * input.length() + 3];
		StringBuilder sb = new StringBuilder();
		sb.append("@#");
		for (int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i)).append("#");
		}
		sb.append("$");
		String t = sb.toString();

		int mx = 0, id = 0;
		for (int i = 1; i < t.length() - 2; i++) {
			ArrayList<String> temp = new ArrayList<>();
			// p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
			if (mx > i) {
				temp.addAll(result.get(2 * id - i - 1));
				p[i] = Math.min(p[2 * id - i], mx - i);
			} else {
				p[i] = 1;
			}
			while (t.charAt(i - p[i]) == t.charAt(i + p[i])) {
				p[i]++;
				if (t.charAt(i + p[i] - 1) == '#') {
					temp.add(input.substring((i - p[i]) / 2, (i + p[i] - 2) / 2));
				}
			}
			if (p[i] + i > mx) {
				mx = p[i] + i;
				id = i;
			}
			result.add(temp);
		}
		int ans = 0;
		for (int v : p)
			ans += v / 2;

		return result;
	}

	public static void main(String[] args) {
		String input = "abbac";
		List<ArrayList<String>> subPlalindromes = findAllSubPlalindromeByManacher(input);
		if (subPlalindromes.isEmpty()) {
			System.out.println("empty!");
		}
		for (ArrayList<String> e : subPlalindromes) {
			if (e.isEmpty())
				continue;
			for (String s : e) {
				System.out.print(s + "\t");
			}
			System.out.println("\n");
		}
		System.out.println("done!");

		List<String> subPlalindrome = findAllSubPlalindrome(input);
		if (subPlalindrome.isEmpty()) {
			System.out.println("empty!");
		}
		for (String s : subPlalindrome) {
			System.out.print(s + "\t");
		}

	}
}
