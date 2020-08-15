package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-22 10:22
 **/
public class KthGrammar {

    public int kthGrammar(int n, int k) {
        StringBuilder pre = new StringBuilder("0");
        StringBuilder cur = new StringBuilder();
        int j = 0;
        char c;
        while (j < n) {
            System.out.println(pre);
            for (int i = j; i < pre.length(); i++) {
                c = pre.charAt(i);
                if (c == '0') {
                    cur.append("01");
                } else {
                    cur.append("10");
                }
            }
            pre.append(cur.substring(pre.length()));
            j++;
        }
        return pre.charAt(k - 1) - '0';
    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        kthGrammar.kthGrammar(4, 7);

    }

}
