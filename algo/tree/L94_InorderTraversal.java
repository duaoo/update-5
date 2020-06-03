package tree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 *
 * @date 2020-06-03 11:49 下午
 */
public class L94_InorderTraversal {


    /**
     * 递归遍历
     */
    public List<Integer> solution_1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        traversalTree(root, res);

        return res;
    }

    /**
     * 递归中序遍历
     *
     * @param root 根节点
     * @param list 收集节点value的list
     */
    private void traversalTree(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        // 左子节点
        if (root.left != null) {
            traversalTree(root.left, list);
        }

        // 根节点
        list.add(root.val);

        // 右子节点
        if (root.right != null) {
            traversalTree(root.right, list);
        }
    }

}
