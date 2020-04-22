package link;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

import bean.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class L206_ReverseList {

    /**
     * 双指针迭代
     * 时间复杂度O(n)
     */
    public static ListNode solution_1(ListNode head) {

        // 前置节点
        ListNode previousNode = null;
        // 当前节点
        ListNode currentNode = head;
        // 后继节点
        ListNode nextNode = null;

        // 只要有后继节点就继续
        while (currentNode != null) {

            // 记录当前节点的后继节点
            nextNode = currentNode.next;

            // 将当前节点的后置节点指向前置节点
            currentNode.next = previousNode;

            // 更新前置节点为当前节点
            previousNode = currentNode;

            // 更新当前节点为next节点
            currentNode = nextNode;

        }

        return previousNode;
    }

}

