import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        TreeWordMap w;
        w = new TreeWordMap();

        String[] keys = new String[]{"charlie", "alpha", "bravo", "epoch", "delta"};

        for (String key : keys) {
            
            w.update(key);

        }

        Arrays.sort(keys);

        System.out.println(Arrays.equals(keys, w.keys2()));

        w = new TreeWordMap();

        w.update("B");
        w.update("B");

        Utils.assertEquals(1, w.size());
        
        w.update("A");

        Utils.assertEquals(2, w.size());

        w.update("C");        
        w.update("C");        
        w.update("C");        

        Utils.assertEquals(3, w.size());

        Utils.assertTrue(w.contains("A"));
        Utils.assertTrue(w.contains("B"));
        Utils.assertTrue(w.contains("C"));
                       
        Utils.assertEquals(1, w.get("A"));
        Utils.assertEquals(2, w.get("B"));
        Utils.assertEquals(3, w.get("C"));

        keys = new String[]{"A", "B", "C"};
        
        Utils.assertTrue(Arrays.equals(keys, w.keys2()));

        Integer[] counts = new Integer[]{1, 2, 3};
        
        Utils.assertTrue(Arrays.equals(counts, w.counts2()));


    }

}
