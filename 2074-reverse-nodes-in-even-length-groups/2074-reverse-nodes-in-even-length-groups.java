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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevGroupEnd = dummy;
        
        int groupLength = 1;
        while(prevGroupEnd.next != null){
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            int actualLength = 0;

            while(curr != null && actualLength < groupLength){
                curr = curr.next;
                actualLength++;
            }

            if(actualLength % 2 == 0){
                ListNode[] result = reverseGroup(groupStart, actualLength);
                ListNode newGroupStart = result[0];
                ListNode newGroupEnd = result[1];
                prevGroupEnd.next = newGroupStart;
                newGroupEnd.next = curr; 
                prevGroupEnd = newGroupEnd;
            }else{
                for(int i=0; i<actualLength; i++){
                    prevGroupEnd = prevGroupEnd.next;
                }
            }
            
            groupLength++;
        }

        return dummy.next;
    }

    private ListNode[] reverseGroup(ListNode start, int length){
        ListNode prev = null;
        ListNode curr = start;

        for(int i=0; i<length; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{prev, start};
    }
}