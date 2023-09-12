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
    ListNode* middleNode(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;

        while(fast&&fast->next){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
};
problem
If we want to return the first middle node when there are two middle nodes, we'll need to slightly modify our approach.

The logic for the slow and fast pointers remains the same. The change will come in how we determine when to move the slow pointer.

The idea is:

Start both slow and fast at the head.
Move fast two steps at a time.
Move slow one step, but only if fast can move two steps.
Here's the code to return the first of the two middle nodes:
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // If there are two middle nodes, move slow back to the first one.
        if (fast) {
            slow = slow->prev;
        }
        
        return slow;
    }
};

Let's delve into the logic of the two-pointer approach to understand why we don't need to check for an even or 
    odd number of nodes in the original problem, but we do when we want the first middle node.

Original Problem (returning the second middle node):
When fast moves two steps for every one step that slow moves, by the time fast reaches the end of the list, slow 
    will have reached the middle. If the number of nodes is odd, fast will be at the last node, and if the number 
of nodes is even, fast will be null. In both cases, slow will be at the correct position to return the second middle
node (or the only middle node if the number of nodes is odd).
Modified Problem (returning the first middle node):
When we want to return the first middle node in a list with an even number of nodes, we need to ensure that slow 
doesn't move as far as it does in the original problem. This is why we modify the loop condition to check fast->next->next.
    This ensures that slow stops one node earlier in lists with an even number of nodes.
In summary:

For the original problem, the inherent behavior of the two-pointer technique positions slow at the second middle 
node by the end of the traversal.
For the modified problem, we need to adjust the loop condition to ensure slow stops at the first middle node for lists 
with an even number of nodes.
The difference arises from how far slow moves relative to the end of the list in even-length lists. In the original 
problem, slow moves to the exact middle, whereas in the modified problem, we want slow to stop just before the middle.
