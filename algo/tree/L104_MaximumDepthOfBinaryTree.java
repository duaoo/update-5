package tree;

import bean.TreeNode;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @date 2020-06-22 11:49 下午
 */
public class L104_MaximumDepthOfBinaryTree {


    /**
     * 左右节点递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int solution_1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = solution_1(root.left);
        int rightDepth = solution_1(root.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }

}
