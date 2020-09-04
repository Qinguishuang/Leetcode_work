//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 350 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new No257BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(solution.binaryTreePaths(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            binaryTreePaths(root, "", ans);
            return ans;
        }

        private void binaryTreePaths(TreeNode root, String temp, List<String> ans) {
            if (root == null)
                return;
            temp += root.val;
            if (root.left == null && root.right == null) {
                ans.add(temp);
            } else {
                binaryTreePaths(root.left, temp + "->", ans);
                binaryTreePaths(root.right, temp + "->", ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}