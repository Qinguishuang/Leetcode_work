//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4223 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class No3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new No3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0)
                return 0;
            Set<Character> set = new HashSet<>();
            int ans = 0;
            int pointer = -1;
            // 两个指针，i左指针， pointer右指针
            for (int i = 0; i < s.length(); i++) {
                if (i != 0) { // 说明有相同的元素，一次移除一个，至没有相同的
                    set.remove(s.charAt(i - 1));
                }
                // 如果没有相同的，一直向后走
                while (pointer + 1 < s.length() && !set.contains(s.charAt(pointer + 1))) {
                    set.add(s.charAt(++pointer));
                }
                ans = Math.max(ans, set.size());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}