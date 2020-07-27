/**
 * A Binary Search Tree implementation of the interface WordMap.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TreeWordMap implements WordMap {

    private static class Elem {

        private final String key;
        private int count;
        private Elem left, right;

        private Elem(String key) {
            this.key = key;
            count = 1;
        }

    }

    private Elem root;
    private int size;

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    @Override
    public boolean contains(String key) {

        if (key == null) {
            throw new NullPointerException();
        }

        boolean found = false;
        Elem current = root;
        while (! found && current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }
    
    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    
    @Override
    public void update(String key) {

        if (key == null) {
            throw new NullPointerException();
        }

        if (root == null) {
            
            root = new Elem(key);
            size++;
            
        } else {
            
            boolean done = false;
            Elem current = root;
            while (! done) {
                int test = key.compareTo(current.key);
                if (test == 0) {
                    current.count++;
                    done = true;
                } else if (test < 0) {
                    if (current.left == null) {
                        current.left = new Elem(key);
                        size++;
                        done = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new Elem(key);
                        size++;
                        done = true;
                    } else {
                        current = current.right;
                    }
                }
            }
            
        }
    }
    
    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param key the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */
    
    @Override
    public int get(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        
        Elem current = root;
        while (current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                return current.count;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return 0;
    }
    
    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it. 
     *
     * @return the logical size of this WordMap
     */
    
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order. This implementation is somewhat simpler than
     * keys() as it relies on addLast to insert the element at the
     * end when visiting the tree in order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys2() {

        LinkedList<String> keys = new LinkedList<String>();

        if (root != null) {
            keys2(keys, root);
        }

        return keys.toArray(new String[keys.size()]);
    }

    private static void keys2(LinkedList<String> keys, Elem current) {

        if (current.left != null) {
            keys2(keys, current.left);
        }

        keys.addLast(current.key);
        
        if (current.right != null) {
            keys2(keys, current.right);
        }

    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order. Alternative implementation that counts the
     * number of elements visited so far and uses that information to
     * insert the next element at the right position in the array.
     *
     * @return all the keys (words)
     */
    
    @Override
    public String[] keys() {

        String[] keys = new String[size];

        if (root != null) {
            keys(keys, 0, root);
        }

        return keys;
    }

    private static int keys(String[] keys, int offset, Elem current) {

        if (current.left != null) {
            offset = keys(keys, offset, current.left);
        }

        keys[offset++] = current.key;
        
        if (current.right != null) {
            offset = keys(keys, offset, current.right);
        }

        return offset;
    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys(). Somewhat simpler implementation
     * uses a linked list to keep track of the elements.
     *
     * @return all the counts
     */
    
    public Integer[] counts2() {

        LinkedList<Integer> counts = new LinkedList<Integer>();

        if (root != null) {
            counts2(counts, root);
        }

        return counts.toArray(new Integer[counts.size()]);
    }

    private static void counts2(LinkedList<Integer> counts, Elem current) {

        if (current.left != null) {
            counts2(counts, current.left);
        }

        counts.addLast(current.count);
        
        if (current.right != null) {
            counts2(counts, current.right);
        }

    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys(). Like keys2(), this
     * implementation directly works with the array.
     *
     * @return all the counts
     */
    
    @Override
    public Integer[] counts() {

        Integer[] counts = new Integer[size];

        if (root != null) {
            counts(counts, 0, root);
        }

        return counts;
    }

    private static int counts(Integer[] counts, int offset, Elem current) {

        if (current.left != null) {
            offset = counts(counts, offset, current.left);
        }

        counts[offset++] = current.count;
        
        if (current.right != null) {
            offset = counts(counts, offset, current.right);
        }

        return offset;
    }

    /** 
     * Returns a String representation of this WordMap.
     * 
     * @return a String representation of this WordMap
     */
    
    @Override
    public String toString() {

        if (root == null) {
            return "null";
        }

        return toString(root);
    }
    
    private static String toString(Elem current) {

        StringBuilder buffer;
        buffer = new StringBuilder();

        if (current.left != null) {
            buffer.append(toString(current.left));
        }

        buffer.append("('");
        buffer.append(current.key);
        buffer.append("'=");
        buffer.append(current.count);
        buffer.append(")");

        if (current.right != null) {
            buffer.append(toString(current.right));
        }

        return buffer.toString();

    }
    
}
