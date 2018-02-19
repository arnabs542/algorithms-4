/*
*
* 147. Insertion Sort List
* https://leetcode.com/problems/insertion-sort-list/description/
* ----------------------------------------------------------------------------------------------------------------------
* Sort a linked list using insertion sort.
*
* */

package linkedlist;

public class insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode cur = head; // the current node to be inserted
        ListNode pre = dummy; // insert node between pre and pre.next
        ListNode next = null; // the next node to be inserted

        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) pre = pre.next;

            // insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}
