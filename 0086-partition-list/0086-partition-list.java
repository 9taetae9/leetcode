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
    public ListNode partition(ListNode head, int x) {
        //beforeHead
        ListNode beforeHead = new ListNode();
        ListNode beforePtr = beforeHead;

        //afterHead
        ListNode afterHead = new ListNode();
        ListNode afterPtr = afterHead;

        while(head!=null){
            if(head.val < x){
                beforePtr.next = head;
                beforePtr = beforePtr.next;
            }else{
                afterPtr.next = head;
                afterPtr = afterPtr.next;
            }

            head = head.next;
        }

        beforePtr.next = afterHead.next;
        afterPtr.next = null;

        return beforeHead.next;
    }
}