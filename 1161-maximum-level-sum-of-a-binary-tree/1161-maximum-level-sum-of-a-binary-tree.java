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
    public int maxLevelSum(TreeNode root) {
        long ans = 0,level = 1,maxi = Integer.MIN_VALUE;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while(!q.isEmpty()){
            int n = q.size();
            long sum = 0;
            for(int i=0;i<n;++i){
                TreeNode node = q.getFirst();
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
                sum += (long)node.val;
                q.removeFirst();
            }
            if(sum > maxi){
                maxi = sum; ans = level;
            }
            ++level;
        }

        return (int)ans;
    }
}