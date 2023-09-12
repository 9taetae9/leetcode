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
        if (!head) return NULL;  // Check for empty list
        
        ListNode* current = head;
        ListNode* nextDistinct = head;

        while (nextDistinct) {
            if (current->val != nextDistinct->val) {
                current->next = nextDistinct;
                current = nextDistinct;
            }
            nextDistinct = nextDistinct->next;
        }

        // Terminate the list
        if (current) {
            current->next = NULL;
        }
        
        return head;
    }
};