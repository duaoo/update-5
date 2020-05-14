package link;

import bean.ListNode;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @date 2020-05-02 11:54 下午
 */
public class L141_HasCycle {

    /**
     * 快慢指针
     */
    public static boolean solution_1(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (fastNode != null && fastNode.next != null) {

            if (slowNode.val == fastNode.val) {
                return true;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return false;
    }

}
