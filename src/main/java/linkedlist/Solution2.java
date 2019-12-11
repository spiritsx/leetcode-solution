package linkedlist;

import java.util.List;

/**
 * created at 2019/12/11
 *
 * @author shixi
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int add = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = x + y + add;
            if (num >= 10) {
                num -= 10;
                add = 1;
            } else {
                add = 0;
            }

            ListNode newNode = new ListNode(num);
            head.next = newNode;
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (add > 0) {
            ListNode newNode = new ListNode(add);
            head.next = newNode;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        List<ListNode> listNodes = ListNode.generate2();

        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(listNodes.get(0), listNodes.get(1));
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }
}
