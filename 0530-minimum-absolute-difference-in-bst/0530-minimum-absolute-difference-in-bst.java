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
    int min = 100001;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraverse(root);
        for(int i=0; i<list.size()-1; i++){
            min = Math.min(min, list.get(i+1)-list.get(i));
        }

        return min;
    }

    private void inOrderTraverse(TreeNode node){
        if(node == null) return ;

        inOrderTraverse(node.left);
        list.add(node.val);
        inOrderTraverse(node.right);
    }
}