package company.gg;

import common.types.TreeNode;

public class BinaryTreeLongestConsecutiveSequence_298 {

    static int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = helper(root.left);
        if (root.left == null || root.val + 1 != root.left.val) {
            leftMax = 0;
        }

        int rightMax = helper(root.right);
        if (root.right == null || root.val + 1 != root.right.val) {
            rightMax = 0;
        }

        int localMax = Math.max(leftMax, rightMax) + 1;
        max = localMax > max ? localMax : max;

        return localMax;
    }
}
