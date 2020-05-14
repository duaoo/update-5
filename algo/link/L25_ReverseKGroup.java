package link;

import bean.ListNode;

/**
 * K个一组反转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @date 2020-05-04 2:45 下午
 */
public class L25_ReverseKGroup {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;

        System.out.println(head1.toString());
        ListNode resultNode = solution_1(head1, 2);
        System.out.println(resultNode.toString());

    }

    /**
     * 以原链表为基准，指针持续向右推进
     * 0. 为head节点创建前置虚节点
     * 1. 以head节点为基准，遍历节点
     * 2. 节点数目符合组条件时，重新遍历期间节点，做翻转链表操作
     * 3. 把翻转后的头节点，更新到当前组的前置节点的next节点
     * 4. 更新下一组前置节点（重点）
     * 5. 更新下一组头节点
     * 6. 持续遍历基准节点
     */
    public static ListNode solution_1(ListNode head, int k) {

        // 组最小单元为1时，无需移动
        if (k == 1) {
            return head;
        }

        // 虚节点
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;

        // 链表组节点的前置节点和后继节点
        ListNode startMoveNode = resultNode;
        ListNode moveNode = startMoveNode.next;

        // 链表组的头和尾节点
        ListNode startNode = moveNode;
        ListNode endNode = null;

        int NodeNo = 1;
        while (moveNode != null) {

            // 移动节点
            moveNode = moveNode.next;

            // 寻组尾节点
            if (NodeNo++ % k != 0) {
                endNode = moveNode;
                continue;
            }

            // 重新引用，防止直接破坏源引用数据
            ListNode groupPreviousNode = moveNode;
            ListNode groupStartNode = startNode;
            ListNode nextGroupStartNode = endNode.next;

            // 组内翻转
            while (groupStartNode != nextGroupStartNode) {
                // 记录next节点
                ListNode groupNextNode = groupStartNode.next;
                // 当前节点指向前置节点
                groupStartNode.next = groupPreviousNode;
                // 更新前置节点
                groupPreviousNode = groupStartNode;
                // 开始节点指针向后移动
                groupStartNode = groupNextNode;
            }

            // 更新链表排序
            startMoveNode.next = groupPreviousNode;
            // 更新下一组的前置节点
            startMoveNode = startNode;
            // 更新下一组的头节点
            startNode = nextGroupStartNode;
        }

        return resultNode.next;
    }
}
