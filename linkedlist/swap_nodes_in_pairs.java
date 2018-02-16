/*
*
* 24. Swap Nodes in Pairs
* https://leetcode.com/problems/swap-nodes-in-pairs/description/
*
* Given a linked list, swap every two adjacent nodes and return its head.
*
* For example,
* Given 1->2->3->4, you should return the list as 2->1->4->3.
*
* Your algorithm should use only [constant space]. You may not modify the values in the list, only nodes itself can be changed.
*
* */

package linkedlist;

public class swap_nodes_in_pairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next, second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummy.next;
    }
}
