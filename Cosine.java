/**
 * Implements the cosine simililarity measure.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class Cosine implements Similarity {

    // Helper method, returns a frequency vector
    
    private static double[] getFrequencies(WordMap w) {

        Integer[] counts = w.counts();

        int sum = 0;

        for (Integer count : counts) {
            sum += count;
        }
        
        double[] frequencies = new double[counts.length];

        for (int i=0; i<counts.length; i++) {
            frequencies[i] = counts[i] / (double) sum;
        }

        return frequencies;

    }

    // Helper method, returns the magnitude of a vector

    private static double getMagnitude(double[] xs) {

        double sum = 0.0;

        for (double x : xs) {
            sum += Math.pow(x, 2.0);
        }

        return Math.sqrt(sum);
    }

    /**
     * Calculates the cosine similarity measure between two documents
     * represented by their WordMap objects.
     *
     * @param a the WordMap of document A
     * @param b the WordMap of document B
     * @return the cosine of the two frequency vectors
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

        String[] aKeys, bKeys;

        aKeys = a.keys();
        bKeys = b.keys();

        double[] fa = getFrequencies(a);
        double[] fb = getFrequencies(b);

        double product = 0.0;

        int i = 0, j = 0;

        while (i<aKeys.length && j<bKeys.length) {

            int cmp = aKeys[i].compareTo(bKeys[j]);

            if (cmp == 0) {
                product += fa[i] * fb[j];
                i++;
                j++;
            } else if (cmp < 0) {
                i++;
            } else {
                j++;
            }

        }

        return product / (getMagnitude(fa) * getMagnitude(fb));

    }

}
