package array;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @date 2020-05-05 8:25 下午
 */
public class L66_PlusOne {

    public int[] solution_1(int[] digits) {

        int length = digits.length;
        int endIndex = length - 1;

        // 数字运算，从尾部开始
        while (endIndex >= 0) {

            int val = digits[endIndex];
            // 当数组中的值有小于9时，说明不需要进位，直接加1返回结果
            if (val < 9) {

                digits[endIndex] = val + 1;
                return digits;
            }

            // 如果数组中的值等于9时，则需要进位，并且当前值+1后为0，指针向前移动
            digits[endIndex--] = 0;
        }

        // 如果前面没有返回结果，则表明数组是999型，超过数组长度，需进位1即可
        int[] resultDigits = new int[length + 1];
        resultDigits[0] = 1;

        return resultDigits;

    }
}
