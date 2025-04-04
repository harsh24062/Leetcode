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

    private TreeNode ans;
    private int maxDepth;

    int func(TreeNode root,int level){
      if(root==null){ return 0;}

      int left=func(root.left,level+1);
      int right=func(root.right,level+1);
      
      if(left==right){
        int max=Math.max(left,level);
        if(max>=maxDepth){
            maxDepth=max;
            ans=root;
        }
      }
       
       return Math.max(level,Math.max(left,right));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
         ans=root;
        maxDepth=0;
        func(root,0);
        return ans;
    }
}
