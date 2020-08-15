package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 00:50
 * 思路： 找出最小值以及该位置后面的最大值
 *      两者之差即为最大利润
 **/
public class MaxProfit {
    public int maxProfit(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }
        int min = price[0];
        int maxProfit = 0;
        int profit;
        for (int p : price) {
            profit = p - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, p);
        }
        return maxProfit;
    }


    /**
     * @param price 股票价格
     * @return  最大利润
     * 思路：
     *
     */
    public int maxProfitIII(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int p : price) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell2 = Math.max(sell2, buy2 + p);
        }
        return sell2;
    }
}
