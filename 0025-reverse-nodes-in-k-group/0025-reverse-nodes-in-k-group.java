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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
             return head;
        }

        // 더미 노드 추가
        ListNode dummy = new ListNode(-1, head);
        // 직전 그룹 마지막 노드 
        ListNode prevGroupEnd = dummy;
        
        
        while(true){
            // k번째 노드 얻기
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if(kthNode == null){
                break;
            }
            
            ListNode nextGroupStart = kthNode.next;
            // reverse current group reversed {s, e}
            ListNode[] reversed = reverseGroup(prevGroupEnd.next, kthNode);
            prevGroupEnd.next = reversed[0];
            reversed[1].next = nextGroupStart;

            prevGroupEnd = reversed[1];
        }
        
        return dummy.next;
    }

    private ListNode getKthNode(ListNode prev, int k){
        ListNode curr = prev;
        for(int i=0; i<k && curr != null; i++){
            curr = curr.next;
        }

        return curr;
    }

    private ListNode[] reverseGroup(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode curr = prev.next;
        while(prev != end){
            // 다음 노드 킵
            ListNode temp = curr.next;
            // 현재 노드 직전 노드 가리키기
            curr.next = prev;

            // 직전 노드 현재 노드로 
            prev = curr;

            // 현재 노드는 다음 노드로
            curr = temp;
        }
        
        return new ListNode[]{prev, start};
    }
}