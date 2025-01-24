/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversal2(root);
        return list;
        
    }

    private void inorderTraversal2(TreeNode node){
        if(node == null) return;

        inorderTraversal(node.left);

        list.add(node.val);
        
        inorderTraversal(node.right);
    }
}