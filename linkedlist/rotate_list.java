/*
*
* 61. Rotate List
* https://leetcode.com/problems/rotate-list/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given a list, rotate the list to the right by k places, where k is non-negative.
*
* Example:
* Given 1->2->3->4->5->NULL and k = 2,
* return 4->5->1->2->3->NULL.
*
* 思路：K有可能大于linkedlist的length
* 如：
* Ex: {1,2,3} k=2 Move the list after the 1st node to the front
* Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
* */

package linkedlist;

public class rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy, runner = dummy;
        int len = 0;

        // find the length of
        while (runner.next != null) {
            len++;
            runner = runner.next;
        }

        // find the  len - k % len node
        for (int i = len - k % len; i > 0; i--) {
            walker = walker.next;
        }

        // rotation
        runner.next = dummy.next;
        dummy.next = walker.next;
        walker.next = null;
        return dummy.next;
    }
}
