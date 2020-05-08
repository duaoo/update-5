package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @date 2020-05-08 11:38 下午
 */
public class L155_MinStack {

    /**
     * 双端队列实现
     */
    class solution_2 {

        // 双端队列
        Deque<Integer> deque;

        public solution_2() {
            deque = new LinkedList<>();
        }

        public void push(int x) {

            // 首个元素，队首尾都存一次
            if (deque.isEmpty()) {
                deque.addFirst(x);
                deque.addLast(x);
                return;
            }

            // 存入队首
            deque.addFirst(x);

            // 获取队尾元素，如果当前元素小于等于队尾元素，则当前元素存入队尾
            int lastNum = deque.getLast();
            if (x <= lastNum) {
                deque.addLast(x);
            }
        }

        public void pop() {

            // 执行删除操作
            int firstNum = deque.removeFirst();

            // 如果队首队尾元素相同，队尾的元素也删除
            int lastNum = deque.getLast();
            if (firstNum == lastNum) {
                deque.removeLast();
            }
        }

        public int top() {
            return deque.getFirst();
        }

        public int getMin() {
            return deque.getLast();
        }
    }

    /**
     * 双栈操作
     */
    class solution_1 {

        // 常规栈和存放最小值的栈
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public solution_1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {

            // 压栈
            stack.push(x);

            // 如果最小值栈为空的话，那么当前元素即为最小元素
            if (minStack.isEmpty()) {
                minStack.push(x);
                return;
            }

            // 最小值栈不为空，先与栈顶值判断，如果比栈顶值大的会不进行操作，反之则进行压栈
            int minNum = minStack.peek();
            if (x <= minNum) {
                minStack.push(x);
            }
        }

        public void pop() {

            // 执行删除操作
            int popNum = stack.pop();

            // 如果当前删除的元素正好是最小值栈的栈顶元素，那么最小值栈也执行删除操作
            int minPopNum = minStack.peek();
            if (popNum == minPopNum) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
