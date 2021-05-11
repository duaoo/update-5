package array;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author duxiaojie
 * @date 2021-02-08 17:57
 */
public class O63_MaxProfit {

    private int solution(int[] prices) {

        int profit = 0;
        int minPrice = 0;
        for (int price : prices) {

            minPrice = Math.min(minPrice, price);
            int profitTmp = price - minPrice;
            profit = Math.max(profit, profitTmp);
        }

        return profit;
    }

}
