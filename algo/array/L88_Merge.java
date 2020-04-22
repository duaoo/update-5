package array;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

import java.util.Arrays;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @date 2020-05-05 2:53 下午
 */
public class L88_Merge {

    /**
     * 双指针逐个比较，从尾部最大数开始处理
     *
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     */
    public void solution_3(int[] nums1, int m, int[] nums2, int n) {

        // 三指针
        int nums1EndIndex = m + n - 1;
        int mEndIndex = m - 1;
        int nEndIndex = n - 1;

        // 两数组元素逐个比较，寻找最大值
        while (mEndIndex >= 0 && nEndIndex >= 0) {

            // 最大值数组尾指针移动-1，结果集nums1尾指针也移动-1
            if (nums1[mEndIndex] >= nums2[nEndIndex]) {
                nums1[nums1EndIndex--] = nums1[mEndIndex--];
            } else {
                nums1[nums1EndIndex--] = nums2[nEndIndex--];
            }
        }

        // 由于是有序数组，把未处理完的较小数，复制到nums1前端
        if (nEndIndex >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, nEndIndex + 1);
        }
    }

    /**
     * 借额外空间，双指针逐个比较
     *
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m)
     */
    public void solution_2(int[] nums1, int m, int[] nums2, int n) {

        // 复制一个num1数组备用
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        // 三指针
        int n1Index = 0;
        int n1CopyIndex = 0;
        int n2Index = 0;

        // 两数组元素逐个比较，寻找最小值
        while (n1CopyIndex < m && n2Index < n) {

            // 最小值数组指针移动+1，结果集nums1指针也移动+1
            if (nums1Copy[n1CopyIndex] <= nums2[n2Index]) {
                nums1[n1Index++] = nums1Copy[n1CopyIndex++];
            } else {
                nums1[n1Index++] = nums2[n2Index++];
            }
        }

        // 由于是有序数组，数组剩余值拼接到nums1后
        if (n1CopyIndex < m) {
            System.arraycopy(nums1Copy, n1CopyIndex, nums1, n1Index, m - n1CopyIndex);
        } else if (n2Index < n) {
            System.arraycopy(nums2, n2Index, nums1, n1Index, n - n2Index);
        }
    }

    /**
     * 暴力求解
     * 拼接+排序
     */
    public void solution_1(int[] nums1, int m, int[] nums2, int n) {

        // 拼接
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // 排序
        Arrays.sort(nums1);
    }
}
