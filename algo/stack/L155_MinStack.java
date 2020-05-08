package stack;

import java.util.Stack;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @date 2020-05-08 11:38 下午
 */
public class L155_MinStack {

    class solution_1 {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public solution_1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {

            stack.push(x);

            // 与最小值栈栈顶元素比较，最小值压栈
            if (minStack.isEmpty()) {
                stack.push(x);
            } else {
                Integer minNum = minStack.peek();
                if (minNum >= x) {
                    stack.push(x);
                }
            }
        }

        public void pop() {

            if (!stack.isEmpty()) {
                Integer popNum = stack.pop();

                if (!minStack.isEmpty()) {
                    // 如果出栈的是最小值，则最小值栈也要pop
                    Integer minNum = minStack.peek();
                    if (popNum.equals(minNum)) {
                        minStack.pop();
                    }
                }

            }

        }

        public int top() {
            if (stack.isEmpty()) {
                return 0;
            }
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
