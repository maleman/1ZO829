import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

    /**
     * According to the Javadoc of equals(Object) method of Set interface, it compares the specified object with this set for equality. 
     * Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is 
     * contained in this set (or equivalently, every member of this set is contained in the specified set).
     * Both the sets contain the same 5 elements "A", "E", "I", "O", U" and hence the output is true
     */
    public void setEqualityCase() {
        var list = List.of("A", "E", "I", "O", "U");
        var set1 = Set.copyOf(list);
        var map = Map.of(1, "U", 2, "O", 3, "I", 4, "E", 5, "A");
        var set2 = Set.copyOf(map.values());
        System.out.println(set1.equals(set2)); //prints true
    }
    
    /**
     * According to the Javadoc of equals(Object) method of Set interface, it compares the specified object with this set for equality. 
     * Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is 
     * contained in this set (or equivalently, every member of this set is contained in the specified set).
     * 
     * To check the equality of the Elements, equals(Object) method of the elements is invoked. StringBuilder class doesn't override equals(Object) 
     * method and hence two StringBuilder objects containing same texts are not considered equal. Therefore, 'set1.equals(set2)` evaluates to false.
     * Output is false:false
     */
    public void setEqualityCase1() {
        var set1 = Set.of(new StringBuilder("GOD"), new StringBuilder("IS"), new StringBuilder("GREAT"));
        var set2 = Set.of(new StringBuilder("GOD"), new StringBuilder("IS"), new StringBuilder("GREAT"));
        System.out.println((set1 == set2) + ":" + set1.equals(set2)); //prints false:false
    }

    /**
     *According to the Javadoc of copy Of method:
     * Returns an unmodifiable Set containing the elements of the given Collection. The given Collection must not be null, and it must not contain any null elements. 
     * If the given Collection contains duplicate elements, an arbitrary element of the duplicates is preserved. If the given Collection is subsequently modified, 
     * the returned Set will not reflect such modifications.
     * It throws NullPointerException if passed argument is null, or if it contains any nulls.
     * NOTE: If the given Collection is an unmodifiable Set, calling copy Of will generally not create a copy. Set.copyOf(set1); 
     * returns the same Set object referred by variable 'set1'. Hence, at Line n2, variable
     * 'set2' refers to same Set object referred by 'set1'. Therefore set1 == set2 evaluates to true and also set1.equals(set2) evaluates to true. Output is true:true
     */
    public void setEqualityCase2(){
        var sb1 = new StringBuilder("A");
        var sb2 = new StringBuilder("B");
        var set1 = Set.of(sb1, sb2);
        var set2 = Set.copyOf(set1);
        System.out.println((set1 == set2) + ":" + set1.equals(set2)); //prints true:true
    }
}