package interview;

import java.util.Arrays;

/**
 * @date 2020-05-22 10:58 下午
 */
public class NextMaxNum {

    private int solution(int num) {

        int res = -1;

        if (num < 10) {
            return res;
        }

        // 转数组并排序
        char[] numChartArray = Character.toChars(num);
        Arrays.sort(numChartArray);



        return res;
    }

}
