/*
*
* 143. Reorder List
* https://leetcode.com/problems/reorder-list/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given a singly linked list L: L0→L1→…→L(n-1)→Ln,
* reorder it to: L0→Ln→L1→L(n-1)→L2→L(n-2)→…
*
* You must do this in-place without altering the nodes' values.
*
* For example,
* Given {1,2,3,4}, reorder it to {1,4,2,3}.
*
* 思路：三步走
* 1. Find the middle of the list
* 2. Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
* 3. Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
*
* */

package linkedlist;

public class reorder_list {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        // 1. Find the middle of the list
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        // 2. Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        // preMiddle -> pre; preCurrent -> cur; cur-> next
        ListNode mid = walker, cur = walker.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = mid.next;
            mid.next = next;
        }

        // 3. Insert the second half in the first half  1->2->3->6->5->4 to 1->6->2->5->3->4
        walker = head;
        runner = mid.next;
        while (walker != mid) {
            mid.next = runner.next;
            runner.next = walker.next;
            walker.next = runner;
            walker = runner.next;
            runner = mid.next;
        }
    }
}
