import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass("Name" + i, rand.nextInt(100));
            Student value = new Student("Student" + i, rand.nextInt(100));
            table.put(key, value);
        }
        table.printBucketSizes();

        // tune the hashCode method
        MyHashTable<MyTestingClass, Student> table2 = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass("Name" + i, rand.nextInt(100));
            Student value = new Student("Student" + i, rand.nextInt(100));
            table2.put(key, value);
        }
        table2.printBucketSizes();
    }
}