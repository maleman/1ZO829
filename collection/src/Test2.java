import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test2 {

    /**
     * Sobre carga
     * public SortedMap<K,V> headMap(K toKey) {
     *  return headMap(toKey, false);
     * }
     * 
     * public SortedMap<K,V> tailMap(K fromKey) {
     *  return tailMap(fromKey, true);
     * }
     */
    
    public void exampleNavigableMap(){
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(25, "VEINTEYCINCO");
        map.put(32, "TREINTAYDOS");
        map.put(11, "ONCE");
        map.put(39, "TREINTAYNUEVE");

        System.out.println(map.headMap(25)); //print {11=ONCE}
        System.out.println(map.tailMap(25)); //print {32=TREINTAYDOS, 39=TREINTAYNUEVE}
    }

    public void ejemploEquals(){
        var map1 = Map.of("1", "2", "3", "4");
        var map2 = Map.ofEntries(Map.entry("3", "4"), Map.entry("1", "2"));
        System.out.println(map1.equals(map2)+":"+ (map1 == map2)); //prints true:false
    }
}
