import java.util.*;

public class PriorityQueueProg 
{
    public static void main(String args[])
    {
        //Queue<Integer> pq= new PriorityQueue<>(); // For MinHeap
        Queue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder()); // For MaxHeap

        pq.offer(2);
        pq.offer(1);
        pq.offer(5);
        pq.offer(4);
        pq.offer(3);

        System.out.println(pq);
        pq.poll();

        System.out.println(pq);
        pq.poll();

        System.out.println(pq);
        System.out.println(pq.peek());        
    }
    
}
