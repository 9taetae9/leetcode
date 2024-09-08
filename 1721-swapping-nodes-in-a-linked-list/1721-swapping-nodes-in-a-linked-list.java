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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode check = new ListNode(0);
        check.next = head;

        ListNode begin = check;
        ListNode end = check;

        int len = 0;
        while(check.next != null){
            check = check.next;
            len++;
        }

        

        for(int i=0; i < k; i++){
            begin = begin.next;
        }

        for(int i=0; i < len - k + 1; i++){
            end = end.next;
        }

        int temp = begin.val;
        begin.val = end.val;
        end.val = temp;

        return head;
    }
}