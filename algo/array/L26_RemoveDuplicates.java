package array;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @date 2020-05-04 9:37 下午
 */
public class L26_RemoveDuplicates {

    /**
     * 双指针移动
     */
    public int solution_1(int[] nums) {

        // 小于2个元素时直接返回长度即可
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        // 基准指针
        int l = 0;
        // 搜寻指针
        int r = 1;
        while (r < length) {

            // 当基准指针值与搜寻指针值相同时
            if (nums[l] != nums[r]) {

                // 把搜寻指针值复制到基准指的下一个位置
                nums[l + 1] = nums[r];

                // 移动基准指针
                l++;
            }

            // 移动搜寻指针
            r++;
        }

        return l + 1;
    }
}
