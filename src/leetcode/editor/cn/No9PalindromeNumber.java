//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1214 👎 0


package leetcode.editor.cn;

public class No9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new No9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome_(12321));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            int i = 0, j = x;
            while (j != 0) {
                i = i * 10 + j % 10;
                j = j / 10;
            }
            return x == i;
        }

        public boolean isPalindrome__(int x) {
            if (x < 0)
                return false;
            int temp = 1;
            int num = x;
            while (num > 0) {
                temp *= 10;
                num /= 10;
            }
            while (x != 0) {
                int l = x / temp;
                int r = x % 10;
                if (l != r) {
                    return false;
                } else {
                    temp /= 10;
                    x = x & temp % 10;
                }
            }
            return true;
        }

        public boolean isPalindrome_(int x) {
            if (x < 0)
                return false;
            int temp = 0;
            while (temp < x) {
                temp = temp * 10 + x % 10;
                x /= 10;
            }
            return x == temp || x / 10 == temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}