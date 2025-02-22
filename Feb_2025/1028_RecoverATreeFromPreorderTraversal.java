// my approach

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
    public TreeNode recoverFromPreorder(String traversal) {
        int n=traversal.length();
        Map<Integer,Queue<TreeNode>> map=new HashMap<>();
        
        int index=0;
        StringBuilder sb=new StringBuilder();
        while(index<n && traversal.charAt(index)!='-'){
            sb.append(traversal.charAt(index));
            index++;
        }

        TreeNode root=new TreeNode(Integer.parseInt(sb.toString()));

        map.put(1,new LinkedList<>());
        map.get(1).offer(root);

        while(index<n){

            //find --
            int count=0;
            while(traversal.charAt(index)=='-'){
               count++;
               index++;
            }

            // find integer val
            StringBuilder ss=new StringBuilder();
            while(index<n && traversal.charAt(index)!='-'){
            ss.append(traversal.charAt(index));
            index++;
           }

            TreeNode node=new TreeNode(Integer.parseInt(ss.toString()));

            //remove key >count
            final int d=count;
           map.entrySet().removeIf(entry -> entry.getKey() > d);

            //put in map
            if(!map.containsKey(count+1)) map.put(count+1,new LinkedList<>());
            map.get(count+1).offer(node);

            //add in tree
            if(map.get(count).peek().left==null)map.get(count).peek().left=node;
            else if(map.get(count).peek().right==null){
                map.get(count).peek().right=node;
                map.get(count).poll();
            }

        }

        return root;
    }
}


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
    int n=0;
    int index=0;

    TreeNode recur(String s, int depth){
        if(index>=n)return null;

        // count '-'
        int count=0;
        int t=index;
        while(t<n && s.charAt(t)=='-'){
            t++;
            count++;
        }
        if(count!=depth)return null;
        index=t;

        // find number
        StringBuilder sb=new StringBuilder();
        while(index<n && s.charAt(index)!='-'){
            sb.append(s.charAt(index));
            index++;
        }
       
        TreeNode node=new TreeNode(Integer.parseInt(sb.toString()));

        node.left=recur(s,depth+1);
        node.right=recur(s,depth+1);
        return node;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        return recur(traversal,0);
    }
}
