package problems.design;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-11 16:49
 *  // This is the interface that allows for creating nested lists.
 *  // You should not implement it, or speculate about its implementation
 **/

import java.util.List;
public interface NestedInteger {
     // Constructor initializes an empty nested list.
//     public NestedInteger(){}

     // Constructor initializes a single integer.
//     public NestedInteger(int value){}

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
class Solution {
    public NestedInteger deserialize(String s) {
        return null;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
