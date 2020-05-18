package stack;

import java.util.Stack;

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

        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {

            int nowHeight = height[i];

            // 如果当前高度大于栈顶元素高度，则进行出栈面积计算
            while (!stack.isEmpty() && height[stack.peek()] < nowHeight) {

                // 栈顶元素出栈
                int headIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                // 新栈顶元素
                int newHeadIndex = stack.peek();

                res += (Math.min(nowHeight, height[newHeadIndex]) - height[headIndex]) * (i - newHeadIndex - 1);
            }
            stack.push(i);
        }

        return res;
    }

}
