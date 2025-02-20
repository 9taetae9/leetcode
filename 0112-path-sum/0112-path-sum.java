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
    boolean hasTarget;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        hasPathSum(root, targetSum, root.val);
        return hasTarget;
    }

    public void hasPathSum(TreeNode root, int targetSum, int curSum) {
        if(root.left == null && root.right == null){
            if(targetSum == curSum) {
                hasTarget = true;
                return ;
            }
            return ;
        }


        if(root.left != null && !hasTarget){
            hasPathSum(root.left, targetSum, curSum + root.left.val);
        }


        if(root.right != null && !hasTarget){
            hasPathSum(root.right, targetSum, curSum + root.right.val);
        }
        return ;
    }
}