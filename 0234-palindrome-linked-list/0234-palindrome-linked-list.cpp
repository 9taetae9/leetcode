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
    bool isPalindrome(ListNode* head) {
        stack<int> s;
        stack<int> reverse_s;
        stack<int> temp;
        while(head){
            s.push(head->val);
            head=head->next;
        }
        temp=s;
        while(!s.empty()){
            reverse_s.push(s.top());
            s.pop();
        }
        
        if(reverse_s==temp) return true;
        else return false;
    }
};