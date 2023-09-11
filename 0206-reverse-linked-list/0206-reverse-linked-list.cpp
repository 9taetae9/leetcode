/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        stack<int> valueStack;

        while(head!=nullptr){
            valueStack.push(head->val);
            head=head->next;
        }

        ListNode* reverse= new ListNode(0);
        ListNode* ptr= reverse;
        while(!valueStack.empty()){
            ptr->next=new ListNode(valueStack.top());
            valueStack.pop();
            ptr=ptr->next;
        }
        ListNode* result=reverse->next;
        delete reverse;
        return result;
    }
};