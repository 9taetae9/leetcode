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
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;
        
        getMinimumDifference(root.left); // 젤 왼쪽까지 파고들기
        
        //차이 구하기
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        
        prev = root;
        
        getMinimumDifference(root.right); // 오른쪽 체크
        
        return min;
    }
}