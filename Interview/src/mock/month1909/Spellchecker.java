package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-18 09:47
 **/
public class Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, List<String>> map = new HashMap<>(wordlist.length);
        // , 'A', 'E', 'I', 'O', 'U'
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (String s : wordlist) {
            String key = getKey(s, set);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        String[] res = new String[queries.length];
        int i = -1;
        for (String s : queries) {
            res[++i] = "";
            String key = getKey(s, set);
            if (!map.containsKey(key)) {
                continue;
            }
            String upperAns = null;
            String aeiouAns = null;
            for (String word : map.get(key)) {
                if (word.equals(s)) {
                    res[i] = word;
                    break;
                }
                int j = 0;
                boolean aeiou = false;
                boolean upper = false;
                for (; j < word.length(); j++) {
                    char cs = s.charAt(j);
                    char cw = word.charAt(j);
                    if (cs == cw) {
                        continue;
                    }
                    if (upperAns == null && (cs + 32 == cw || cw + 32 == cs)) {
                        upper = true;
                    } else if (aeiouAns == null && set.contains(cs) && set.contains(cw)) {
                        aeiou = true;
                    } else {
                        break;
                    }
                }
                if (j == word.length()) {
                    if (aeiou) {
                        aeiouAns = word;
                    } else if (upper) {
                        upperAns = word;
                    }
                }
            }
            if ("".equals(res[i])) {
                if (upperAns != null) {
                    res[i] = upperAns;
                } else if (aeiouAns != null) {
                    res[i] = aeiouAns;
                }
            }

        }
        return res;
    }

    private String getKey(String word, Set<Character> set) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (set.contains(c)) {
                builder.append('*');
            } else if ('A' <= c && c <= 'Z') {
                c += 32;
                builder.append(c);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] wordList = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
//        String[] wordList = {"zuo", "zeo"};
//        String[] queries = {"Zeo"};
        System.out.println(Arrays.toString(new Spellchecker().spellchecker(wordList, queries)));

    }


    public String[] spellchecker2(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>(wordlist.length);
        Map<String, String> case2word = new HashMap<>(wordlist.length);
        Map<String, String> pattern2word = new HashMap<>(wordlist.length);
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (String word : wordlist) {
            wordSet.add(word);
            String lowerCase = word.toLowerCase();
            case2word.putIfAbsent(lowerCase, word);
            pattern2word.putIfAbsent(pattern(lowerCase, set), word);
        }
        int i = 0;
        for (String word : queries) {
            if (wordSet.contains(word)) {
                queries[i++] = word;
                continue;
            }
            String lowerCase = word.toLowerCase();
            if (case2word.containsKey(lowerCase)) {
                queries[i++] = case2word.get(lowerCase);
                continue;
            }
            String pattern = pattern(lowerCase, set);
            if (pattern2word.containsKey(pattern)) {
                queries[i++] = pattern2word.get(pattern);
                continue;
            }
            queries[i++] = "";
        }
        return queries;
    }

    private String pattern(String word, Set<Character> set) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (set.contains(c)) {
                chars[i] = '*';
            }
        }
        return new String(chars);
    }

}
