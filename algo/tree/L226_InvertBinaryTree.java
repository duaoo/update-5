package tree;

import bean.TreeNode;

/**
 * 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @date 2020-06-15 11:01 下午
 */
public class L226_InvertBinaryTree {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     */
    class solution_1 {
        public TreeNode invertTree(TreeNode root) {

            traversalTree(root);
            return root;
        }

        /**
         * 递归遍历树
         */
        private void traversalTree(TreeNode root) {

            // 退出条件
            if (root == null) {
                return;
            }

            // 节点交换
            swapNode(root);

            // 递归参数
            traversalTree(root.left);
            traversalTree(root.right);

        }

        /**
         * 节点交换
         */
        private void swapNode(TreeNode root) {
            if (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }
    }

}
