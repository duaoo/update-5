package tree;

import bean.TreeNode;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @date 2020-06-23 11:49 下午
 */
public class L111_MinimumDepthOfBinaryTree {

    /**
     * 递归
     * 时间复杂度：O(n)
     */
    public int solution_1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = solution_1(root.left);
        int rightDepth = solution_1(root.right);

        // 当左右自节点其中一个为null时，返回不为null节点的深度
        if (root.left == null || root.right == null) {
            return Math.max(leftDepth, rightDepth) + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

}
