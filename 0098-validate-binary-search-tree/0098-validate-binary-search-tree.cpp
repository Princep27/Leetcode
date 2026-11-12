/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    tuple<bool,int,int> solve(TreeNode *root){
        if(root->left == NULL && root->right == NULL) 
            return {true,root->val,root->val};

        if(root->left == NULL){
            auto [rvalid,rmini,rmaxi] = solve(root->right);
            return {rvalid & (rmini > root->val), root->val, rmaxi};
        }

        if(root->right == NULL){
            auto [lvalid,lmini,lmaxi] = solve(root->left);
            return {lvalid & (lmaxi < root->val), lmini, root->val};
        }

        auto [rvalid,rmini,rmaxi] = solve(root->right);
        auto [lvalid,lmini,lmaxi] = solve(root->left);
        return {rvalid & lvalid & (root->val < rmini && root->val > lmaxi),lmini,rmaxi};
    }

    bool isValidBST(TreeNode* root) {
        return get<0>(solve(root));
    }
};