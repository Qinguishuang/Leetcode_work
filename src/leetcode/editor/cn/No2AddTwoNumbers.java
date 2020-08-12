//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4742 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;

public class No2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new No2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(0);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);
        System.out.println(solution.addTwoNumbers(l1, l2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummyNode = new ListNode(0);
            int carry = 0;
            int sum = 0;
            ListNode head = dummyNode;
            while (l1 != null || l2 != null) {
                int num1 = 0, num2 = 0;
                if (l1 != null) {
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    num2 = l2.val;
                    l2 = l2.next;
                }

                sum = carry + num1 + num2;
                carry = sum / 10;
                sum = sum % 10;
                head.next = new ListNode(sum);
                head = head.next;
            }
            if (carry == 1) {
                head.next = new ListNode(1);
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}