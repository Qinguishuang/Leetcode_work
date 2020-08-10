//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 
//
// 重复出现的子串要计算它们出现的次数。 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 注意： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 字符串 
// 👍 234 👎 0


package leetcode.editor.cn;

public class No696CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new No696CountBinarySubstrings().new Solution();
        System.out.println(solution.countBinarySubstrings("10101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int ans = 0;
            char last = s.charAt(0) == '0' ? '1' : '0'; // 上一个计数的值
            int lastCount = 0; // 上一个数出现多少次
            int nowCount = 0; // 当前的数出现多少次
            // 00110011  “0011”，“01”，“1100”，“10”，“0011”， “01”。
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != last) {
                    nowCount++;
                } else {
                    ans += Math.min(lastCount, nowCount); // 加上数量
                    last = s.charAt(i - 1);
                    lastCount = nowCount;
                    nowCount = 1;
                }
            }
            return ans + Math.min(lastCount, nowCount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}