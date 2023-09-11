/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode* head) {
        ListNode* slowptr=head;
        ListNode* fastptr=head;
        
         while(fastptr&&fastptr->next!=NULL){ 
//while(head&&fastptr->next!=NULL){
// Line 15: Char 30: runtime error: member access within null pointer of type 'ListNode'
//To fix this, you should modify the loop condition to check both fastptr and fastptr-
// // your loop condition is checking head instead of fastptr. This is unnecessary since you've already initialized slowptr and fastptr to head.
//while (fastptr && fastptr->next) This ensures that both fastptr and fastptr->next are non-null before executing the loop body, thus avoiding the null pointer dereference error.
            slowptr=slowptr->next;
            fastptr=fastptr->next->next;// this is possible coz we check that fastptr->next is not a nullptr. 
            if(slowptr==fastptr)
            return true;
        }
        return false;
    }
};