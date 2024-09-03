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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];

        int len = 0;
        ListNode node = head;

        while(node!=null){
            len++;
            node = node.next;
        }

        int baseSize = len / k;
        int extra = len % k;

        node = head;

        for(int i=0; i<k; i++){
            ListNode partHead = node;
            int partSize = extra > 0 ? baseSize + 1 : baseSize;
            
            for(int j=0; j < partSize - 1; j++){
                node = node.next;
            }

            if(node != null){
                ListNode next = node.next;
                node.next = null;
                node = next;
            }

            parts[i] = partHead;
            extra--; 
        }
        return parts;
    }
}