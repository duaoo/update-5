package tree;

import bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @date 2020-06-08 10:54 下午
 */
public class L429_NAryTreeLevelOrderTraversal {

    /**
     * 递归法
     */
    class solution_1 {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {

            if (root == null) {
                return new ArrayList<>();
            }

            traversalTree(root, 0);
            return res;
        }

        private void traversalTree(Node root, int resIndex) {

            // 深度
            if (res.size() <= resIndex) {
                res.add(new ArrayList<>());
            }
            res.get(resIndex).add(root.val);

            List<Node> children = root.children;
            if (children != null) {
                int nextIndex = resIndex + 1;
                for (Node node : children) {
                    traversalTree(node, nextIndex);
                }
            }
        }
    }

}
