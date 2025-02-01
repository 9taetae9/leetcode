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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummy = new ListNode();
         dummy.next = head;
         ListNode prev = dummy;

         //reverse 구간 시작 직전 노드
         for(int i=0; i<left-1; i++){
            prev = prev.next;
         }

         ListNode curr = prev.next;
         ListNode then = curr.next; // 가장 앞으로 보낼 노드

         for(int i=0; i<right-left; i++){
            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;

            then = curr.next;
         }

        return dummy.next;
    }
}