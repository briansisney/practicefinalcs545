package problem11;

/** Problem 11
 *  The class that implements a HashTable using closed hashing and linear probing.
 * The class is different from the one in project 4 in the following ways:
 * - Each HashEntry contains an integer key and an integer value.
 * - The hash function is computed by taking the key modulus size of the table.
 * - We do not support deletion (and hence do not store a "deleted" flag in the HashEntry).
 * - There is NO rehashing.
 * Fill in the code in methods put and containsKey.
 * The put method inserts key, value into the table (using linear probing), and returns true
 * if we were able to successfully insert it; it returns false if it could not insert since
 * there was no space in the table. (we assume we do not perform rehashing)
 * The containsKey method returns true if the key is in the table, and false otherwise.
 * Your algorithm should use linear probing.
 * Your code should be efficient, and both put and containsKey should handle the case when the table is full.
 * The main method calls put and containsKey and explains what the expected result should look like.
 */
public class HashTableClosedHashing  {
    private HashEntry[] table; // hash table
    private int maxSize; // size of the array

    /** Constructor for class HashTableClosedHashingLP.
     *  Creates a hash table of the given size.
     * @param size maximum number of elements the hash table can store
     */
    public HashTableClosedHashing(int size) {
        maxSize = size;
        table = new HashEntry[maxSize];
    }

    /** Hash function
     *
     * @param key key
     * @return the index in the table where this key hashes
     * Do not change this method.
     */
    public int hash(int key) {
        return key % maxSize;
    }

    /** Return true if the map contains a (key, value) pair associated with this key,
     *  otherwise return false.
     *
     * @param key  key
     * @return true if the key (and the corresponding value) is the in map
     */
    public boolean containsKey(int key) {
        int index = hash(key); // the index where this key hashes
        if (table[index] == null)
            return false;
        if (table[index].getKey() == key) // found the key at the index where it hashed
            return true;

        // FILL IN CODE: search for this key starting with the next cell:

        return false; // if could not find it
    }

    /** Add (key, value) to the map.
     *  Return true if was successful at finding an available index.
     *  Return false if the table is full and we could not insert the key.
     * @param key key
     * @param value associated value
     * @return true if was able to place this element in the table,
     *         and false if the table has no space
     */
    public boolean put(int key, int value) {
        boolean foundPlaceToInsert = false;
        int index = hash(key);
        if (table[index] == null) { // index is available
            table[index] = new HashEntry(key, value);
            foundPlaceToInsert = true; // found a place where we can insert
            return foundPlaceToInsert;
        }
        else { // Search for the next available index
               // If found a place, insert the key, value and return true.
               // Make sure you handle the case when the table is full
               // FILL IN CODE


        }
        return foundPlaceToInsert; // will return false, if the table was full,
        // so we could not insert this key, value
    }

    /**
     * Return a string representing the table, showing the (key, value) stored at each index
     * @return string
     * Do not change this method.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxSize; i++ ) {
            if (table[i] != null) {
                sb.append(i + ": ");
                sb.append("(" + table[i].getKey() + ", "  + table[i].getValue() + ")");
                sb.append(System.lineSeparator());
            }
            else {
                sb.append(i + ": ");
                sb.append("null");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTableClosedHashing hashTable = new HashTableClosedHashing(7);
        System.out.println("Test the put method:");
        // To keep it simple, I made the keys and values the same in this example
        System.out.println(hashTable.put(5, 5)); //true
        System.out.println(hashTable.put(10, 10)); //true
        System.out.println(hashTable.put(15, 15)); //true
        System.out.println(hashTable.put(3, 3)); //true
        System.out.println(hashTable.put(11, 11)); //true
        System.out.println(hashTable.put(12, 12)); //true
        System.out.println(hashTable.put(17, 17)); //true
        System.out.println("Resulting table: ");
        System.out.println(hashTable);
        /* Should print:
        0: (12, 12)
        1: (15, 15)
        2: (17, 17)
        3: (10, 10)
        4: (3, 3)
        5: (5, 5)
        6: (11, 11)
        */

        System.out.println("Inserting element 0 - there is no space in the table, so should print false: ");
        System.out.println(hashTable.put(0, 0)); // should print false since the table has no space.

        // Test containsKey
        System.out.println();
        System.out.println("Test containsKey:");
        System.out.println(hashTable.containsKey(3)); // should print true
        System.out.println(hashTable.containsKey(17)); // should print true
        System.out.println(hashTable.containsKey(1)); // should print false
        System.out.println(hashTable.containsKey(4)); // should print false
    }
}
