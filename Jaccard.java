/**
 * Implements the Jaccard simililarity index.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class Jaccard implements Similarity {

    /**
     * Calculates the Jaccard similarity index between two documents
     * represented by their WordMap objects.
     *
     * @param a the WordMap of document A
     * @param b the WordMap of document B
     * @return the Jaccard of the two frequency vectors
     * @throws NullPointerException if any of the two parameters is null
     * @throws IllegalArgumentException if any of the two WordMap object has size 0
     */
    
    @Override
    public double score(WordMap a, WordMap b) {

        if (a == null || b == null) {
            throw new NullPointerException();
        }

        if (a.size() == 0 || b.size() == 0) {
            throw new IllegalArgumentException();
        }

        String[] as, bs;

        as = a.keys();
        bs = b.keys();

        int count = 0, i = 0, j = 0;

        while (i<as.length && j<bs.length) {

            int cmp = as[i].compareTo(bs[j]);

            if (cmp == 0) {
                count++;
                i++;
                j++;
            } else if (cmp < 0) {
                i++;
            } else {
                j++;
            }

        }

        return count / (double) (as.length + bs.length - count);

    }

}
