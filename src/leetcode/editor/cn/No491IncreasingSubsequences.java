//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 176 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No491IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new No491IncreasingSubsequences().new Solution();
        System.out.println(solution.findSubsequences(new int[]{4, 6, 7, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= nums[i - 1]) {
                    count++;
                } else {
                    // 开始下标
                    for (int j = i - count; j < i-1; j++) {
                        // 个数 从2到count
                        for (int k = 2; k <= count; k++) {
                            // 加进去
                            if (k + j > i) {
                                break;
                            }
                            for (int l = 0; l < k; l++) {
                                temp.add(nums[j + l]);
                            }
                            ans.add(new ArrayList<>(temp));
                            temp.clear();
                        }
                    }
                    count = 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}