/** 
 * A test program illustrating how Cosine is expected to be
 * work.
 * 
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TestCosine {

    private static void testScore00(WordMap w1, WordMap w2) {

        w1.update("one");
        w1.update("two");
        w1.update("three");
        w1.update("four");
        w1.update("five");

        w2.update("un");
        w2.update("deux");
        w2.update("trois");
        w2.update("quatre");
        w2.update("cinq");

        Utils.assertEquals(0.0, new Cosine().score(w1,w2), 0.00001);

    }

    private static void testScore10(WordMap w1, WordMap w2) {


        w1.update("one");
        w1.update("two");
        w1.update("three");
        w1.update("four");
        w1.update("five");

        w2.update("one");
        w2.update("two");
        w2.update("three");
        w2.update("four");
        w2.update("five");

        Utils.assertEquals(1.0, new Cosine().score(w1,w2), 0.00001);

    }
    
    private static void testScore822(WordMap w1, WordMap w2) {

        // Adapted from
        // https://medium.com/@sumn2u/cosine-similarity-between-two-sentences-8f6630b0ebb7
        // 
        // w1 = Julie loves me more that Linda loves me
        // w2 = Jane likes me more than Julie loves me
        
        w1.update("me");
        w1.update("me");
        w1.update("Julie");
        w1.update("Linda");
        w1.update("loves");
        w1.update("loves");
        w1.update("more");
        w1.update("than");

        w2.update("me");
        w2.update("me");
        w2.update("Jane");
        w2.update("Julie");
        w2.update("likes");
        w2.update("loves");
        w2.update("more");
        w2.update("than");
        
        Utils.assertEquals(0.822, new Cosine().score(w1,w2), 0.001);

    }

    private static void testScore935(WordMap w1, WordMap w2) {

        // Adapted from
        // https://www.sciencedirect.com/topics/computer-science/cosine-similarity

        w1.update("A");
        w1.update("A");
        w1.update("A");
        w1.update("A");
        w1.update("A");
        w1.update("C");
        w1.update("C");
        w1.update("C");
        w1.update("E");
        w1.update("E");
        w1.update("H");
        w1.update("H");

        w2.update("A");
        w2.update("A");
        w2.update("A");
        w2.update("C");
        w2.update("C");
        w2.update("E");
        w2.update("F");
        w2.update("H");
        w2.update("J");
        
        Utils.assertEquals(0.935, new Cosine().score(w1,w2), 0.001);

    }

    private static void testScoreOneToSix(WordMap w1, WordMap w2) {

        // Adapted from
        // https://www.sciencedirect.com/topics/computer-science/cosine-similarity

        w1.update("one");
        w1.update("two");
        w1.update("two");
        w1.update("three");
        w1.update("three");
        w1.update("three");
        w1.update("four");
        w1.update("four");
        w1.update("four");
        w1.update("four");
        w1.update("five");
        w1.update("five");
        w1.update("five");
        w1.update("five");
        w1.update("five");
        w1.update("six");
        w1.update("six");
        w1.update("six");
        w1.update("six");
        w1.update("six");
        w1.update("six");

        w2.update("un");
        w2.update("deux");
        w2.update("deux");
        w2.update("trois");
        w2.update("trois");
        w2.update("trois");
        w2.update("quatre");
        w2.update("quatre");
        w2.update("quatre");
        w2.update("quatre");
        w2.update("cinq");
        w2.update("cinq");
        w2.update("cinq");
        w2.update("cinq");
        w2.update("cinq");
        w2.update("six");
        w2.update("six");
        w2.update("six");
        w2.update("six");
        w2.update("six");
        w2.update("six");
        
        Utils.assertEquals(0.39560, new Cosine().score(w1,w2), 0.00001);

    }


    /**
     * Runs the tests.
     *
     * @param args reference to the array of values passed on the command line
     */

    public static void main(String[] args) {

        StudentInfo.display();

        if (args.length != 0) {
            System.out.println("Usage: java TestCosine");
            return;
        }

        // You can either use LinkedWordMap or TreeWordMap with these tests.

        System.out.println("testScore00(new LinkedWordMap(), new LinkedWordMap())");

        testScore00(new LinkedWordMap(), new LinkedWordMap());
        
        System.out.println("testScore10(new LinkedWordMap(), new LinkedWordMap())");

        testScore10(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore822(new LinkedWordMap(), new LinkedWordMap())");

        testScore822(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore935(new LinkedWordMap(), new LinkedWordMap())");

        testScore935(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScoreOneToSix(new LinkedWordMap(), new LinkedWordMap())");

        testScoreOneToSix(new LinkedWordMap(), new LinkedWordMap());
        
    }

}
