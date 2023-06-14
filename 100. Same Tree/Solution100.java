class Solution100 {
    public static Boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null) return true;
        if (p == null | q == null) return false;
        return (p.val == q.val) && isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }

    public static void main(String[] args) {
        //Tree1
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
        //Tree2
        TreeNode ten2        = new TreeNode(10);
        TreeNode eleven2     = new TreeNode(11);
        TreeNode fiften2     = new TreeNode(15);
        TreeNode sixteen2    = new TreeNode(16);
        TreeNode twenty2     = new TreeNode(20);
        TreeNode twentyOne2  = new TreeNode(21);
        TreeNode twentyFive2 = new TreeNode(25);
        TreeNode TwentySix2  = new TreeNode(26);
        TreeNode one2        = new TreeNode(1, ten2, eleven2);
        TreeNode three2      = new TreeNode(3, fiften2, sixteen2);
        TreeNode two2        = new TreeNode(2, one2, three2);
        TreeNode six2        = new TreeNode(6, twenty2, twentyOne2);
        TreeNode nine2       = new TreeNode(9, twentyFive2, TwentySix2);
        TreeNode seven2      = new TreeNode(7, six2, nine2);
        TreeNode root2       = new TreeNode(4, two2, seven2);
        System.out.println(isSameTree(root, root2));
    }
}