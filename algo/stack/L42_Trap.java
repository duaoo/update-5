package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @date 2020-05-16 11:49 下午
 */
public class L42_Trap {

    /**
     * 下行压栈
     */
    public int solution_1(int[] height) {

        if (height == null || height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int tmp = stack.pop();
                if (stack.isEmpty()) break;
                res += (Math.min(height[i], height[stack.peek()]) - height[tmp]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

}
