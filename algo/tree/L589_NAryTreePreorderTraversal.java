package tree;

import bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @date 2020-06-07 11:49 下午
 */
public class L589_NAryTreePreorderTraversal {

    /**
     * 递归解法
     */
    class solution_1 {
        public List<Integer> preorder(Node root) {

            List<Integer> res = new ArrayList<>();
            traversalTree(root, res);
            return res;
        }

        private void traversalTree(Node root, List<Integer> res) {

            if (root == null) {
                return;
            }

            res.add(root.val);

            List<Node> nodeList = root.children;
            if (nodeList != null) {
                for (Node node : nodeList) {
                    traversalTree(node, res);
                }
            }
        }
    }

}
