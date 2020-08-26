//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 853 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No46Permutations {
    public static void main(String[] args) {
        Solution solution = new No46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> temp = new ArrayList<>();
            boolean[] isVisited = new boolean[nums.length];
            backTracing(nums, temp, isVisited);
            return ans;
        }

        private void backTracing(int[] nums, List<Integer> temp, boolean[] isVisited) {
            if (temp.size() == nums.length) {
                ans.add(new ArrayList<>(temp));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (!isVisited[i]) {
                        isVisited[i] = true;
                        temp.add(nums[i]);
                        backTracing(nums, temp, isVisited);
                        isVisited[i] = false;
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }

        /**
         * 原数组全排列
         *
         * @param n      数组长度(用来判断是否排序完毕)
         * @param output 临时数组(需要初始化)
         * @param res    结果
         * @param first  需要排序的值得下标
         */
        private void backTracing(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
            if (n == output.size()) {
                res.add(new ArrayList<>(output));
            } else {
                for (int i = first; i < n; i++) {
                    Collections.swap(output, first, i);
                    backTracing(n, output, res, i + 1);
                    Collections.swap(output, first, i);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}