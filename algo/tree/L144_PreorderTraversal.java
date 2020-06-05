package tree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @date 2020-06-05 11:49 下午
 */
public class L144_PreorderTraversal {

    /**
     * 压栈迭代节点
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            // 根节点
            while (root != null) {

                res.add(root.val);
                // 根节点压栈
                stack.push(root);
                // 左节点
                root = root.left;
            }

            // 栈内弹出根节点，取右节点
            root = stack.pop().right;
        }

        return res;
    }

}
