package tree;

import bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 *
 * @date 2020-06-05 11:49 下午
 */
public class L590_NAryTreePreorderTraversal {

    /**
     * 递归解法
     */
    class solution_1 {
        public List<Integer> postorder(Node root) {

            List<Integer> res = new ArrayList<>();
            traversalTree(root, res);
            return res;
        }

        private void traversalTree(Node root, List<Integer> res) {

            if (root == null) {
                return;
            }

            List<Node> nodeList = root.children;
            if (nodeList != null) {
                for (Node node : nodeList) {
                    traversalTree(node, res);
                }
            }

            res.add(root.val);
        }
    }

}
