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

    static long ans;

    public static long  findSum(TreeNode node){
        if(node == null) return 0;
        return node.val + findSum(node.left) + findSum(node.right);
    }

    public static long findMaxProd(long total,TreeNode node,int level){
        if(node == null) return 0;
        long curSum = node.val + findMaxProd(total,node.right,level+1) + findMaxProd(total,node.left,level+1);
        if(level != 0){
            ans = Math.max(ans, (total - curSum)*curSum);
            System.out.println((total - curSum)*curSum);
        }
        return curSum;
    }

    public int maxProduct(TreeNode root) {
        long total = 0;
        ans = Long.MIN_VALUE;
        total = findSum(root);
        findMaxProd(total,root,0);
        System.out.println(total);
        return (int)(ans%1000000007);
    }
}