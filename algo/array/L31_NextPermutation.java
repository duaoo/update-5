package array;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @date 2020-05-24 4:41 下午
 */
public class L31_NextPermutation {

    /**
     * 从右向左搜索第一个增长序列
     */
    class solution_1 {

        public void nextPermutation(int[] nums) {

            // 数组长度小于2时，不需要做处理
            int length = nums.length;
            if (length < 2) {
                return;
            }

            // 寻找第一个增长序列（从右向左）
            int firstUpIndex = length - 2;
            while (firstUpIndex >= 0 && nums[firstUpIndex] >= nums[firstUpIndex + 1]) {
                firstUpIndex--;
            }

            // 如果个数组都处于desc序列状态，则当前数组处于最大序列状态
            if (firstUpIndex < 0) {

                // 整个数组反转即可
                reverse(nums, ++firstUpIndex, --length);

                return;
            }

            // 寻找增长序列数组中，第一个比firstUpIndex元素大的元素（由于当前数组片段处于desc序列装填，从右向左寻找即可）
            int firstMoreThanUpIndex = length - 1;
            while (firstMoreThanUpIndex >= 0 && nums[firstMoreThanUpIndex] <= nums[firstUpIndex]) {
                firstMoreThanUpIndex--;
            }

            // 将firstMoreThanUpIndex的元素与firstUpIndex的元素交换位置
            swap(nums, firstUpIndex, firstMoreThanUpIndex);

            // 最后将除了firstUpIndex后的剩余尾部数组进行逆转（由于当前处于desc，是最大的，逆转后当前序列起始数）
            reverse(nums, ++firstUpIndex, --length);

        }

        /**
         * 数组元素交换位置
         */
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 数组逆转
         */
        private void reverse(int[] nums, int beginIndex, int endIndex) {
            while (beginIndex < endIndex) {
                swap(nums, beginIndex++, endIndex--);
            }
        }
    }

}
