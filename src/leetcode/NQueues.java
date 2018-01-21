package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueues {
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (n < 1) {
			return res;
		}
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		dfs(board, 0, res);
		return res;
	}

	public static int totalNQueens(int n) {
		if (n < 1) {
			return 0;
		}
		return solveNQueens(n).size();
	}

	public static void dfs(char[][] board, int row, List<List<String>> res) {
		if (row == board.length) {
			res.add(construct(board));
		}
		for (int col = 0; col < board.length; col++) {
			if (isValidate(board, row, col)) {
				board[row][col] = 'Q';
				dfs(board, row + 1, res);
				board[row][col] = '.';
			}
		}
	}

	public static boolean isValidate(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'Q' && (row + col == i + j || row + j == i + col || col == j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static List<String> construct(char[][] board) {
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			res.add(new String(board[i]));
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(1);
		for (List<String> e : res) {
			for (String s : e) {
				System.out.println(s);
			}
			System.out.println();
		}
		System.out.println(res.size());

	}
}
