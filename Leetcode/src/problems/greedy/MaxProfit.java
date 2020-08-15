package problems.greedy;


/**
 * @author li
 * @version 1.0
 * @date 2019-05-16 10:51
 **/
public class MaxProfit {
    /**
     * 思路：
     *  设hold[i]表示第i天持有股票能获得的最大利润，
     *  unHold[i]表示第i天不持有股票能获得的最大利润，则
     *     (1) hold[i]应该取
     *          ①前一天持有股票的利润值hold[i-1] 以及
     *          ②前一天不持有股票但今天买入后的利润值(unHold[i-1] - prices[i])
     *         这两者中的最大值，即
     *         hold[i] = max(hold[i-1], unHold[i-1] - prices[i])；
     *     (2) unHold[i]应该取
     *          ①前一天不持有股票的利润unHold[i-1]
     *          ②前一天持有但今天卖出的利润(hold[i-1] + prices[i] - fee)
     *         这两者中的最大值，即
     *         unHold[i] = max(unHold[i - 1], hold[i-1] + prices[i] - fee)
     *  最后返回unHold[n]
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];
        int[] unHold = new int[n];
        hold[0] = -prices[0];
        unHold[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], unHold[i - 1] - prices[i]);
            unHold[i] = Math.max(unHold[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return unHold[n - 1];
    }

    /**
     * 事实上，在计算hold[i]和unHold[i]时，只需要用到hold[i-1]以及unHold[i-1]，
     * 因此可以优化空间为O(1)
     */
    public int maxProfitOptimizeSapce(int[] prices, int fee){
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int hold = -prices[0];
        int unHold = 0;
        // 暂存前一天持有股票的利润
        int preHold;
        for (int i = 1; i < prices.length; i++) {
            preHold = hold;
            hold = Math.max(preHold, unHold - prices[i]);
            unHold = Math.max(unHold, preHold + prices[i] - fee);
        }
        return unHold;
    }
}
