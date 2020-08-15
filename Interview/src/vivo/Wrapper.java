package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-11 16:06
 **/
public class Wrapper {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr);
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here
        if (str == null || str.length() < 3) {
            return 0;
        }
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                break;
            }
            if (str.charAt(i) == '(') {
                left++;
            } else if (str.charAt(i) == ')') {
                left--;
            }
        }
        return left;

    }
}
