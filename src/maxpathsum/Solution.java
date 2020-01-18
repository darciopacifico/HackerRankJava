package maxpathsum;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {

        TreeNode x9 = new TreeNode(9);
        TreeNode x6 = new TreeNode(6);
        TreeNode x_3 = new TreeNode(-3);
        TreeNode x_6_a = new TreeNode(-6);
        TreeNode x2 = new TreeNode(2);
        TreeNode x2_b = new TreeNode(2);
        TreeNode x_6_b = new TreeNode(-6);
        TreeNode x_6_c = new TreeNode(-6);
        TreeNode x_6_d = new TreeNode(-6);

        x9.left = x6;
        x9.right = x_3;

        //x_3.left = x_6_a;
        x_3.right = x2;

        x2.left = x2_b;

        x2_b.left = x_6_b;
        x2_b.right = x_6_d;



        System.out.println(new Solution().maxPathSum(x9) + " must be 16");


        TreeNode z1 = new TreeNode(1);
        TreeNode z2 = new TreeNode(2);
        TreeNode z3 = new TreeNode(3);
        TreeNode z4 = new TreeNode(4);
        TreeNode z5 = new TreeNode(5);

        z1.right = z2;
        z2.right = z3;
        z3.right = z4;
        z4.right = z5;

        System.out.println(new Solution().maxPathSum(z1) + " must be 15");

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;


        System.out.println(new Solution().maxPathSum(node1) + " must be 6");
        System.out.println(new Solution().maxPathSum(new TreeNode(-3)) + " must be -3");

        final TreeNode root = new TreeNode(2);
        final TreeNode rootMinus1 = new TreeNode(-1);
        root.left = rootMinus1;

        System.out.println(new Solution().maxPathSum(root) + " must be 2");
    }

    public int maxPathSum(TreeNode root) {
        return maxPathSum(root, MIN_VALUE);
    }

    private int maxPathSum(TreeNode root, int maxValue) {
        if (root == null) return maxValue;

        int rootValue = getValue(root, maxValue);

        int newMax = max(rootValue, maxValue);

        int l = maxPathSum(root.left, newMax);
        int r = maxPathSum(root.right, newMax);

        return max(newMax, max(l, r));
    }

    private int getValue(TreeNode root, int max) {
        if (root == null) return max;

        int l = sum(root.left, 0, MIN_VALUE);

        int r = sum(root.right, 0, MIN_VALUE);


        return root.val + l + r;

    }

    private int sum(TreeNode node, int sum, int max) {
        if (node == null) return max(0, max);

        int newSum = sum + node.val;
        int newMax = max(max, newSum);

        final int lSide = sum(node.left, newSum, newMax);
        final int rSide = sum(node.right, newSum, newMax);

        return max(rSide, lSide);

    }

}