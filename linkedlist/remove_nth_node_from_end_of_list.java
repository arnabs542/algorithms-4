/*
*
* Given a linked list, remove the nth node from the end of list and return its head.
*
* For example,
*
* Given linked list: 1->2->3->4->5, and n = 2.
* After removing the second node from the end, the linked list becomes 1->2->3->5.
*
* Note:
* Given n will always be valid.
*
* */

package linkedlist;

public class remove_nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy, walker = dummy;
        int i = 0;
        // make runner and walker has distance n + 1
        while (i <= n) {
            runner = runner.next;
            i++;
        }

        // walker gets to the node before the goal node
        while (runner != null) {
            runner = runner.next;
            walker = walker.next;
        }

        // get rid of goal node
        walker.next = walker.next.next;
        return dummy.next;
    }
}
