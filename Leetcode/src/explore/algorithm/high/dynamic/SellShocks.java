package explore.algorithm.high.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 08:34
 * buy[i] 表示第i天买入股票，sell[i]表示第i天卖出股票的最大收益；
 * 递推式：
 * 今日买入最大收益 = max(今日前已经买入, 前天已经卖出-今天股票价格)： buy[i] = max(buy[i-1], sell[i-2] - price[i]);
 * 今日卖出最大收益 = max(今日前已经卖出, 昨天前已经买入 + 今天股票价格)：sell[i] = max(sell[i-1], buy[i-1] + price[i])
 *
 **/
public class SellShocks {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevTwoSell = (i - 2 >= 0) ? sell[i - 2] : 0;
            buy[i] = Math.max(buy[i - 1], prevTwoSell - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
