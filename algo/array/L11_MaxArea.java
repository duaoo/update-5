package array;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class L11_MaxArea {

    /**
     * 双指针向内推进，不走重复路
     * 时间复杂度O(n)
     */
    public int solution_2(int[] height) {

        int maxArea = 0;

        int length = height.length;
        int l = 0;
        int r = length - 1;
        while (l < r) {

            // 容积的大小由最短的高度决定上限
            int minHeight = Math.min(height[l], height[r]);
            int width = r - l;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // 左右指针向内推进，夹击
            if (height[l] < height[r]) {

                // 如果当前左指针的高度小于右指针的高度，说明当前容积瓶颈在左指针的高度，
                // 在宽度间距缩短的同时，此时只有应试图左指针向右推进，寻找更大高度
                l++;
            } else {

                // 如果当前左指针的高度大于等于右指针的高度，说明当前容积瓶颈在右指针的高度，
                // 在宽度间距缩短的同时，此时只有应试图右指针向左推进，寻找更大高度
                r--;
            }
        }

        return maxArea;
    }

    /**
     * 暴力解法
     * 遍历，双指针移动，有重复动作
     * 时间复杂度O(n²)
     */
    public static int solution_1(int[] height) {

        int maxArea = 0;

        int length = height.length;
        for (int i = 0; i < length - 1; i++) {

            int j = i + 1;
            while (j < length) {

                // 最短的高度决定容器的上限
                int minHeigth = Math.min(height[i], height[j]);
                int width = j - i;
                int area = minHeigth * width;
                if (area > maxArea) {
                    maxArea = area;
                }

                // 移动指针
                j++;
            }
        }

        return maxArea;
    }

}
