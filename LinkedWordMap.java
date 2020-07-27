/**
 * An implementation of the interface WordMap using linked elements.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class LinkedWordMap implements WordMap {

    private static class Elem {
        
        private final String key;
        private int count;
        private Elem previous, next;

        public Elem(String key, Elem previous, Elem next) {
            this.key = key;
            this.count = 1;
            this.previous = previous;
            this.next = next;
        }
        
    }

    private final Elem head;
    private int size;

    public LinkedWordMap() {
        head = new Elem(null, null, null);
        head.previous = head.next = head;
    }

    private void addAfter(Elem before, String key) {
        Elem after = before.next;
        before.next = new Elem(key, before, after);
        after.previous = before.next;
        size++;
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

        Elem current = head.next;
        boolean found = false;

        while (!found && current != head) {
            if (current.key.equals(key)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        
        return found;
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

        Elem current = head.next;

        while (current != head) {
            if (current.key.equals(key)) {
                return current.count;
            } else {
                current = current.next;
            }
        }
        
        return 0;
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

        Elem current = head.next;
        boolean done = false;

        while (!done && current != head) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                current.count++;
                done = true;
            } else if (cmp > 0) {
                current = current.next;
            } else {
                addAfter(current.previous, key);
                done = true;
            }
        }

        if (! done) {
            addAfter(current.previous, key);
        }
        
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    @Override
    public String[] keys() {
        String[] keys;
        keys = new String[size];

        Elem current = head.next;

        for (int i=0; i<size; i++) {
            keys[i] = current.key;
            current = current.next;
        }

        return keys;
    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    @Override
    public Integer[] counts() {
        Integer[] counts;
        counts = new Integer[size];

        Elem current = head.next;

        for (int i=0; i<size; i++) {
            counts[i] = current.count;
            current = current.next;
        }

        return counts;
    }

    /**
     * Returns a String representation of this WordMap.
     *
     * @return a String representation of this WordMap
     */

    @Override
    
    public String toString() {

        StringBuilder buffer;
        buffer = new StringBuilder("[");
        
        Elem current = head.next;

        while (current != head) {
            if (buffer.length() > 1) {
                buffer.append(", ");
            }
            buffer.append("('");
            buffer.append(current.key);
            buffer.append("'=");
            buffer.append(current.count);
            buffer.append(")");
            current = current.next;
        }

        buffer.append("]");
        
        return buffer.toString();

    }
    
    
}
