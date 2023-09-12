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
    ListNode* deleteDuplicates(ListNode* head) {
        set<int> s;
        ListNode* newHead = head;
        ListNode* newHead2 = newHead;
        
        // Insert all values into the set
        while(head){
            s.insert(head->val);
            head = head->next;
        }
        
        ListNode* prev = nullptr;
        for(auto e: s){
            newHead->val = e;
            prev = newHead;
            newHead = newHead->next;
        }
        
        if (prev) {
            prev->next = NULL;
        }
        
        return newHead2;
    }
};
