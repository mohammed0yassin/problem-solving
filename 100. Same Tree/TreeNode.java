import java.util.*;

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

    TreeNode(Integer[] treeArray) {
        this(treeArray, "compact");
    }

    TreeNode(Integer[] treeArray, String style) {
        if (style.equals("expanded")) {
            this.val = treeArray[0];
            buildTreeFromArray(this, treeArray, 0);
        } else {
            this.val = treeArray[0];
            buildTreeFromCompactArray(this, treeArray);
        }
    }

    private void buildTreeFromCompactArray(TreeNode treeNode, Integer[] treeArray) {
        if (treeArray[0] == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int idx = 0;
        while (idx < treeArray.length) {
            TreeNode current = queue.poll();
            if (idx + 1 < treeArray.length && treeArray[idx + 1] != null) {
                current.left = new TreeNode(treeArray[idx + 1]);
                queue.add(current.left);
            }

            if (idx + 2 < treeArray.length && treeArray[idx + 2] != null) {
                current.right = new TreeNode(treeArray[idx + 2]);
                queue.add(current.right);
            }
            idx += 2;
        }
    }


    private void buildTreeFromArray(TreeNode root, Integer[] children, Integer idx) {
        if (root == null || 2 * idx + 1 >= children.length) return;
        if (children[2 * idx + 1] != null) root.right = new TreeNode(children[2 * idx + 1]);
        if (children[2 * idx + 2] != null) root.left = new TreeNode(children[2 * idx + 2]);
        buildTreeFromArray(root.right, children, 2 * idx + 1);
        buildTreeFromArray(root.left, children, 2 * idx + 2);
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

    private static List<Integer> traverseTreeToArrayWithNulls(TreeNode root, Integer idx) {
        List<Integer> tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            tree.add(current.val);
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        return tree;

    }

    public static void printAllTree(TreeNode root) {
        traverseTreeToArray(root);
        System.out.println(allTree);
        allTree.clear();
    }


    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode fiften = new TreeNode(15);
        TreeNode sixteen = new TreeNode(16);
        TreeNode twenty = new TreeNode(20);
        TreeNode twentyOne = new TreeNode(21);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode TwentySix = new TreeNode(26);
        TreeNode one = new TreeNode(1, ten, eleven);
        TreeNode three = new TreeNode(3, fiften, sixteen);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode six = new TreeNode(6, twenty, twentyOne);
        TreeNode nine = new TreeNode(9, twentyFive, TwentySix);
        TreeNode seven = new TreeNode(7, six, nine);
        TreeNode root = new TreeNode(4, two, seven);
//        printAllTree(root);
        Integer[] treeArrayCompact = {1, null, 0, null, 1, 0, 1, 1, null, null, 0, null, null, null, 1, 0};
        TreeNode treeRootCompact = new TreeNode(treeArrayCompact);
        System.out.println(traverseTreeToArrayWithNulls(treeRootCompact, 0));
    }
}