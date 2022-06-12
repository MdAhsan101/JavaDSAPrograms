import java.util.*;
public class MAP 
{
    public static void main(String args[])
    {
        Map<Integer,String> mp= new HashMap<>();
        mp.put(1,"Allen");
        mp.put(2,"Sumit");
        mp.put(6,"Jack");
        mp.put(4,"Dwayne");
        mp.put(3,"Eris");

        System.out.println(mp);

        mp.put(2,"Sajid");
        System.out.println(mp);

        System.out.println(mp.containsKey(5));
        System.out.println(mp.containsValue("Allen"));

        mp.putIfAbsent(5, "NewVal");
        System.out.println(mp);

        mp.putIfAbsent(4, "Alexa");
        System.out.println(mp);

        String str= mp.remove(2);
        System.out.println("Removed value is "+str);
        System.out.println(mp);
        
        for(Map.Entry<Integer,String> pr: mp.entrySet())
        {
            System.out.println(pr);    
            System.out.println(pr.getKey()+":"+pr.getValue());
        }

        for(Integer key: mp.keySet())
            System.out.print(key+" ");
        
        System.out.println();
        
        for(String val: mp.values())
            System.out.print(val+" ");
        
        mp.clear();
        System.out.println();
        System.out.println(mp.isEmpty());
    }
}
