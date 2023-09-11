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
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        // Reverse the second half
        slow = reverseList(slow);

        // Compare the first half and reversed second half
        fast = head;
        while (slow) {
            if (fast->val != slow->val) return false;
            fast = fast->next;
            slow = slow->next;
        }

        return true;
    }

    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        while (head) {
            ListNode* nextTemp = head->next;
            head->next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
};






