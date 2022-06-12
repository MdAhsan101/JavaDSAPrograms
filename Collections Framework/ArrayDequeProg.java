import java.util.*;

public class ArrayDequeProg 
{
    public static void main(String args[])
    {
        ArrayDeque<Integer> adq= new ArrayDeque<>();

        adq.offer(7);
        adq.offerFirst(2);
        adq.offerLast(9);
        adq.offer(8);
        
        System.out.println(adq);

        adq.poll();
        System.out.println(adq);

        adq.pollLast();
        System.out.println(adq);

        System.out.println(adq.peek());  
        System.out.println(adq.peekLast());  
        
    }
    
}
