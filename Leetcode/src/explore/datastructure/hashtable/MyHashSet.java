package explore.datastructure.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-07 11:55
 **/
public class MyHashSet {
    private int tabSize;
    private List<List<Integer>> table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        tabSize = 16;
        table = new ArrayList<>(tabSize);
        for (int i = 0; i < tabSize; i++) {
            table.add(i, new LinkedList<>());
        }
    }

    public void add(int key) {
        int tab = hash(key);
        List<Integer> list = table.get(tab);
        if (list.size() > 8) {
            resize(tabSize);
            tab = hash(key);
            list = table.get(tab);
        }
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int tab = hash(key);
        List<Integer> list = table.get(tab);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                break;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int tab = hash(key);
        List<Integer> list = table.get(tab);
        return list.contains(key);
    }


    private int hash(int key) {
        return key % tabSize;
    }

    private void resize(int oldTabSize) {
        tabSize = oldTabSize << 1;
        List<List<Integer>> oldTable = table;
        table = new ArrayList<>(tabSize);
        for (int i = 0; i < tabSize; i++) {
            table.add(i, new LinkedList<>());
        }
        for (int i = 0; i < oldTabSize; i++) {
            for (int key : oldTable.get(i)) {
                add(key);
            }
        }
    }
}
