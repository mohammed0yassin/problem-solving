import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static ArrayList<Integer> allTree = new ArrayList<>();

    private static void traverseTreeToArray(TreeNode root) {
        TreeNode current = root;
        allTree.add(current.val);
        if (current.left != null) {
            traverseTreeToArray(current.left);
        }
        if (current.right != null) {
            traverseTreeToArray(current.right);
        }
    }

    public static void printAllTree(TreeNode root) {
        traverseTreeToArray(root);
        System.out.println(allTree);
        allTree.clear();
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
        printAllTree(root);
    }
}