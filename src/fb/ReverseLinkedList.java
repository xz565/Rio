package fb;

import utils.ListNode;

// TODO add recursive solution
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curt = head;
        ListNode next = head.next;

        while (next != null) {
            curt.next = prev;

            prev = curt;
            curt = next;
            next = next.next;
        }

        curt.next = prev;

        return curt;
    }
}
