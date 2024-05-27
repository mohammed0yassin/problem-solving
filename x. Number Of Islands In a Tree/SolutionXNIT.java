import java.util.LinkedList;
import java.util.Queue;

class SolutionXNIT {
    public static int numberOfIslands(TreeNode root) {
        int num = 0;
        return bfs(root, num);
    }

    private static int bfs(TreeNode node, int num) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) continue;
            queue.add(current.right);
            queue.add(current.left);
            if (current.val != 1) continue;
            if ((current.right != null && current.right.val == 0 || current.left != null && current.left.val == 0))
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Integer[] rootArr = {1, null, 0, null, 1, 0, 1, 1, null, null, 0, null, null, null, 1, 0};
        TreeNode root = new TreeNode(rootArr);
        System.out.println(numberOfIslands(root));
    }
}
