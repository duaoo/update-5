package array;

import java.util.*;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针

public class L15_ThreeSum {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//
        System.out.println(solution2(nums).toString());


    }

    private static List<List<Integer>> solution2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        Set<String> existNumsSet = new HashSet<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int standIndex = i;
            int leftIndex = standIndex + 1;
            int rightIndex = len - 1;

            while (leftIndex < rightIndex) {

                int sum = nums[standIndex] + nums[leftIndex] + nums[rightIndex];
                if (sum == 0) {

                    List<Integer> sumZeroList = Arrays.asList(nums[standIndex], nums[leftIndex], nums[rightIndex]);
                    Collections.sort(sumZeroList);

                    if (!existNumsSet.contains(sumZeroList.toString())) {

                        result.add(sumZeroList);
                        existNumsSet.add(sumZeroList.toString());
                    }

                    leftIndex++;
                    rightIndex--;

                } else if (sum < 0) {

                    leftIndex++;
                } else {

                    rightIndex--;
                }

            }

        }

        return result;

    }

    public static List<List<Integer>> solution1(int[] nums) {

        List<List<Integer>> allResult = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        Integer[] sumZero = new Integer[]{nums[i], nums[j], nums[k]};
                        allResult.add(Arrays.asList(sumZero));
                    }
                }
            }
        }

        return allResult;

    }
}
