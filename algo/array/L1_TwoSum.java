package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

<<<<<<< HEAD
=======
/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
>>>>>>> 7a866894fd6d6c28f9d9d52f1fd9d418051fb305
public class L1_TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

<<<<<<< HEAD
        System.out.println(Arrays.toString(solution1(nums, target)));
        System.out.println(Arrays.toString(solution2(nums, target)));

    }

    private static int[] solution2(int[] nums, int target) {
=======
        System.out.println(Arrays.toString(solution_1(nums, target)));
        System.out.println(Arrays.toString(solution_2(nums, target)));

    }

    private static int[] solution_2(int[] nums, int target) {
>>>>>>> 7a866894fd6d6c28f9d9d52f1fd9d418051fb305

        Map<Integer, Integer> usedNumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!usedNumMap.containsKey(target - nums[i])) {
                usedNumMap.put(nums[i], i);
                continue;
            }

            return new int[]{i, usedNumMap.get(target - nums[i])};
        }

        return null;
    }

<<<<<<< HEAD
    private static int[] solution1(int[] nums, int target) {
=======
    private static int[] solution_1(int[] nums, int target) {
>>>>>>> 7a866894fd6d6c28f9d9d52f1fd9d418051fb305

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        throw null;

    }
}