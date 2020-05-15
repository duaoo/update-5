package queue;


/**
 * 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 *
 * @date 2020-05-14 23:16 下午
 */
public class L641_MyCircularDeque {

    /**
     * 双指针数组
     */
    class solution_1 {
        private int front;//指向队列第一个元素的前一个位置
        private int rear;
        private int count;
        private int[] queue;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public solution_1(int k) {
            queue = new int[k + 1];
            front = queue.length - 1;
            rear = 0;
            count = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            queue[front] = value;
            front = (front - 1 + queue.length) % queue.length;
            this.count++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            queue[rear] = value;
            ;
            rear = (rear + 1) % queue.length;
            count++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % queue.length;
            count--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + queue.length) % queue.length;
            count--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) return -1;
            return queue[(front + 1) % queue.length];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) return -1;
            return queue[(rear - 1 + queue.length) % queue.length];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return this.count == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return this.count == this.queue.length - 1;
        }
    }

}
