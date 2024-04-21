class Solution450 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if ( key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else if ( key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            else {
                TreeNode minRightNode = getMinimumVal(root.right);
                root.val = minRightNode.val;
                root.right = deleteNode(root.right, minRightNode.val);
            }
        }
        return root;
    }

    private static TreeNode getMinimumVal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        TreeNode seven      = new TreeNode(7);
        TreeNode two        = new TreeNode(2);
        TreeNode four        = new TreeNode(4);
        TreeNode six        = new TreeNode(6, null, seven);
        TreeNode three      = new TreeNode(3, two, four);
        TreeNode root       = new TreeNode(5, three, six);

        System.out.println(deleteNode(root, 3));
        TreeNode.printAllTree(root);
    }
}