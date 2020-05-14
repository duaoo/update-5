package link;

import bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * @date 2020-05-03 6:16 下午
 */
public class L142_DetectCycle {

    /**
     * 快慢指针
     */
    public ListNode solution_2(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode startNode = head;
        while (fastNode != null && fastNode.next != null) {

            // 快慢指针
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            // 寻找相遇点
            if (slowNode.equals(fastNode)) {

                // 起始点和相遇点同时移动，直至再次相遇，及环形入口节点
                ListNode meetNode = slowNode;
                while (meetNode != startNode) {

                    startNode = startNode.next;
                    meetNode = meetNode.next;
                }

                return meetNode;
            }
        }

        return null;
    }

    /**
     * 利用hash，遍历暴力求解
     */
    public ListNode solution_1(ListNode head) {

        // 存储已遍历过的节点
        Set<ListNode> existNodeList = new HashSet<>();
        while (head != null) {

            // 记录备用
            existNodeList.add(head);

            // 超前一个节点检查
            if (existNodeList.contains(head.next)) {
                return head.next;
            }

            head = head.next;
        }

        return null;
    }
}
