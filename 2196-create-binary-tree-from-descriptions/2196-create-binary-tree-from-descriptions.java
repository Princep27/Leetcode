class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer, TreeNode> mp = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {

            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            TreeNode par = mp.getOrDefault(parent, new TreeNode(parent));
            TreeNode ch = mp.getOrDefault(child, new TreeNode(child));

            mp.put(parent, par);
            mp.put(child, ch);

            if (isLeft == 1)
                par.left = ch;
            else
                par.right = ch;

            children.add(child);
        }

        for (int[] d : descriptions) {
            int parent = d[0];

            if (!children.contains(parent)) {
                return mp.get(parent);
            }
        }

        return null;
    }
}