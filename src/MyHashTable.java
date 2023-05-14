import java.util.ArrayList;

public class MyHashTable<K, V> {
    private int size;
    private ArrayList<Node<K, V>> buckets;

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashTable() {
        this.size = 10; // default size
        this.buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }

    public MyHashTable(int size) {
        this.size = size;
        this.buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }

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

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }

    public int getSize() {
        return size;
    }

    public int getBucketSize(int index) {
        int count = 0;
        Node<K, V> node = buckets.get(index);
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
