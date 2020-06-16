package tree;

import bean.TreeNode;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @date 2020-06-16 11:49 下午
 */
public class L98_ValidateBinarySearchTree {

    private long pre = Long.MIN_VALUE;

    /**
     * 中序递归遍历
     * 时间复杂度：O(n)
     */
    public boolean solution_1(TreeNode root) {

        if (root == null) {
            return true;
        }

        // 左节点递归
        if (!solution_1(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        // 右节点递归
        return solution_1(root.right);
    }

}
