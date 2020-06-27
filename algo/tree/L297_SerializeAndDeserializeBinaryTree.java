package tree;

import bean.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @date 2020-06-27 11:43 下午
 */
public class L297_SerializeAndDeserializeBinaryTree {

    /**
     * 递归解法
     */
    public class solution_1 {

        private static final String SPLITER = ",";
        private static final String NULL_STR = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            List<String> valList = Arrays.asList(data.split(SPLITER));
            Deque<String> deque = new LinkedList<>(valList);
            return buildTree(deque);
        }

        private void buildString(TreeNode root, StringBuilder sb) {

            if (root == null) {
                sb.append(NULL_STR).append(SPLITER);
                return;
            }

            sb.append(root.val).append(SPLITER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }

        private TreeNode buildTree(Deque<String> deque) {

            String val = deque.remove();

            if (NULL_STR.equals(val)) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(deque);
            node.right = buildTree(deque);

            return node;
        }
    }
}
