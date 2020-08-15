package explore.algorithm.senior.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 14:20
 **/
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        //正负号
        if ((numerator > 0) ^ (denominator > 0)) {
            sb.append('-');
        }
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        //整数部分
        sb.append(n / d);
        n %= d;
        if (n == 0) {
            return sb.toString();
        }

        //小数部分
        sb.append('.');
        //使用hashMap存储余数及做除法时对应上商的位置
        Map<Long, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(n, sb.length());
        while (n != 0) {
            //没除尽，补零
            n *= 10;
            //作商
            sb.append(n / d);
            //求余数
            n %= d;
            //检查余数是否重复出现
            if (remainderIndex.containsKey(n)) {
                //已重复重现，说明陷入循环
                //找出上一个余数出现的位置
                int startIdx = remainderIndex.get(n);
                //插入括号
                sb.insert(startIdx, '(');
                sb.append(')');
                break;
            } else {
                //无重复余数
                remainderIndex.put(n, sb.length());
            }
        }
        return sb.toString();
    }
}
