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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* result = new ListNode(0);
        ListNode* ptr=result;
//         ListNode result = new ListNode(0); (wrong)
//         ListNode ptr=result;
// In C++, when you use the new keyword, it returns a pointer to the object. So, your result variable should be a pointer to ListNode.
        int carry=0; //Set default carry

        while(l1!=NULL || l2!=NULL){
            int sum=0+carry; //initialize sum

            if(l1!=NULL){
                sum+=l1->val; //l1.val (wrong)
//Used pointer arrow notation (->) instead of dot notation (.) where appropriate.
                l1=l1->next;
            }
            if(l2!=NULL){
                sum+=l2->val;
                l2=l2->next;
            }

            carry=sum/10;
            sum=sum%10;
            ptr->next=new ListNode(sum);
            ptr=ptr->next;
        }

        if(carry==1) ptr->next=new ListNode(1);
        return result->next;
    }
};