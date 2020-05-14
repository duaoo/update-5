package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class L1_TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution_1(nums, target)));
        System.out.println(Arrays.toString(solution_2(nums, target)));

    }

    private static int[] solution_2(int[] nums, int target) {

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

    private static int[] solution_1(int[] nums, int target) {

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
