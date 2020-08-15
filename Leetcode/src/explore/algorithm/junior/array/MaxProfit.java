package explore.algorithm.junior.array;

/** 买卖股票的最佳时机
 * @author li
 * @version 1.0
 * @date 18-8-9 下午12:44
 **/
public class MaxProfit {
    //版本I
    public int maxProfitI(int prices[]) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxprofit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxprofit){
                maxprofit = profit;
            }
            if (prices[i] < min){
                min = prices[i];
            }

        }
        return maxprofit;
    }

    //版本II
    public int maxProfitII(int prices[]) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            //只要今天比昨天的价格高，就卖出去
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        MaxProfit mp = new MaxProfit();
        int maxProfit = mp.maxProfitI(prices);
        System.out.println(maxProfit);

    }
}
