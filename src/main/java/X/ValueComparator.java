package X;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ValueComparator implements Comparator {

//    public static void main(String[] args) {
//        HashMap<String, Integer> map = new HashMap();
//        ValueComparator bvc = new ValueComparator(map);
//        TreeMap sorted_map = new TreeMap(bvc);
//
//        map.put("A", 3);
//        map.put("B", 4);
//        map.put("C", 1);
//        map.put("D", 7);
//
//        System.out.println("unsorted map: " + map);
//        sorted_map.putAll(map);
//        System.out.println("results: " + sorted_map);
//    }

    /**
     * Returns a TreeMap by descending order.
     *
     * @param map
     * @return
     */
    public static TreeMap getSortedMap(Map<String, Integer> map) {
        TreeMap res;

        ValueComparator bvc = new ValueComparator(map);
        res = new TreeMap(bvc);
        res.putAll(map);

        return res;
    }

    Map<String, Integer> base;

    public ValueComparator(Map base) {
        this.base = base;
    }

    @Override
    public int compare(Object o1, Object o2) {
        int res = 1;
        if (o1 instanceof String && o2 instanceof String) {
            String a = (String) o1, b = (String) o2;
            if (base.get(a) >= base.get(b)) {
                res = 1;
            } else {
                res = -1;
            } // returning 0 would merge keys
        } else {
            System.out.println("compare: E: MUse only Map<tring, Integer>.");
        }
        return res;
    }
}
