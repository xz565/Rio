package company.gg;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.types.ListNode;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {

        // #1 like merge sort

        // priority queue
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

//        for (ListNode node : lists) {
//            heap.add(node;)
//        }
//        Arrays.stream(lists).forEach(heap::add);
        for (ListNode listNode : lists) if (listNode != null){
            heap.add(listNode);
        }
        ListNode head = new ListNode(0);
        ListNode curt = head;
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            if (tmp.next != null) {
                heap.add(tmp.next);
            }
            curt.next = tmp;
            curt = curt.next;
        }

        return head.next;
    }
}
