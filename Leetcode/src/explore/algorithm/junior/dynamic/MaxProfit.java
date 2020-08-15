package explore.algorithm.junior.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-20 22:24
 **/
public class MaxProfit {
    public int maxProfit(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
