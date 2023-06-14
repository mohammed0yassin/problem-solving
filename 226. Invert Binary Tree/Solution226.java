import java.util.ArrayList;

class Solution226 {
    private static ArrayList<Integer> invertedTree = new ArrayList<>();
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertedTree.add(root.val);
        TreeNode tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode ten        = new TreeNode(10);
        TreeNode eleven     = new TreeNode(11);
        TreeNode fiften     = new TreeNode(15);
        TreeNode sixteen    = new TreeNode(16);
        TreeNode twenty     = new TreeNode(20);
        TreeNode twentyOne  = new TreeNode(21);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode TwentySix  = new TreeNode(26);
        TreeNode one        = new TreeNode(1, ten, eleven);
        TreeNode three      = new TreeNode(3, fiften, sixteen);
        TreeNode two        = new TreeNode(2, one, three);
        TreeNode six        = new TreeNode(6, twenty, twentyOne);
        TreeNode nine       = new TreeNode(9, twentyFive, TwentySix);
        TreeNode seven      = new TreeNode(7, six, nine);
        TreeNode root       = new TreeNode(4, two, seven);
        TreeNode.printAllTree(root);
        TreeNode.printAllTree(invertTree(root));
    }
}