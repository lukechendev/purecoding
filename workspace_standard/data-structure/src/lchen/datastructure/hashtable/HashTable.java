package lchen.datastructure.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HashTable<K, V> {

    private static int INITIAL_CAPACITY = 10;

    private HashNode<K, V>[] table;
    private int capacity;
    private int size;
    private int usedCapacity;

    private Set<K> keySet;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = (HashNode<K, V>[]) new HashNode[capacity];
        keySet = new HashSet<K>();
    }

    public V put(K key, V value) {
        V preValue = null;

        int index = getIndex(key);

        HashNode<K, V> curNode = table[index];
        if (curNode == null) {
            curNode = new HashNode<K, V>(key, value);
            table[index] = curNode;
            usedCapacity++;
        } else {
            while (!curNode.key.equals(key) && curNode.next != null) {
                curNode = curNode.next;
            }

            if (curNode.key.equals(key)) {
                preValue = curNode.value;
                curNode.value = value;
            } else {
                curNode.next = new HashNode<K, V>(key, value);
            }
        }

        keySet.add(key);
        size++;

        resize();

        return preValue;
    }

    public V get(K key) {
        V value = null;

        int index = getIndex(key);

        HashNode<K, V> curNode = table[index];
        if (curNode != null) {
            while (!curNode.key.equals(key) && curNode.next != null) {
                curNode = curNode.next;
            }

            if (curNode.key.equals(key)) {
                value = curNode.value;
            }
        }

        return value;
    }

    public V remove(K key) {
        V preValue = null;

        int index = getIndex(key);

        HashNode<K, V> curNode = table[index];
        if (curNode != null) {
            if (curNode.key.equals(key)) {
                preValue = curNode.value;
                table[index] = null;
                usedCapacity--;
            } else {
                while (curNode.next != null && !curNode.next.key.equals(key)) {
                    curNode = curNode.next;
                }

                if (curNode.next.key.equals(key)) {
                    preValue = curNode.next.value;
                    curNode.next = null;
                }
            }
        }

        if (preValue != null) {
            keySet.remove(key);
            size--;
        }

        resize();

        return preValue;
    }

    public boolean contains(K key) {
        boolean contains = false;

        int index = getIndex(key);

        HashNode<K, V> curNode = table[index];
        if (curNode != null) {
            while (!curNode.key.equals(key) && curNode.next != null) {
                curNode = curNode.next;
            }

            if (curNode.key.equals(key)) {
                contains = true;
            }
        }

        return contains;
    }

    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    public boolean containsValue(V value) {
        for (HashNode<K, V> curNode : table) {
            while (curNode != null) {
                if (curNode.value.equals(value)) {
                    return true;
                }
                curNode = curNode.next;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;

        for (HashNode<K, V> curNode : table) {
            if (curNode != null) {
                isEmpty = false;
                break;
            }
        }

        return isEmpty;
    }

    public int size() {
        return size;
    }

    public int usedCapacity() {
        return usedCapacity;
    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("HashTable: [");

        for (HashNode<K, V> curNode : table) {
            if (curNode != null) {
                buff.append("[");
                while (curNode != null) {
                    buff.append("(").append(curNode.key).append(",").append(curNode.value).append(")->");
                    curNode = curNode.next;
                }
                buff.delete(buff.length() - 2, buff.length());
                buff.append("],");
            }
        }
        if (size() > 0) {
            buff.deleteCharAt(buff.length() - 1);
        }

        buff.append("]");
        return buff.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    private static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int getIndex(K key) {
        int hash = Math.abs(hash(key));
        return hash % capacity;
    }

    // Initializes or doubles table size
    private HashNode<K, V>[] resize() {
        int newCapacity = capacity;
        if (size < capacity * 0.7 /* && size > capacity * 0.2 */) {
            return table;
        }

        newCapacity *= 2;

        HashTable<K, V> newTable = new HashTable<K, V>(newCapacity);
        for (HashNode<K, V> curNode : table) {
            while (curNode != null) {
                newTable.put(curNode.key, curNode.value);
                curNode = curNode.next;
            }
        }

        table = newTable.table;
        capacity = newCapacity;
        usedCapacity = newTable.usedCapacity;

        return table;
    }

    private static class HashNode<K, V> {
        private K key;
        private V value;

        private HashNode<K, V> next;

        private HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("HashTable");
        System.out.println();

        HashTable<String, Integer> t = new HashTable<String, Integer>();

        System.out.println("Size of table: " + t.size());
        System.out.println("Used capacity in table: " + t.usedCapacity());
        System.out.println("Is empty table: " + t.isEmpty());
        t.print();

        t.put("Jack", 23);
        t.put("Slam", 77);
        t.put("Ron", 44);

        // Before resize is triggered
        System.out.println("Before resize");
        System.out.println("Size of table: " + t.size());
        System.out.println("Used capacity in table: " + t.usedCapacity());
        System.out.println("Is empty table: " + t.isEmpty());
        t.print();

        t.put("Tom", 32);
        t.put("Rason", 49);
        t.put("Tank", 44);
        t.put("Aila", 44);
        t.put("Sophia", 19);
        t.put("Isabella", 19);
        t.put("Luke", 44);
        t.put("Fang", 43);
        t.put("Lavoie", 45);
        t.put("K", 50);
        t.put("Jerry", 60);
        t.put("Richard", 83);
        t.put("Sim", 37);
        t.put("Jupiter", 48);
        t.put("Graham", 46);
        t.put("Lin", 32);

        // After resize happened
        System.out.println("After resize");
        System.out.println("Size of table: " + t.size());
        System.out.println("Used capacity in table: " + t.usedCapacity());
        System.out.println("Is empty table: " + t.isEmpty());
        t.print();

        System.out.println("Size of table: " + t.size());
        System.out.println("Used capacity in table: " + t.usedCapacity());
        System.out.println("Is empty table: " + t.isEmpty());

        System.out.println("Contains Sophia: " + t.contains("Sophia"));
        System.out.println("Contains SOPHIA: " + t.contains("SOPHIA"));
        System.out.println("Contains Slam: " + t.contains("Slam"));
        System.out.println("Contains Hack: " + t.contains("Hack"));
        System.out.println("Contains Ron: " + t.contains("Ron"));

        System.out.println("Contains Sophia: " + t.containsKey("Sophia"));
        System.out.println("Contains SOPHIA: " + t.containsKey("SOPHIA"));
        System.out.println("Contains Slam: " + t.containsKey("Slam"));
        System.out.println("Contains Hack: " + t.containsKey("Hack"));
        System.out.println("Contains Ron: " + t.containsKey("Ron"));

        System.out.println("Contains 83: " + t.containsValue(83));
        System.out.println("Contains 44: " + t.containsValue(44));
        System.out.println("Contains 47: " + t.containsValue(47));

        System.out.println("Tom: " + t.get("Tom"));
        System.out.println("Rason: " + t.get("Rason"));
        System.out.println("Jack: " + t.get("Jack"));
        System.out.println("K: " + t.get("K"));
        System.out.println("Hack: " + t.get("Hack"));
        System.out.println("Ron: " + t.get("Ron"));

        System.out.println("Removed Ron: " + t.remove("Ron"));
        System.out.println("Size of table: " + t.size());
        System.out.println("Removed Jack: " + t.remove("Jack"));
        System.out.println("Size of table: " + t.size());
        System.out.println("Removed Lin: " + t.remove("Lin"));
        System.out.println("Size of table: " + t.size());
        System.out.println("Removed Hack: " + t.remove("Hack"));
        System.out.println("Size of table: " + t.size());

        System.out.println("Used capacity in table: " + t.usedCapacity());
        System.out.println("Is empty table: " + t.isEmpty());
        t.print();
    }
}
