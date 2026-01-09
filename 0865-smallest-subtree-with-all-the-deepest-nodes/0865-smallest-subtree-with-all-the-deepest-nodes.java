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

class Pair{
    int level;
    TreeNode node;
    Pair(int level,TreeNode node){
        this.level = level;
        this.node = node;
    }
}

class Solution {

    static Pair solve(TreeNode root,int level){
        if(root == null) return new Pair(level,null);
        Pair left = solve(root.left,level+1);
        Pair right = solve(root.right,level+1);
        if(left.level == right.level){
            return new Pair(left.level,root);
        }else{
            return left.level > right.level ? left : right;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root,0).node;
    }
}