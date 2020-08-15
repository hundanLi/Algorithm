package problems.stack;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2020-01-13 23:57
 **/
public class StockSpanner {
    private static class Price {
        int date;
        int price;

        public Price(int date, int price) {
            this.date = date;
            this.price = price;
        }
    }

    private int date;
    private Stack<Price> prices;

    public StockSpanner() {
        prices = new Stack<>();
    }

    public int next(int price) {
        while (!prices.empty() && prices.peek().price <= price) {
            prices.pop();
        }
        date++;
        int res = date;
        if (!prices.empty()) {
            res = date - prices.peek().date;
        }
        prices.push(new Price(date, price));
        return res;
    }
}
