package interview;

/**
 * @date 2020-05-22 10:58 下午
 */
public class NextNum {

    public static void main(String[] args) {
        int num = 1243;
        System.out.println(num);
        System.out.println(solution(num));

    }

    /**
     * 数组从右向左寻找第一个增长序列，
     * 然后在增长序列中，找出第一个比序列头大的一个数，交换位置，
     * 最后，除新序列头的其他元素做数组反转
     */
    private static int solution(int num) {

        // 转数组并排序
        int[] nums = String.valueOf(num).chars().map(x -> x - '0').toArray();

        int length = nums.length;

        // 找到当前数的最后一个增长序列，即low->height
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 此时从i+1开始到length-1，所有值都处于desc排序
        if (i >= 0) {

            // 从右向左寻找第一个比nums[i]大的值
            int j = length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // j与i交换
            swap(nums, i, j);
        }

        reverse(nums, i + 1, length);

        StringBuilder sBuilder = new StringBuilder();
        for (int n : nums) {
            sBuilder.append(n);
        }

        return Integer.parseInt(sBuilder.toString());
    }

    /**
     * 交换位置
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 翻转数组
     */
    private static void reverse(int[] nums, int startIndex, int length) {
        while (startIndex < length - 1) {
            swap(nums, startIndex++, length-- - 1);
        }
    }

}
