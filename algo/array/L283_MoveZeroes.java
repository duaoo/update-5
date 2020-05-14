package array;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class L283_MoveZeroes {

    /**
     * 双指针同向移动，循环一遍
     * 时间复杂度 O(n)
     */
    public static void soution_2(int[] nums) {

        int zeroIndex = 0;
        for (int i = 1; i < nums.length; i++) {

            // 寻0指针，找到值为0的index
            if (nums[zeroIndex] == 0) {

                // 寻非0指针，找到非0的index
                if (nums[i] != 0) {

                    // 非0值与0值交换
                    int temp = nums[zeroIndex];
                    nums[zeroIndex] = nums[i];
                    nums[i] = temp;

                    // 寻0指针向右移动
                    zeroIndex++;
                }

            } else {

                // 当前值非0，寻0指针向右移动
                zeroIndex++;
            }
        }
    }

    /**
     * 暴力求解
     * 时间复杂度O(n²)
     */
    public static void soution_1(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length; i++) {

            if (nums[i] != 0) {
                continue;
            }

            int j = i + 1;
            while (j < length && nums[j] == 0) {
                j++;
            }

            if (j < length) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}