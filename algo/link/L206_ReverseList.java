package link;

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
    public ListNode solution_1(ListNode head) {

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

