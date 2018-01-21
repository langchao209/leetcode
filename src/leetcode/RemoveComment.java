package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RemoveComment {

	private static int flag = 0;

	public static List<String> removeComments(String[] source) {
		ArrayList<String> result = new ArrayList<>();
		if (source.length < 1) {
			return result;
		}
		String part = "";
		for (String s : source) {
			String temp = parseLine(s);
			part += temp;
			if (flag == 0 && part.length() > 0) {
				result.add(part);
				part = "";
			}
		}

		return result;
	}

	public static String parseLine(String s) {
		StringBuilder sb = new StringBuilder();
		int j = 1;
		for (; j < s.length(); j++) {
			if (flag == 0) {
				if (s.charAt(j - 1) == '/' && s.charAt(j) == '/') {
					return sb.toString();
				} else if (s.charAt(j - 1) == '/' && s.charAt(j) == '*') {
					flag = 1;
					++j;
				} else {
					sb.append(s.charAt(j - 1));
				}
			} else {
				if (s.charAt(j - 1) == '*' && s.charAt(j) == '/') {
					flag = 0;
					++j;
				}
			}
		}
		if (flag == 0 && j <= s.length()) {
			sb.append(s.charAt(j - 1));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] source1 = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		String[] source = { "a/*comment", "line", "more_comment*/b" };
		List<String> result = removeComments(source);
		for (String s : result) {
			System.out.println(s);
		}
	}
}
