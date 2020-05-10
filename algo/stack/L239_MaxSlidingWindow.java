package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @date 2020-05-09 11:38 下午
 */
public interface L239_MaxSlidingWindow {

    class solution_1 {

        Deque<Integer> windowDeque = new LinkedList<>();
        Deque<Integer> maxNumDeque = new LinkedList<>();

        public int[] maxSlidingWindow(int[] nums, int k) {

            // 预装第一个window的值，并计算出当前window最大值
            for (int i = 0; i < k; i++) {
                push(nums[i]);
            }

            int length = nums.length;

            // 创建最大值数组，并存入第一个窗口的最大值
            int[] maxNums = new int[length - k + 1];
            maxNums[0] = getMaxNum();

            // 移动窗口
            for (int i = k; i < length; i++) {

                // 把上一个窗口的第一个元素删除，为下一个窗口新元素做准备
                pop();
                // 把当前元素插入当前窗口队列，并比较是否为最大值
                push(nums[i]);
                // 保存当前窗口最大值
                maxNums[i - k + 1] = getMaxNum();
            }

            return maxNums;
        }

        /**
         * 删除当前窗口队首元素
         * 1. 如果队首元素是窗口最大值，那么也要从最大值队列中删除
         */
        private void pop() {

            // 删除当前窗口队首元素
            int num = windowDeque.removeFirst();

            // 如果当前窗口队首元素与最大值队列的队首元素相同，则删除最大值队首元素
            if (!maxNumDeque.isEmpty()) {

                int maxNum = maxNumDeque.peekFirst();
                if (maxNum == num) {
                    maxNumDeque.removeFirst();
                }
            }
        }

        /**
         * 获取当前窗口最大值
         */
        private int getMaxNum() {

            // 最大值队列查看队首元素
            return maxNumDeque.peekFirst();
        }

        /**
         * 当前窗口值入队并计算最大值
         * 1. 把当前元素插入当前window的队尾
         * 2. 把当元素与最大值队列的队尾元素比较，并删除在遇到比他大的元素之前所有元素
         * 3. 把当前元素插入最大值队尾
         */
        private void push(int num) {

            // 插入当前窗口队尾
            windowDeque.addLast(num);

            // 最大值队列，当前值比队尾元素大时，删除队尾所有比当前值小的元素
            while (!maxNumDeque.isEmpty() && num > maxNumDeque.getLast()) {
                maxNumDeque.removeLast();
            }

            maxNumDeque.addLast(num);
        }

    }
}
