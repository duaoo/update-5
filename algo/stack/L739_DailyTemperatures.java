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
     * 正向迭代，升序压栈
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
