package tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-05 20:27
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        int change = coinChange(coins, m);
        System.out.println(change);

    }

    private static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        //保存0～amount各数额可以分成多少枚零钱
        int[] change = new int[amount + 1];
        HashMap<Integer, HashMap<Integer, Integer>> maxMap = new HashMap<>(amount);
        HashMap<Integer, Integer> curMap;

        for (int i = 0; i < amount + 1; i++) {
            if (i > 0 && change[i] == 0) {
                return -1;
            }
            for (int coin : coins) {
                if (coin <= amount && i + coin < amount + 1) {
                    if (change[i + coin] == 0) {
                        change[i + coin] = change[i] + 1;
                        curMap = new HashMap<>(maxMap.getOrDefault(i, new HashMap<>(coins.length)));
                        curMap.put(coin, curMap.getOrDefault(coin, 0) + 1);
                        maxMap.put(i + coin, curMap);
                    } else {
                        if (change[i] + 1 < change[i + coin]) {
                            change[i + coin] = change[i] + 1;
                            curMap = new HashMap<>(maxMap.getOrDefault(i, new HashMap<>(coins.length)));
                            curMap.put(coin, curMap.getOrDefault(coin, 0) + 1);
                            maxMap.put(i + coin, curMap);
                        }
                    }
                }
            }

        }
        Map<Integer, Integer> coinCount = new HashMap<>(coins.length);

        for (int i = 1; i < amount + 1; i++) {
            curMap = maxMap.get(i);
            for (int coin : coins) {
                Integer count = curMap.getOrDefault(coin, 0);
                if (count > coinCount.getOrDefault(coin, 0)) {
                    coinCount.put(coin, count);
                }
            }
        }
        int max = 0;
        for (int c : coinCount.values()) {
            max += c;
        }
        return max;
    }
}
