package linkedlist;

/**
 * created at 2019/12/11
 *
 * @author shixi
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution328 solution328 = new Solution328();
        ListNode listNode = ListNode.generate();
        ListNode oddEvenList = solution328.oddEvenList(listNode);
        System.out.println(oddEvenList);
    }
}
