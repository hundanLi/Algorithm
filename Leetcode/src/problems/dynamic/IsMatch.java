package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-20 12:39
 **/
public class IsMatch {
    public boolean isMatch(String s, String p) {
        // 设match[i][j]表示s[0...i-1]与p[0...j-1]匹配
        // 那么match[i][j] =
        //  (1) match[i-1][j-1]， 当s[i-1] == p[j-1] || p[j-1] == ?
        //  (2) match[i-1][j] || match[i][j-1]，当p[j-1] == *
        //      match[i-1][j]表示*匹配多个字符，match[i][j-1]表示*匹配空字符
        if (s == null || "".equals(s)) {
            return p == null || "".equals(p) || "*".equals(p);
        }
        if (p == null) {
            return false;
        }
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            match[0][i] = match[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int si = 1; si <= s.length(); si++) {
            for (int pj = 1; pj <= p.length(); pj++) {
                if (p.charAt(pj - 1) == '*') {
                    match[si][pj] = match[si - 1][pj] || match[si][pj - 1];
                } else if (s.charAt(si - 1) == p.charAt(pj - 1) || p.charAt(pj - 1) == '?') {
                    match[si][pj] = match[si - 1][pj - 1];
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public boolean isMatchReg(String s, String p) {
        if (p == null || "".equals(p)) {
            return s == null || "".equals(s);
        }
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] match = new boolean[sLen + 1][pLen + 1];
        match[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            }
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        match[i][j] = match[i][j - 2];
                    } else {
                        match[i][j] = match[i][j - 2] || match[i][j - 1] || match[i - 1][j];
                    }
                }
            }
        }
        return match[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(new IsMatch().isMatch(s, p));
    }
}
