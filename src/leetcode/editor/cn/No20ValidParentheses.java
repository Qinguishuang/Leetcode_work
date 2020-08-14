//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1781 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import static java.util.Set.of;

public class No20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new No20ValidParentheses().new Solution();
        System.out.println(solution.isValid("[]{}()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0)
                return true;
            if (s.length() % 2 == 1)
                return false;
            Set<Character> left = Set.of('(', '[', '{');
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (left.contains(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                            (s.charAt(i) == ']' && stack.peek() == '[') ||
                            (s.charAt(i) == '}') && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}