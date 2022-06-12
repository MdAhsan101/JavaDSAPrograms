import java.util.*;

public class ArrayListProg
{
    public static void main(String args[])
    {
        ArrayList<Integer> list= new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        list.addAll(list2);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(Integer.valueOf(1));
        System.out.println(list);

        list.add(1,10);
        System.out.println(list);

        System.out.println(list.get(0));  
        
        list.set(1,11);
        System.out.println(list);

        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+" ");
        System.out.println();

        for(Integer ele: list)
            System.out.print(ele+" ");
        System.out.println();

        Iterator<Integer> itr= list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }
}