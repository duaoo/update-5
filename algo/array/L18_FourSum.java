package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针

/**
 * 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class L18_FourSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        int target = -9;
        System.out.println("期望结果:[[-5,-4,-1,1],[-5,-4,0,0],[-5,-2,-2,0],[-4,-2,-2,-1]]");
        System.out.println(solution_1(nums, target).toString());
    }


    public static List<List<Integer>> solution_1(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // 排序，asc
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 外层循环，如果当前最小值比目标值还大，说明当前值过大，后续三数组合都会大于目标值，终止循环跳出
            int outMin = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (outMin > target) {
                break;
            }

            // 外层循环，如果当前最大值比目标值还小，说明当前值过小，后续三数组合均无意义，跳过即可
            int outMax = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (outMax < target) {
                continue;
            }

            // 内层循环，按三数之和处理
            for (int j = i + 1; j < length - 2; j++) {

                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 内层循环，如果当前最小值比四数目标值还大，说明当前值过大，后续值更大，终止循环跳出
                int inMin = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (inMin > target) {
                    break;
                }

                // 内层循环，如果当前最大值比四数目标值还小，说明当前值过小，后续两数组合均无意义，跳过即可
                int inMax = nums[i] + nums[j] + nums[length - 1] + nums[length - 2];
                if (inMax < target) {
                    continue;
                }

                // 移动双指针搜寻匹配三数之和的组合
                int left = j + 1;
                int right = length - 1;
                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {

                        // 符合条件的存入结果集
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 移动到下一指针位置
                        left++;
                        right--;

                        // 左指针去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // 右指针去重
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        // 当前四数之和小于目标和，说明当前值左指针较小，需向右移动
                        left++;
                    } else {
                        //  当前四数之和大于目标和，说明当前值右指针较大，需向左移动
                        right--;
                    }
                }
            }
        }

        return result;
    }

}
