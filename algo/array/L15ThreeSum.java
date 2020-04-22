package array;

import java.util.*;

/**
 * @author duxiaojie
 * @date 2020-04-20 1:23 下午
 */
public class L15ThreeSum {

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
