//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 884 👎 0


package leetcode.editor.cn;

import java.util.*;

public class No17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new No17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            Map<Character, List<Character>> map = new HashMap<>();
            map.put('2', Arrays.asList('a', 'b', 'c'));
            map.put('3', Arrays.asList('d', 'e', 'f'));
            map.put('4', Arrays.asList('g', 'h', 'i'));
            map.put('5', Arrays.asList('j', 'k', 'l'));
            map.put('6', Arrays.asList('m', 'n', 'o'));
            map.put('7', Arrays.asList('p', 'q', 'r', 's'));
            map.put('8', Arrays.asList('t', 'u', 'v'));
            map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
            List<String> ans = new ArrayList<>();
            backTracing(digits, map, ans, 0, new StringBuilder());
            return ans;
        }

        private void backTracing(String digits, Map<Character, List<Character>> map, List<String> ans, int i, StringBuilder stringBuilder) {
            if (stringBuilder.length() == digits.length()) {
                ans.add(stringBuilder.toString());
            } else {
                List<Character> temp = map.get(digits.charAt(i));
                for (int j = 0; j < temp.size(); j++) {
                    stringBuilder.append(temp.get(j));
                    backTracing(digits, map, ans, i + 1, stringBuilder);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}