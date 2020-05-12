package stack;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @date 2020-05-11 11:38 下午
 */
public class L84_LargestRectangleArea {

    /**
     * 利用栈
     * 上升梯度到达顶点时，回头计算站内上升形态元素的面积
     */
    private int solution_2(int[] heights) {

        // 创建栈并压如辅助元素-1
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {

            // 站内元素高度呈上升形态，如遇到下降，则开始出栈进行面积计算
            // 当栈顶元素为-1，或者当前栈顶元素小于当前元素时，回头计算栈中的柱子面积
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {

                // 栈顶柱子高度 * 栈顶柱子与当前柱子的间距（当前元素指针下标 - 栈顶元素指针下标 - 1）
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        // 剩余未出栈的元素计算面积
        while (stack.peek() != -1) {

            // 当前柱子高度 * 最后一根柱子与栈顶柱子的间距（柱子数量 - 当前柱子下标 - 1）
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }

        return maxArea;
    }

    /**
     * 双指针暴力求解
     */
    private int solution_1(int[] heights) {

        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {

            // 从单柱开始，与int最大值比较
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {

                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }

        return maxArea;
    }

}
