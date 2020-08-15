package leetcodecup.spring2019;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 15:31
 **/
public class SmallestEquivalentString {
    private int[] parent = new int[26];
    /**
     * 路径压缩
     */
    private int get(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = get(parent[x]);
    }

    /**
     * 合并子树
     */
    private void merge(int x, int y) {
        x = get(x);
        y = get(y);
        if (x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    public String smallestEquivalentString(String sa, String sb, String s) {
        if (sa == null || sa.length() == 0 || sb == null || sb.length() == 0) {
            return s;
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < sa.length(); i++) {
            merge(sa.charAt(i) - 'a', sb.charAt(i) - 'a');
        }
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            strb.append((char)('a' + get(s.charAt(i) - 'a')));
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        String sa = "jhvvkumwbbwtbbooshiqgwbnitulvakmiircckcynbgpaknbhl",
                sb = "myxnbttwdnmnlauyublkdkednginbexehhmkvbaobhwoaqhpbc",
                s = "qeuognweijtsflxbekdlrjbgqtlrnusmrkkvdgfqufycikfotf";

        String string = new SmallestEquivalentString().smallestEquivalentString(sa, sb, s);
        System.out.println(string);
    }
}
