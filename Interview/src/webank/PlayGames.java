package webank;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 19:20
 **/
public class PlayGames {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> failure = new LinkedList<>();
        int winner = josephProblem(failure, n, 0, m - 1);
        for (int i = 0; i < failure.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(failure.get(i));
        }
        if (failure.size() > 0) {
            System.out.println();
        }
        System.out.println(winner);

    }

    private static int josephProblem(List<Integer> list, int numberN, int startNumberK, int numberM) {
        //定义一个链表，让链表里面存1...1000个数
        List<Integer> josephList = new ArrayList<>();
        for (int i = 1; i <= numberN; i++) {
            josephList.add(i);
        }
        int start = startNumberK;
        int length = josephList.size();
        for (int i = 1; i < length; i++) {
            start = (start + numberM) % josephList.size();
            list.add(josephList.get(start));
            josephList.remove(start);
        }
        return josephList.get(0);
    }

}
