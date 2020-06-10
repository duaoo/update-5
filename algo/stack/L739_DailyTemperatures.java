package stack;

import java.util.Stack;

/**
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @date 2020-06-09 11:38 下午
 */
public class L739_DailyTemperatures {

    /**
     * 逆向迭代，降序压栈
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int[] solution_2(int[] T) {

        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = T.length - 1; i >= 0; i--) {

            while (stack.peek() != -1 && T[i] >= T[stack.peek()]) {
                stack.pop();
            }

            int topIndex = stack.peek();
            res[i] = topIndex == -1 ? 0 : topIndex - i;

            stack.push(i);
        }

        return res;
    }

    /**
     * 正向迭代，升序压栈
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int[] solution_1(int[] T) {

        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < T.length; i++) {

            while (stack.peek() != -1 && T[i] > T[stack.peek()]) {

                int topIndex = stack.pop();
                res[topIndex] = i - topIndex;
            }

            stack.push(i);
        }

        return res;
    }

}
