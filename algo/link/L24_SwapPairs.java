package link;

import bean.ListNode;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class L24_SwapPairs {

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
        ListNode result = solution_3(head1);
        System.out.println(result.toString());

    }

    /**
     * 递归解法
     */
    private static ListNode solution_3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = solution_3(nextNode.next);
        nextNode.next = head;

        return nextNode;
    }

    /**
     * 与solution_1思路一致，
     * 复用head节点，更新起引用值为扩展后的节点
     * 便于理解
     */
    private static ListNode solution_2(ListNode head) {

        // 创建一个虚节点
        ListNode previousNode = new ListNode(0);
        previousNode.next = head;

        // 扩展head节点
        head = previousNode;

        // 只要存在成对的节点
        while (head.next != null && head.next.next != null) {

            // 当前链表第2和第3个节点
            ListNode secondNode = head.next;
            ListNode thirdNode = head.next.next;

            // 当前链表首节点指向第3个节点 (1 -> 3)
            head.next = thirdNode;
            // 当前链表第2个节点指向第4个节点 (2 -> 4)
            secondNode.next = thirdNode.next;
            // 当前链表第3个节点指向第2个节点 (3 -> 2)
            thirdNode.next = secondNode;

            // 将链表节点推进2个节点，即此时的第3个节点
            head = secondNode;
        }

        return previousNode.next;
    }

    /**
     * 扩展head节点，创建临时引用节点
     */
    private static ListNode solution_1(ListNode head) {

        // 虚节点
        ListNode previousNode = new ListNode(0);
        previousNode.next = head;

        // 临时节点
        ListNode tempNode = previousNode;

        while (tempNode.next != null && tempNode.next.next != null) {

            // 当前节点
            ListNode currentNode = tempNode.next;
            // 后置节点
            ListNode nextNode = tempNode.next.next;

            // 后置节点更新
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;

            // 更新temp节点的next引用node，进而更新了虚节点的next引用node
            tempNode.next = nextNode;

            // 更新temp节点的引用node
            tempNode = nextNode.next;
        }

        return previousNode.next;
    }

}