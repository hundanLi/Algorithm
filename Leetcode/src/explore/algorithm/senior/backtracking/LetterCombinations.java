package explore.algorithm.senior.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 10:20
 **/
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0 || "".equals(digits.trim())) {
            return list;
        }
        char[] chars = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        permutation(list, chars, 0, sb);
        return list;
    }

    private void permutation(List<String> list ,char[] chars, int idx, StringBuilder sb) {
        if (idx == chars.length - 1) {
            char c = chars[idx];
            switch (c) {
                case '2':
                    sb.append('a');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "b");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "c");
                    list.add(sb.toString());
                    break;
                case '3':
                    sb.append('d');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "e");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "f");
                    list.add(sb.toString());
                    break;
                case '4':
                    sb.append('g');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "h");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "i");
                    list.add(sb.toString());
                    break;
                case '5':
                    sb.append('j');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "k");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "l");
                    list.add(sb.toString());
                    break;
                case '6':
                    sb.append('m');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "n");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "o");
                    list.add(sb.toString());
                    break;
                case '7':
                    sb.append('p');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "q");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "r");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "s");
                    list.add(sb.toString());
                    break;
                case '8':
                    sb.append('t');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "u");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "v");
                    list.add(sb.toString());
                    break;
                case '9':
                    sb.append('w');
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "x");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "y");
                    list.add(sb.toString());
                    sb.replace(sb.length() - 1, sb.length(), "z");
                    list.add(sb.toString());
                    break;
                default:
                    return;
            }
        } else {
            char c = chars[idx];
            switch (c) {
                case '2':
                    sb.append('a');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "b");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "c");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '3':
                    sb.append('d');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "e");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "f");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '4':
                    sb.append('g');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "h");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "i");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '5':
                    sb.append('j');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "k");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "l");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '6':
                    sb.append('m');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "n");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "o");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '7':
                    sb.append('p');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "q");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "r");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "s");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '8':
                    sb.append('t');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "u");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "v");
                    permutation(list, chars, idx + 1, sb);
                    break;
                case '9':
                    sb.append('w');
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "x");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "y");
                    permutation(list, chars, idx + 1, sb);
                    sb.replace(sb.length() - 1, sb.length(), "z");
                    permutation(list, chars, idx + 1, sb);
                    break;
                default:
                    return;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }
/*
    class Solution {
        String[] list = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0)
                backTrack("", digits);
            return output;


        }

        List<String> output = new ArrayList<String>();
        public void backTrack (String combination, String nextDigits){
            if (nextDigits.length() == 0){
                output.add(combination);
            }else{
                String digit = nextDigits.substring(0,1);
                int num = Integer.parseInt(digit);
                String letters = list[num-2];
                for(int i = 0; i < letters.length(); i++){
                    String letter = letters.substring(i,i+1);
                    backTrack(combination+letter,nextDigits.substring(1));
                }

            }
        }
    }*/
}
