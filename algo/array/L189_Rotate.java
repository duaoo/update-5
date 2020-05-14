package array;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @date 2020-05-04 10:34 下午
 */
public class L189_Rotate {

    /**
     * 三次反转链表
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public void solution_2(int[] nums, int k) {

        // 旋转次数取模，避免做无谓的移动
        int length = nums.length;
        k = k % length;
        // 如果取模为0，则不用移动
        if (k == 0) {
            return;
        }

        // 整体反转
        reverseArray(nums, 0, length - 1);
        // 反转前k个元素
        reverseArray(nums, 0, k - 1);
        // 反转剩余length-k个元素
        reverseArray(nums, k, length - 1);
    }

    /**
     * 翻转数组
     *
     * @param nums       数组
     * @param beignIndex 起点下标
     * @param endIndex   尾点下标
     */
    private void reverseArray(int[] nums, int beignIndex, int endIndex) {

        // 二分首尾交换
        while (beignIndex < endIndex) {

            int tempNum = nums[beignIndex];
            nums[beignIndex] = nums[endIndex];
            nums[endIndex] = tempNum;

            beignIndex++;
            endIndex--;
        }
    }

    /**
     * 暴力求解
     * 时间复杂度O(n*k)
     * 空间复杂度O(1)
     */
    public void solution_1(int[] nums, int k) {

        // 旋转次数取模，避免做无谓的移动
        int length = nums.length;
        k = k % length;
        // 如果取模为0，则不用移动
        if (k == 0) {
            return;
        }

        // 遍历旋转次数
        for (int i = 0; i < k; i++) {

            // 每次从头尾交换开始，进行一次全员移动
            int previousNum = nums[length - 1];
            for (int j = 0; j < length; j++) {

                int tempNum = nums[j];
                nums[j] = previousNum;
                previousNum = tempNum;
            }
        }
    }
}
