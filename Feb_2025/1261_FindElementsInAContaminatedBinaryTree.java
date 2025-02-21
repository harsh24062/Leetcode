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
class FindElements {
       
    Set<Integer> set;

    public FindElements(TreeNode root) {
        set=new HashSet<>();
        root.val=0;
        recover(root);
    }

    void recover(TreeNode root){
        if(root==null)return;

        int x=root.val;
        set.add(x);
        if(root.left!=null)root.left.val=(2*x)+1;
        if(root.right!=null)root.right.val=(2*x)+2;

        recover(root.left);
        recover(root.right);
    }
    
    public boolean find(int target) {
        if(set.contains(target))return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
