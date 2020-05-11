package stack;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @date 2020-05-11 11:38 下午
 */
public class L84_LargestRectangleArea {

    private int solution_2(int[] heights) {
        return 0;
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
