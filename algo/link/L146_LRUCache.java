package link;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 *
 * @date 2021-02-02 11:14
 */
public class L146_LRUCache {


    private final static int NONE_VAL = -1;

    private final int capacity;
    private int size;
    private Map<Integer, DLinkNode> cacheMap = new HashMap<>();
    private DLinkNode head, tail;

    public L146_LRUCache(int capacity) {

        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {

        if (cacheMap.containsKey(key)) {

            DLinkNode node = cacheMap.get(key);
            // 移动到头部
            this.moveToHead(node);

            return node.val;
        }

        return NONE_VAL;
    }

    public void put(int key, int value) {

        // 存在，则移动
        if (cacheMap.containsKey(key)) {

            DLinkNode node = cacheMap.get(key);
            // 更新值
            node.val = value;
            // 移动到头部
            this.moveToHead(node);

            return;
        }

        // 不存在，新增
        DLinkNode node = new DLinkNode(key, value);
        // 添加到头部
        this.addToHead(node);
        // 新增到hash表
        cacheMap.put(key, node);
        // 更新长度
        size++;
        // 超出容量，删除尾部数据
        if (size > capacity) {

            DLinkNode delNode = this.delTailNode();
            // 从hash表里也删除
            cacheMap.remove(delNode.key);
            // 长度缩减
            size--;
        }

    }

    /**
     * 删除尾部节点
     */
    private DLinkNode delTailNode() {

        DLinkNode node = this.tail.prev;
        this.delNode(node);

        return node;
    }

    /**
     * 在头部新增节点
     */
    private void addToHead(DLinkNode node) {

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    /**
     * 将节点移动到头部
     */
    private void moveToHead(DLinkNode node) {

        // 删除原节点
        this.delNode(node);
        // 节点新增到头部
        this.addToHead(node);
    }

    /**
     * 删除节点
     */
    private void delNode(DLinkNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 双向链接节点
    static class DLinkNode {

        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
