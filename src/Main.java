import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(); // Create a new hash table instance
        Random rand = new Random();  // Create a new random number generator
        /*
        Insert 10,000 random key-value pairs into the hash table
        */
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass("Name" + i, rand.nextInt(100));
            Student value = new Student("Student" + i, rand.nextInt(100));
            table.put(key, value);
        }
        table.printBucketSizes(); // Print the number of elements in each bucket
    }
}