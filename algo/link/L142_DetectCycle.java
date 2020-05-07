package link;

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 说明：不允许修改给定的链表。
//
//
//
// 示例 1：
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//
//
// 示例 2：
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//
//
// 示例 3：
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
//
//
//
//
//
//
// 进阶：
//你是否可以不用额外空间解决此题？
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

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
