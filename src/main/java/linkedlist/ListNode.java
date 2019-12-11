package linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * created at 2019/12/10
 *
 * @author shixi
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode generate() {
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(3);

        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;

        return listNode11;
    }

    public static List<ListNode> generate2() {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(8);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(3);

        ListNode listNode21 = new ListNode(9);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);

        listNode11.next = listNode12;
//        listNode12.next = listNode13;
//        listNode13.next = listNode14;

//        listNode21.next = listNode22;
//        listNode22.next = listNode23;
        return Arrays.asList(listNode11, listNode21);
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append("->");
            node = node.next;
        }
        return builder.substring(0, builder.length() - 2);
    }
}
