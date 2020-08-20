//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1160 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;

public class No206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new No206ReverseLinkedList().new Solution();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        System.out.println(solution.reverseList(l));
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
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            ListNode pre = null;
            ListNode curr = head;
            ListNode next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}