import java.util.ArrayList;

public class MyHashTable<K, V> {
    private static int size;
    private ArrayList<Node<K, V>> buckets;

    private static class Node<K, V> {
        private final K key; // a variable of type K representing the key of a key-value pair
        private V value; // a variable of type V representing the value of a key-value pair
        private Node<K, V> next;
        /*
        Node is a private class representing a node in the hashTable
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    /*
    MyHashTable is constructor that creates a hashTable with default size 10
    */
    public MyHashTable() {
        this.size = 10; // default size
        this.buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }
    /*
    MyHashTable is constructor that creates a hashTable with specified size
    */
    public MyHashTable(int size) {
        this.size = size;
        this.buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }
    /*
    put is method used to add elements to the hashTable
    */
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = buckets.get(index);
        if (node == null) {
            buckets.set(index, new Node<>(key, value));
        } else {
            while (node.next != null) {
                if (node.key.equals(key)) {
                    node.value = value; // update existing key
                    return;
                }
                node = node.next;
            }
            if (node.key.equals(key)) {
                node.value = value; // update existing key
            } else {
                node.next = new Node<>(key, value);
            }
        }
    }
    /*
    get is method used to retrieve the value associated with a key in the hashTable
    */
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = buckets.get(index);
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    /*
    getIndex is a private method used to get the index of the bucket where a key-value pair should be stored
    */
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }
    public int getSize() {
        return size;
    }
    /*
    getBucketSize is method used to get the number of elements in a specific bucket
    */
    public int getBucketSize(int index) {
        int count = 0;
        Node<K, V> node = buckets.get(index);
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    /*
    printBucketSizes is method used to print the number of elements in each bucket
    */
    public void printBucketSizes() {
        for (int i = 0; i < size; i++) {
            System.out.println("Bucket " + i + ": " + getBucketSize(i));
        }
    }
    public boolean replace(K key, V oldValue, V newValue) {
        int index = getIndex(key);
        Node<K, V> node = buckets.get(index);
        while (node != null) {
            if (node.key.equals(key) && node.value.equals(oldValue)) {
                node.value = newValue;
                return true;
            }
            node = node.next;
        }
        return false;

    }
}
