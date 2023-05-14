# assignment4 documentation <img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
Here is full explanation of methods 
--------    ---------    --------
<b><p> :one: MyHashTable<p></b>
<b>Description:</b> *The class has two type parameters, K and V, which represent the types of keys and values to be stored in the hash table, respectively. It has two instance variables: an integer size representing the number of buckets in the hash table, and an ArrayList of Node objects called buckets, which holds the key-value pairs.
The class provides two constructors: a default constructor, which creates a hash table with a default size of 10, and a parameterized constructor, which allows creating a hash table with a specified size.*<br><br>
<b>Methods of class:</b><br>
<b><p>put<p></b>
<b>Description:</b> *method used to add elements to the hashTable*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b><p>get<p></b>
<b>Description:</b> *method used to retrieve the value associated with a key in the hashTable*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b><p>getIndex<p></b>
<b>Description:</b> *private method used to get the index of the bucket where a key-value pair should be stored*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /*
    getIndex is a private method used to get the index of the bucket where a key-value pair should be stored
    */
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }
```
--------    ---------    --------
<b><p>getBucketSize<p></b>
<b>Description:</b> *method used to get the number of elements in a specific bucket*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b><p>printBucketSizes<p></b>
<b>Description:</b> *method used to print the number of elements in each bucket*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
/*
    printBucketSizes is method used to print the number of elements in each bucket
    */
    public void printBucketSizes() {
        for (int i = 0; i < size; i++) {
            System.out.println("Bucket " + i + ": " + getBucketSize(i));
        }
    }
```
--------    ---------    --------
<b><p> :two: MyTestingClass<p></b>
<b>Description:</b> *MyTestingClass has two instance variables name and age which are both private. It also has a constructor that takes two parameters, name and age, which are used to initialize the instance variables. Here also two getter methods getName() and getAge() which return the name and age instance variables respectively.*<br><br>
<b>Methods of class:</b><br>
<b><p>hashCode<p></b>
<b>Description:</b> *method generates a unique hash code for each instance*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /*
    hashCode is a method generates a unique hash code for each instance
    */
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }
```
