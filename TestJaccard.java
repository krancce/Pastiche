/** 
 * A test program for the class Jaccard.
 * 
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TestJaccard {

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

        Utils.assertEquals(0.0, new Jaccard().score(w1,w2), 0.00001);

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

        Utils.assertEquals(1.0, new Jaccard().score(w1,w2), 0.00001);

    }
    
    private static void testScore08(WordMap w1, WordMap w2) {

        w1.update("one");
        w1.update("two");
        w1.update("three");
        w1.update("four");
        w1.update("five");
        w1.update("six");
        w1.update("seven");
        w1.update("eight");

        w2.update("one");
        w2.update("two");
        w2.update("three");
        w2.update("four");
        w2.update("five");
        w2.update("six");
        w2.update("seven");
        w2.update("eight");
        w2.update("neuf");
        w2.update("dix");

        Utils.assertEquals(0.8, new Jaccard().score(w1,w2), 0.00001);

    }

    private static void testScore06(WordMap w1, WordMap w2) {

        w1.update("one");
        w1.update("two");
        w1.update("three");
        w1.update("four");
        w1.update("five");
        w1.update("six");

        w2.update("one");
        w2.update("two");
        w2.update("three");
        w2.update("four");
        w2.update("five");
        w2.update("six");
        w2.update("sept");
        w2.update("huit");
        w2.update("neuf");
        w2.update("dix");

        Utils.assertEquals(0.6, new Jaccard().score(w1,w2), 0.00001);

    }

    private static void testScore04(WordMap w1, WordMap w2) {

        w1.update("one");
        w1.update("two");
        w1.update("three");
        w1.update("four");

        w2.update("one");
        w2.update("two");
        w2.update("three");
        w2.update("four");
        w2.update("cinq");
        w2.update("six(6)");
        w2.update("sept");
        w2.update("huit");
        w2.update("neuf");
        w2.update("dix");

        Utils.assertEquals(0.4, new Jaccard().score(w1,w2), 0.00001);

    }

    /**
     * Runs the tests.
     *
     * @param args reference to the array of values passed on the command line
     */

    public static void main(String[] args) {

        StudentInfo.display();

        if (args.length != 0) {
            System.out.println("Usage: java TestJaccard");
            return;
        }

        // Can be tested witth either LinkedWordMap or TreeWordMap

        System.out.println("testScore00(new LinkedWordMap(), new LinkedWordMap())");
        
        testScore00(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore10(new LinkedWordMap(), new LinkedWordMap())");

        testScore10(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore08(new LinkedWordMap(), new LinkedWordMap())");

        testScore08(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore06(new LinkedWordMap(), new LinkedWordMap())");

        testScore06(new LinkedWordMap(), new LinkedWordMap());

        System.out.println("testScore04(new LinkedWordMap(), new LinkedWordMap())");

        testScore04(new LinkedWordMap(), new LinkedWordMap());
        
    }

}
