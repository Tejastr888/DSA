import java.util.HashSet;

public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        set1.add(null);
        set.addAll(set1);
        set.add(25);
        set.add(35);
        set.add(67);
        set.add(46);
        set.add(89);
        set1.add(35);
        System.out.println(set);
        set.retainAll(set1);
        System.out.println(set);
        set.removeAll(set1);
        System.out.println(set1+" "+set);

    }
}
