/** 
 * A test program illustrating how WordReader is expected to be
 * used. Specifically, when an object of the class WordReader is
 * created, the content of the file is read. A first iterator is
 * created and each call to the method next returns the next word
 * (n-gram) of size 3. Calls to next are made until the end of the
 * content is reached. A second iterator is created for the same
 * content, this one returns words of size 4.
 * 
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TestWordReader {

    /**
     * Runs the tests.
     *
     * @param args reference to the array of values passed on the command line
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if there are errors when reading the content of a file
     */

    public static void main(String[] args) throws FileNotFoundException, IOException {

        StudentInfo.display();

        if (args.length != 1) {
            System.out.println("Usage: java TestWordReader file");
            return;
        }

        WordReader w;
        w = new WordReader(args[0]);

        Iterator<String> i;
        
        i = w.iterator(3);

        while (i.hasNext()) {
            String s = i.next();
            System.out.println("["+s+"]");
        }

        i = w.iterator(4);

        while (i.hasNext()) {
            String s = i.next();
            System.out.println("["+s+"]");
        }
        
    }

}
