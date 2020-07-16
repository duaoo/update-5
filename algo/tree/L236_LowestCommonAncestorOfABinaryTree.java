package tree;

import bean.TreeNode;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @date 2020-07-15 11:43 下午
 */
public class L236_LowestCommonAncestorOfABinaryTree {

    /**
     * 递归
     */
    public TreeNode solution_1(TreeNode cur, TreeNode p, TreeNode q) {

        if (cur == null || cur == p || cur == q) {
            return cur;
        }

        TreeNode left = solution_1(cur.left, p, q);
        TreeNode right = solution_1(cur.right, p, q);
        //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }

        //同上
        if (right == null) {
            return left;
        }

        //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
        //我们只需要返回cur结点即可。
        return cur;
    }

}
