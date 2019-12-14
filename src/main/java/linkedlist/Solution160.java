package linkedlist;

import java.util.*;

/**
 * created at 2019/12/13
 *
 * @author shixi
 */
public class Solution160 {

    private int skipA;
    private int skipB;

    public Solution160(int skipA, int skipB) {
        this.skipA = skipA;
        this.skipB = skipB;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(-1);
        ListNode dummyB = new ListNode(-1);
        dummyA.next = headA;
        dummyB.next = headB;
        boolean endA = false;
        boolean endB = false;
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            if (headA == null && !endA) {
                headA = dummyB.next;
                endA = true;
            }
            if (headB == null && !endB) {
                headB = dummyA.next;
                endB = true;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        List<ListNode> listNodes = ListNode.generate2();
        Solution160 solution160 = new Solution160(0, 0);
        ListNode headA = listNodes.get(0);
        ListNode headB = listNodes.get(1);
        if (solution160.skipA > 0 && solution160.skipB > 0) {
            int skipA = solution160.skipA - 1;
            int skipB = solution160.skipB - 1;
            ListNode headATemp = headA;
            ListNode headBTemp = headB;
            while (skipA > 0) {
                headATemp = headATemp.next;
                skipA--;
            }
            while (skipB > 0) {
                headBTemp = headBTemp.next;
                skipB--;
            }
            if (headATemp.next.val == headBTemp.next.val) {
                headATemp.next = headBTemp.next;
            }
        }

        ListNode intersectionNode = solution160.getIntersectionNode3(headA, headB);
        System.out.println(intersectionNode);
    }
}
