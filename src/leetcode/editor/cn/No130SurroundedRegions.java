//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 322 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class No130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new No130SurroundedRegions().new Solution();
        var board = new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                        solve(board, i, j);
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void solve(char[][] board, int i, int j) {
            if (board[i][j] == 'O') {
                board[i][j] = 'A';
            } else {
                return;
            }

            if (i - 1 >= 0)
                solve(board, i - 1, j);
            if (i + 1 < board.length)
                solve(board, i + 1, j);
            if (j - 1 >= 0)
                solve(board, i, j - 1);
            if (j + 1 < board[0].length)
                solve(board, i, j + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}