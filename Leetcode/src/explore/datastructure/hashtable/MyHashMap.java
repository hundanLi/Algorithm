package explore.datastructure.hashtable;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-09 08:41
 **/
public class MyHashMap {
    static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Entry)) {
                return false;
            }

            Entry entry = (Entry) o;

            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return key;
        }

    }

    private int size;
    private Entry[] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        size = 10001;
        table = new Entry[size];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int tab = key % size;
        Entry e = table[tab];
        if (e == null) {
            e = new Entry(key, value);
            table[tab] = e;
            return;
        }
        while (e.next != null && e.key != key) {
            e = e.next;
        }
        if (e.key == key) {
            e.value = value;
        } else {
            e.next = new Entry(key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int tab = key % size;
        Entry e = table[tab];
        while (e != null) {
            if (e.key == key) {
                return e.value;
            }
            e = e.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int tab = key % size;
        Entry e = table[tab];
        if (e == null) {
            return;
        }
        if (e.key == key) {
            table[tab] = e.next;
            return;
        }
        while (e.next != null) {
            if (e.next.key == key) {
                e.next = e.next.next;
                break;
            }
            e = e.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.remove(14);
        System.out.println(hashMap.get(4));
        hashMap.put(7, 3);
        hashMap.put(11, 1);
        hashMap.put(12, 1);
        System.out.println(hashMap.get(7));

    }
}
