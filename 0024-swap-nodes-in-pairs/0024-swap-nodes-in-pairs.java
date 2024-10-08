/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(head != null && head.next != null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prev.next = head.next;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }
}