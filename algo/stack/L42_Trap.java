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
     * 压栈分层计算
     */
    public int solution_1(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {

            // 当前柱子高度
            int nowHeight = height[i];

            // 如果当前高度大于栈顶元素高度，则进行出栈面积计算
            while (!stack.isEmpty() && height[stack.peek()] < nowHeight) {

                // 栈顶柱子出栈，获得下标
                int headIndex = stack.pop();
                // 栈顶柱子高度
                int headHeight = height[headIndex];
                if (stack.isEmpty()) {
                    break;
                }

                // 新栈顶柱子下标
                int newHeadIndex = stack.peek();
                // 新栈顶柱子高度
                int newHeadHeight = height[newHeadIndex];

                // 计算当前积水层高度
                int width = Math.min(nowHeight, newHeadHeight) - headHeight;
                // 计算当前积水层长度
                int length = i - newHeadIndex - 1;

                res += width * length;
            }
            stack.push(i);
        }

        return res;
    }

}
