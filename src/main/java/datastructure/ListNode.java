package datastructure;

import java.util.Arrays;
import java.util.List;

/**
 * created at 2019/12/10
 *
 * @author shixi
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode generate() {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);

//        listNode11.next = listNode12;
//        listNode12.next = listNode13;
//        listNode13.next = listNode14;
//        listNode14.next = listNode15;

        return listNode11;
    }

    public static List<ListNode> generate2() {
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(1);
        ListNode listNode13 = new ListNode(8);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(0);
        ListNode listNode23 = new ListNode(1);
        ListNode listNode24 = new ListNode(8);
        ListNode listNode25 = new ListNode(4);
        ListNode listNode26 = new ListNode(5);

        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;

        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        listNode25.next = listNode26;


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
