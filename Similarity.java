/**
 * An interface for the concept of similarity in the application
 * Pastiche.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public interface Similarity {

    /**
     * Calculates a similarity measure between two documents
     * represented by their WordMap objects.
     *
     * @param a the WordMap of document A
     * @param b the WordMap of document B
     * @return the similarity measure of the two frequency vectors
     * @throws NullPointerException if any of the two parameters is null
     * @throws IllegalArgumentException if any of the two WordMap object has size 0
     */
    
    double score(WordMap a, WordMap b);
}
