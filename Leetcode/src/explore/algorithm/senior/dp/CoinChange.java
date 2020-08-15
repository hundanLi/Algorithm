package explore.algorithm.senior.dp;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 16:50
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        //保存0～amount各数额可以分成多少枚零钱
        int[] change = new int[amount + 1];
        for (int i = 0; i < amount; i++) {
            if (i > 0 && change[i] == 0) {
                continue;
            }
            for (int coin : coins) {
                if (coin <= amount && i + coin < amount + 1) {
                    if (change[i + coin] == 0) {
                        change[i + coin] = change[i] + 1;
                    } else {
                        change[i + coin] = Math.min(change[i] + 1, change[i + coin]);
                    }
                }
            }
        }
        return change[amount] != 0 ? change[amount] : -1;
    }

}
