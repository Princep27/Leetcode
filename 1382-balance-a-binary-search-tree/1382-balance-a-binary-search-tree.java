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
    static void inorder(ArrayList<Integer> arr,TreeNode root){
        if(root != null){
            inorder(arr,root.left);
            arr.add(root.val);
            inorder(arr,root.right);
        }
    }

    static TreeNode build(ArrayList<Integer> arr,int l,int r){
        if(l > r) return null;
        int mid = (l+r)/2;
        TreeNode left = build(arr,l,mid-1);
        TreeNode right = build(arr,mid+1,r);
        TreeNode root = new TreeNode(arr.get(mid),left,right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(arr,root);
        return build(arr,0,arr.size()-1);
    }
}