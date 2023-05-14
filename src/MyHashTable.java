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
}
