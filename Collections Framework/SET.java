import java.util.*;

public class SET
{
    public static void main(String args[])
    {   
        Set<Integer> set= new HashSet<>();
        //Set<Integer> set= new LinkedHashSet<>();
        //Set<Integer> set= new TreeSet<>();

        set.add(2);
        set.add(5);
        set.add(7);
        set.add(8);
        set.add(3);
        set.add(1);
        set.add(4);

        System.out.println(set);
        
        set.remove(3);
        System.out.println(set);

        System.out.println(set.contains(3));  

        System.out.println(set.size());

        Iterator<Integer> itr= set.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }
        System.out.println();

        set.clear();

        System.out.println(set.isEmpty());
    }
}