package solution401_450;

import datastructure.ListNode;

import java.util.List;

/**
 * created at 2019/12/10
 *
 * @author shixi
 */
public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = listSize(l1);
        int l2Size = listSize(l2);
        if (l1Size > l2Size) {
            l2 = fillHeadZero(l2, l1Size - l2Size);
        } else {
            l1 = fillHeadZero(l1, l2Size - l1Size);
        }

        ListNode dummy = helper(l1, l2, null);
        if (dummy.val >= 10) {
            ListNode temp = dummy;
            dummy = new ListNode(1);
            dummy.next = temp;
            temp.val -= 10;
        }

        return dummy;
    }

    private ListNode fillHeadZero(ListNode node, int sub) {
        if (sub == 0) {
            return node;
        }
        for (int i = 0; i < sub; i++) {
            ListNode temp = node;
            node = new ListNode(0);
            node.next = temp;
        }

        return node;
    }

    private int listSize(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private ListNode helper(ListNode l1, ListNode l2, ListNode node) {
        if (l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val);
        }
        if (node == null) {
            node = new ListNode(0);
        }
        ListNode nextNode = helper(l1.next, l2.next, node.next);
        int add = 0;
        if (nextNode.val >= 10) {
            add = 1;
            nextNode.val -= 10;
        }
        node.val = l1.val + l2.val + add;
        node.next = nextNode;
        return node;
    }

    public static void main(String[] args) {
        List<ListNode> listNodes = ListNode.generate2();

        Solution445 solution445 = new Solution445();
        ListNode listNode = solution445.addTwoNumbers(listNodes.get(0), listNodes.get(1));
        System.out.println(listNode);
    }
}
