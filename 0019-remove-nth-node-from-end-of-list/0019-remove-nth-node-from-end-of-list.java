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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode next = dummy.next;

        int sz = 1;
        while(next != null && next.next != null){
            curr = next;
            next = next.next;

            sz++;
        }

        curr = dummy;
        next = dummy.next;

        for(int i=0; i < sz - n ; i++){
            curr = next;
            next = next.next;
        }

        curr.next = next.next;
        
        

        return dummy.next;
    }
}