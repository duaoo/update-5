package array;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class L70_ClimbStairs {

    /**
     * 创建数组记忆每个阶梯数的走法数目，直到最大阶梯数
     * 空间复杂度大
     * 时间复杂度O(n)
     */
    public int solution_2(int n) {

        // 阶梯小于3时，阶梯数即为当前阶梯的走法数目
        if (n < 3) {
            return n;
        }

        // 创建数组，存放不同阶梯数的走法数目
        int[] steps = new int[n];

        // 由于数组下标从0开始，0即为1阶楼梯开始
        steps[0] = 1;
        steps[1] = 2;

        // 经推导，当前阶梯走法均为前两个阶梯走法之和，即f(n) = f(n-1) + fun(n-2)
        // 此处开始处理大于2个阶梯(index=2)的走法，结算当前台阶的走法数目
        for (int i = 2; i < n; i++) {

            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n - 1];
    }

    /**
     * 最大阶梯数的累计走法
     * 空间复杂度低
     * 时间复杂度O(n)
     */
    public int solution_1(int n) {

        // 当阶梯书数为1和2时，阶梯走法与阶梯数相同
        if (n <= 2) {
            return n;
        }

        int stepN = 0;
        int stepN_1 = 2;
        int stepN_2 = 1;

        // 经推导，当前阶梯走法均为前两个阶梯走法之和，即f(n) = f(n-1) + fun(n-2)
        // 此处开始处理大于2个阶梯的走法，累计当前阶梯以及当前阶梯-1阶梯的走法数
        for (int i = 3; i <= n; i++) {

            // 计算当前阶数的走法
            stepN = stepN_1 + stepN_2;

            // 下阶阶梯数(++i)-2的走法，即当前阶梯数(i-1)的走法
            stepN_2 = stepN_1;

            // 下阶阶梯数(++i)-1的走法，即当前阶梯数的走法
            stepN_1 = stepN;
        }

        return stepN;
    }

}
