/**
 * An objet that reads and stores the content of file. It posses a
 * method that returns an iterator on the content (a String).
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordReader {

    // The content of the file that was read
    
    private String content;

    private class WordIterator implements Iterator<String> {

        private int offset;
        private final int size;

        private WordIterator(int size) {
            this.size = size;
        }

        @Override
        public String next() {

            if (offset + size > content.length()) {
                throw new NoSuchElementException();
            }

            String word;
            word = content.substring(offset, offset+size);

            offset++;
            
            return word;
        }

        @Override
        public boolean hasNext() {
            return offset + size <= content.length();
        }
        
    }

    /**
     * When an object of the class WordReader is created, this
     * constructor reads the content the file specified by the
     * parameter fileName.
     *
     * @param fileName the specified file
     * @throws FileNotFoundException if the file could not be found
     * @throws IOException if there is an error reading the content of the file
     */
    
    public WordReader(String fileName) throws FileNotFoundException, IOException {
        this(fileName, true, false);
    }
    
    /**
     * When an object of the class WordReader is created, this
     * constructor reads the content the file specified by the
     * parameter fileName.
     *
     * @param fileName the specified file
     * @param caseSensitive if the value is false, the content is transformed to lower case letters
     * @throws FileNotFoundException if the file could not be found
     * @throws IOException if there is an error reading the content of the file
     */
    
    public WordReader(String fileName, boolean caseSensitive) throws FileNotFoundException, IOException {
        this(fileName, caseSensitive, false);
    }
    
    /**
     * When an object of the class WordReader is created, this
     * constructor reads the content the file specified by the
     * parameter fileName.
     *
     * @param fileName the specified file
     * @param caseSensitive if the value is false, the content is transformed to lower case letters
     @ @param removeAllBlanks removes spaces
     * @throws FileNotFoundException if the file could not be found
     * @throws IOException if there is an error reading the content of the file
     */
    
    public WordReader(String fileName, boolean caseSensitive, boolean removeAllBlanks) throws FileNotFoundException, IOException {

        if (fileName == null) {
            throw new NullPointerException();
        }

        InputStreamReader input;
        input =  new InputStreamReader(new FileInputStream(fileName), "UTF-8");

        BufferedReader reader;
        reader = new BufferedReader(input);

        StringBuilder buffer;
        buffer = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            if (! caseSensitive) {
                line = line.toLowerCase();
            }
            buffer.append(line);
        }
        
        reader.close();

        content = buffer.toString();

        if (removeAllBlanks) {
            content = content.replaceAll("\\p{Space}","");
        }
        
    }

    /**
     * Returns an iterator over the content in the text.
     *
     * @param size the size of the n-grams to be returned by the method of the iterator
     * @return an iterator over the content in the text
     */
    
    public Iterator<String> iterator(int size) {

        if (size < 1 || size > content.length()) {
            throw new IllegalArgumentException("size must be larger than zero: " + Integer.toString(size));
        }

        return new WordIterator(size);
        
    }

    /**
     * Returns a String representation of the object. Useful for
     * debugging purposes.
     *
     * @return a String representation
     */

    @Override
    public String toString() {
        return "Content = " + content;
    }
    

}
