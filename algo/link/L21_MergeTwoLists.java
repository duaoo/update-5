package link;

import bean.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @date 2020-05-05 1:17 下午
 */
public class L21_MergeTwoLists {

    /**
     * 递归解法
     */
    public ListNode solution_2(ListNode l1, ListNode l2) {

        // 由于是有序链表，剩余链表及链表尾部
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // 选举最小值链表节点，利用递归持续压栈
        if (l1.val <= l2.val) {

            l1.next = solution_2(l1.next, l2);
            return l1;

        } else {

            l2.next = solution_2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 双链表节点值大小比较
     */
    public ListNode solution_1(ListNode l1, ListNode l2) {

        // 创建哑结点
        ListNode previousNode = new ListNode(-1);

        // 双链表节点以step1的频率移动
        ListNode tempNode = previousNode;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                // 当前l1的节点值小于等于l2时，头部节点的next指向l1，l1节点移动
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                // 反之，头部节点的next指向l2，l2节点移动
                tempNode.next = l2;
                l2 = l2.next;
            }

            tempNode = tempNode.next;
        }

        // 链表l1或者l2不是等差量的时候，会存在未比较完的节点
        tempNode.next = l1 == null ? l2 : l1;

        return previousNode.next;
    }
}
