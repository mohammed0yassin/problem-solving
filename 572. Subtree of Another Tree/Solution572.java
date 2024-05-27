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
class Solution572 {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (containsSubtreeDFS(root, subRoot)) return true;
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

     /*public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         List<TreeNode> matchingSubRoots = getSubRootFromTree(root, subRoot);
         boolean result = false;
         for (TreeNode matchedRoot : matchingSubRoots) {
             result = result || containsSubtreeDFS(matchedRoot, subRoot);
         }
         return result;
     }

        private List<TreeNode> getSubRootFromTree(TreeNode root, TreeNode subRoot) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<TreeNode> matchingSubRoots = new ArrayList();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current.val == subRoot.val) matchingSubRoots.add(current);
                if (current.right != null) queue.add(current.right);
                if (current.left != null) queue.add(current.left);
            }
            return matchingSubRoots;
        }*/

    private static boolean containsSubtreeDFS(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return containsSubtreeDFS(root.right, subRoot.right) && containsSubtreeDFS(root.left, subRoot.left);
    }

    public static void main(String[] args) {
        Integer[] rootArr = {3,4,5,1,2};
        Integer[] subRootArr = {4,1,2};
        TreeNode root = new TreeNode(rootArr);
        TreeNode subRoot = new TreeNode(subRootArr);
        System.out.println(isSubtree(root, subRoot));

    }
}