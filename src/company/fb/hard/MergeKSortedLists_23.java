package company.fb.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import common.types.ListNode;

public class MergeKSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode curt = head;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curt.next = node;
            curt = curt.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;
    }
}
